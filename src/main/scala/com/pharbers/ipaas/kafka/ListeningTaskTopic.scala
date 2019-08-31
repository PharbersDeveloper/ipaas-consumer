package com.pharbers.ipaas.kafka

import com.pharbers.kafka.consumer.PharbersKafkaConsumer
import com.pharbers.kafka.schema.{JobResponse, ListeningJobTask}
import org.apache.kafka.clients.consumer.ConsumerRecord

case class ListeningTaskTopic(topic: List[String], group: String) {
	def start(): Unit = {
		val pkc = new PharbersKafkaConsumer[String, ListeningJobTask](topic, 1000, Int.MaxValue, process, group)
		try {
			val t = new Thread(pkc)
			t.start()
		} catch {
			case e: Exception =>
				println(e.getMessage)
				pkc.close()
		}
	}
	
	def process(record: ConsumerRecord[String, ListeningJobTask]): Unit = {
		println(record.value().toString)
		val jobResponse = new JobResponse()
		jobResponse.put("JobId", record.value().get("JobId"))
		jobResponse.put("Status", record.value().get("Status"))
		jobResponse.put("Message", record.value().get("Message"))
		jobResponse.put("Progress", record.value().get("Progress"))
		ProducerAvroTopic("cjob-response", jobResponse)
	}
	
}
