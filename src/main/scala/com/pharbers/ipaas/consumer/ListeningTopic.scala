package com.pharbers.ipaas.consumer

import com.pharbers.ipaas.patterns.strategy.JobContext
import com.pharbers.kafka.consumer.PharbersKafkaConsumer
import org.apache.kafka.clients.consumer.ConsumerRecord
import com.pharbers.kafka.schema.JobResponse

case class ListeningTopic(topic: List[String]) {
	def start(): Unit = {
		val pkc = new PharbersKafkaConsumer[String, JobResponse](topic, 1000, Int.MaxValue, process)
		val t = new Thread(pkc)
		try {
			t.start()
		} catch {
			case e: Exception => println(e.getMessage)
		}
	}
	
	def process(record: ConsumerRecord[String, JobResponse]): Unit = {
		val context = JobContext(record.value().get("jobType").toString)
		context.DoExecute()
	}
}
