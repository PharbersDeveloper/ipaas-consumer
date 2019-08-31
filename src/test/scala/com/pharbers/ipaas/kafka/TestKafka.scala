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
//		gr.put("JobType", "Jar")
//		gr.put("Class", "com.pharbers.ipaas.data.driver.Main")
//		gr.put("Master", "yarn")
//		gr.put("DeployMode", "cluster")
//		gr.put("ExecutorMemory", "1G")
//		gr.put("ExecutorCores", "1")
//		gr.put("NumExecutors", "1")
//		gr.put("Queue", "default")
//		gr.put("Files", "hdfs:///jars/context/pharbers_config/kafka_config.xml,hdfs:///jars/context/pharbers_config/secrets/kafka.broker1.truststore.jks,hdfs:///jars/context/pharbers_config/secrets/kafka.broker1.keystore.jks")
//		gr.put("Target", "hdfs:///jars/context/job-context.jar")
//		gr.put("Parameter", "yaml hdfs hdfs:///test/MZclean.yaml")
		gr.put("Name", "TM")
		gr.put("JobType", "R")
		gr.put("Class", "")
		gr.put("Master", "yarn")
		gr.put("DeployMode", "cluster")
		gr.put("ExecutorMemory", "1G")
		gr.put("ExecutorCores", "1")
		gr.put("NumExecutors", "1")
		gr.put("Queue", "default")
		gr.put("Conf", "spark.yarn.appMasterEnv.KAFKA_PROXY_URI=http://59.110.31.50:8082/topics,spark.yarn.appMasterEnv.KAFKA_PROXY_R_CAL_TOPIC=listeningJobTask")
		gr.put("Files", "NTM/TMCalColFuncs.R,NTM/TMCalProcess.R,NTM/TMCalResAchv.R,NTM/TMDataCbind.R")
		gr.put("Target", "main.R")
		gr.put("Parameters", "NTM hdfs://192.168.100.137:9000//test/TMTest/inputParquet/TMInputParquet0815/cal_data hdfs://192.168.100.137:9000//test/TMTest/inputParquet/TMInputParquet0815/weightages hdfs://192.168.100.137:9000//test/TMTest/inputParquet/TMInputParquet0815/manager hdfs://192.168.100.137:9000//test/TMTest/inputParquet/TMInputParquet0815/curves-n hdfs://192.168.100.137:9000//test/TMTest/inputParquet/TMInputParquet0815/competitor hdfs://192.168.100.137:9000//test/TMTest/inputParquet/TMInputParquet0815/standard_time hdfs://192.168.100.137:9000//test/TMTest/inputParquet/TMInputParquet0815/level_data 0000000000002")
		println(gr.toString)
		val fu = pkp.produce("cjob-test", "", gr)
		println(fu.get(10, TimeUnit.SECONDS))

//		1 to 10 foreach { _ =>
//			val fu = pkp.produce("cjob-test", "", gr)
//			println(fu.get(10, TimeUnit.SECONDS))
//		}


//		val jobResponse = new JobResponse()
//		jobResponse.put("JobId", "000000000000000000")
//		ProducerAvroTopic("cjob-test2", jobResponse)


//		val jt = new ListeningJobTask()
//		jt.put("JobId", "0000574552")
//		ProducerAvroTopic("listeningJobTask", jt)
	}
	
	
	test("Producer Reg2") {
		val sche: Schema = Schema.parse(new File("src/main/avro/job_request.avsc"))
		val gr: GenericRecord = new GenericData.Record(sche)

		val pkp = new PharbersKafkaProducer[String, GenericRecord]
		gr.put("JobType", "R")
		gr.put("Class", "")
		gr.put("Master", "yarn")
		gr.put("DeployMode", "cluster")
		gr.put("ExecutorMemory", "1G")
		gr.put("ExecutorCores", "1")
		gr.put("NumExecutors", "1")
		gr.put("Queue", "default")
		gr.put("Files", "AddCols.R,CastCol2Double.R,ColMin.R,ColMax.R,ColRename.R,ColSum.R,CurveFunc.R,UCBDataBinding.R,TMCalCurveSkeleton2.R,UCBCalFuncs.R,TMCalResAchv.R")
		gr.put("Target", "")
		gr.put("Parameter", "TMUCBCalMain.R")
		val fu = pkp.produce("cjob-test", "", gr)
		println(fu.get(10, TimeUnit.SECONDS))
	}
	
	
	test("aa"){
//		val conf = Nil
//		val r = conf.map(s => s"--conf $s ").reduce((a, b) => a + b)
//		println(r)
		val str = """{"Name": "Alex", "Master": "yarn"}"""
		val r = new Gson().fromJson(str, classOf[JobConfig]).toString
		println(r)
	}
}
