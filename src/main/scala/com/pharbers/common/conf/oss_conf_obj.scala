package com.pharbers.common.conf

import com.pharbers.baseModules.PharbersInjectModule

object oss_conf_obj extends PharbersInjectModule {
	override val id: String = "oss-config"
	override val configPath: String = "pharbers_config/oss_config.xml"
	override val md = "endpoint":: "accessKeyId" :: "accessKeySecret" :: "bucketName" :: Nil
	
	lazy val endpoint: String = config.mc.find(p => p._1 == "endpoint").get._2.toString
	lazy val accessKeyId: String = config.mc.find(p => p._1 == "accessKeyId").get._2.toString
	lazy val accessKeySecret: String = config.mc.find(p => p._1 == "accessKeySecret").get._2.toString
	lazy val bucketName: String = config.mc.find(p => p._1 == "bucketName").get._2.toString
}
