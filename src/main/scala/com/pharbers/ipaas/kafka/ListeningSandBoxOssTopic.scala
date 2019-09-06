package com.pharbers.ipaas.kafka

import com.aliyun.oss.OSSClientBuilder
import com.pharbers.ipaas.hdfs.HDFSUtil
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
	
	// 周六提出来
	def process(record: ConsumerRecord[String, ListeningSandBoxOss]): Unit = {
		val ossPath = record.value().get("Path").toString.split("/").toList
		println(ossPath.tail.mkString("/"))
		
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		val endpoint = "oss-cn-beijing.aliyuncs.com";
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		val accessKeyId = "LTAIEoXgk4DOHDGi"
		val accessKeySecret = "x75sK6191dPGiu9wBMtKE6YcBBh8EI"
		val bucketName = "pharbers-sandbox"
		val objectName = ossPath.tail.mkString("/")

		// 创建OSSClient实例。
		val ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		// ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
		val ossObject = ossClient.getObject(bucketName, objectName);

		HDFSUtil.uploadStream2HDFS(ossObject.getObjectContent, "/" + record.value().get("Path").toString)
		// 关闭OSSClient。
		ossClient.shutdown();
	}
	
}
