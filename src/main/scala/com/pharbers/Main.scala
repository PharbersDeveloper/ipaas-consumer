package com.pharbers

import java.util.concurrent.locks.ReentrantLock

import com.pharbers.ipaas.consumer.ListeningTopic

import scala.xml.XML

object Main {
	def main(args: Array[String]): Unit = {
		val config = sys.env("IPAAS_CONSUMER_KAFKACONFIG")
		val xml = XML.load(config)
		val topics = List((xml \ "kafka-config" \ "topics" \"@value").toString())
		ListeningTopic(topics).start()
		// 测试用，先锁住，该方法有极大的问题
		val lock = new ReentrantLock(true)
		lock.lock()
	}
}
