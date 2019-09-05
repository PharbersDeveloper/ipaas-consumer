package com.pharbers.ipaas.kafka

import com.pharbers.kafka.consumer.PharbersKafkaConsumer
import com.pharbers.kafka.schema.ListeningSandBoxOss
import org.apache.kafka.clients.consumer.ConsumerRecord

case class ListeningSandBoxOssTopic(topic: List[String], group: String) {
	def start(): Unit = {
		val pkc = new PharbersKafkaConsumer[String, ListeningSandBoxOss](topic, 1000, Int.MaxValue, process, group)
		try {
			val t = new Thread(pkc)
			t.start()
		} catch {
			case e: Exception =>
				println(e.getMessage)
				pkc.close()
		}
	}
	
	def process(record: ConsumerRecord[String, ListeningSandBoxOss]): Unit = {
		println(record.value().toString)
		
	}
	
}
