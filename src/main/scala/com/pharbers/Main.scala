package com.pharbers

import com.pharbers.ipaas.kafka.{ListeningSubmitTopic, ListeningTaskTopic}

import scala.xml.XML

object Main {
	def main(args: Array[String]): Unit = {
		val config = sys.env("IPAASCONSUMERKAFKACONFIG")
		val xml = XML.load(config)
		val topics = List((xml \ "kafka-config" \ "topics" \"@value").toString())
		
		ListeningSubmitTopic(topics).start()
		ListeningTaskTopic("ListeningJobTask" :: Nil).start()
		
		// 测试用，先锁住，该方法有极大的问题
		while (true) { Thread.sleep(10 * 1000) }
	}
}
