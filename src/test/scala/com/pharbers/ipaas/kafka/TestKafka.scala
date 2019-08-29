package com.pharbers.ipaas.kafka

import java.io.File
import java.util.concurrent.TimeUnit

import com.google.gson.Gson
import com.pharbers.ipaas.model.JobConfig
import com.pharbers.kafka.producer.PharbersKafkaProducer
import org.apache.avro.Schema
import org.apache.avro.generic.{GenericData, GenericRecord}
import org.scalatest.FunSuite

class TestKafka extends FunSuite{
	test("Producer") {
		val sche: Schema = Schema.parse(new File("src/main/avro/job_request.avsc"))
		val gr: GenericRecord = new GenericData.Record(sche)

		val pkp = new PharbersKafkaProducer[String, GenericRecord]
		gr.put("jobType", "Jar")
		gr.put("class", "org.apache.spark.examples.SparkPi")
		gr.put("master", "yarn")
		gr.put("deployMode", "cluster")
		gr.put("executorMemory", "1G")
		gr.put("executorCores", "1")
		gr.put("queue", "default")
		gr.put("target", "hdfs:///test/alex/spark-examples_2.11-2.3.0.jar")
		gr.put("parameter", "1000")

		val fu = pkp.produce("cjob", "value", gr)
		println(fu.get(10, TimeUnit.SECONDS))
	}
	
	test("Producer Reg") {
		val sche: Schema = Schema.parse(new File("src/main/avro/job_request.avsc"))
		val gr: GenericRecord = new GenericData.Record(sche)
		
		val pkp = new PharbersKafkaProducer[String, GenericRecord]
		gr.put("JobType", "Jar")
		gr.put("Class", "com.pharbers.ipaas.data.driver.Main")
		gr.put("Master", "yarn")
		gr.put("DeployMode", "cluster")
		gr.put("ExecutorMemory", "1G")
		gr.put("ExecutorCores", "1")
		gr.put("NumExecutors", "1")
		gr.put("Queue", "default")
		gr.put("Target", "hdfs:///jars/context/job-context.jar")
		gr.put("Parameter", "yaml hdfs hdfs:///test/MZclean.yaml")
		
		println(gr.toString)
		
//		1 to 10 foreach { _ =>
//			val fu = pkp.produce("cjob-test", "", gr)
//			println(fu.get(10, TimeUnit.SECONDS))
//		}
		val fu = pkp.produce("cjob-test", "", gr)
		println(fu.get(10, TimeUnit.SECONDS))
	}
	
	test("parsing") {
		val str =
			"""
			  |{"JobType": "Jar", "Class": "com.pharbers.ipaas.Main", "Master": "yarn", "DeployMode": "cluster", "DriverMemory": "1G", "Target": "xxx.jar", "Parameter": "yaml hdfs hdfs:///xxx/xx/xx.jar"}
			""".stripMargin
		val gson = new Gson
		val c = gson.fromJson(str, classOf[JobConfig])
		println(c.toString)
	}
}
