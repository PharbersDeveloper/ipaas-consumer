package com.pharbers.ipaas.kafka

import com.google.gson.Gson
import com.pharbers.ipaas.model.JobConfig
import com.pharbers.ipaas.patterns.strategy.JobContext
import com.pharbers.kafka.consumer.PharbersKafkaConsumer
import com.pharbers.kafka.schema.JobRequest
import org.apache.kafka.clients.consumer.ConsumerRecord

case class ListeningSubmitTopic(topic: List[String], group: String) {
	def start(): Unit = {
		val pkc = new PharbersKafkaConsumer[String, JobRequest](topic, 1000, Int.MaxValue, process, group)
		try {
			val t = new Thread(pkc)
			t.start()
		} catch {
			case e: Exception =>
				println(e.getMessage)
//				pkc.close()
		}
	}
	
	def process(record: ConsumerRecord[String, JobRequest]): Unit = {
		val context = JobContext(new Gson().fromJson(record.value().toString, classOf[JobConfig]))
		context.DoExecute()
	}
}
