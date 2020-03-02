package com.pharbers.ipaas.kafka

import com.pharbers.kafka.consumer.PharbersKafkaConsumer
import com.pharbers.kafka.schema.{JobResponse, ListeningJobTask}
import org.apache.kafka.clients.consumer.ConsumerRecord

case class ListeningTaskTopic(topic: List[String]) {
	def start(): Unit = {
		val pkc = new PharbersKafkaConsumer[String, ListeningJobTask](topic, 1000, Int.MaxValue, process)
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
		jobResponse.setJobId(record.value().getJobId)
		jobResponse.setStatus(record.value().getStatus)
		jobResponse.setMessage(record.value().getMessage)
		jobResponse.setProgress(record.value().getProgress)
		ProducerAvroTopic("cjob-response", jobResponse)
	}
	
}
