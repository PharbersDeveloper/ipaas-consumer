package com.pharbers.ipaas.kafka

import java.io.File
import java.util.concurrent.TimeUnit
import com.pharbers.kafka.producer.PharbersKafkaProducer
import org.apache.avro.Schema
import org.apache.avro.generic.{GenericData, GenericRecord}
import org.scalatest.FunSuite

class TestKafka extends FunSuite{
	test("Producer") {
		val sche: Schema = Schema.parse(new File("src/main/avro/job.avsc"))
		val gr: GenericRecord = new GenericData.Record(sche)
		
		val pkp = new PharbersKafkaProducer[String, GenericRecord]
		gr.put("jobType", "Jar")
		gr.put("master", "yarn")
		gr.put("deployMode", "cluster")
		gr.put("driverMemory", "1G")
		gr.put("executorMemory", "1G")
		gr.put("executorCores", "1")
		gr.put("queue", "default")
		gr.put("target", "/test/alex/spark-examples_2.11-2.3.0.jar")
		gr.put("config", "/test/MZclean.yaml")
		
		val fu = pkp.produce("cjob", "value", gr)
		println(fu.get(10, TimeUnit.SECONDS))
	}
}
