package com.pharbers.ipaas.hdfs

import com.aliyun.oss.OSSClientBuilder
import org.scalatest.FunSuite

class TestHDFS extends FunSuite {
	test("local2hdfs") {
		val dir = "/test/alex/temp"
		val localFile = "/Users/qianpeng/Desktop/mqtt.yml"
		val remoteFile = dir + "/mqtt.yml"
		
		HDFSUtil.uploadLocalFile2HDFS(localFile, remoteFile)
	}
	
	test("stream2hdfs") {
		// Endpoint以杭州为例，其它Region请按实际情况填写。
		val endpoint = "oss-cn-beijing.aliyuncs.com";
		// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
		val accessKeyId = "LTAIEoXgk4DOHDGi"
		val accessKeySecret = "x75sK6191dPGiu9wBMtKE6YcBBh8EI"
		val bucketName = "pharbers-sandbox"
		val objectName = "tm-export/060fa9f3-dcd8-4fd3-95ce-8f682eaa4309.xlsx"
		
		// 创建OSSClient实例。
		val ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
		
		
		// ossObject包含文件所在的存储空间名称、文件名称、文件元信息以及一个输入流。
		val ossObject = ossClient.getObject(bucketName, objectName);
		
		val dir = "/test/alex/temp2"
		val remoteFile = dir + "/060fa9f3-dcd8-4fd3-95ce-8f682eaa4309.xlsx"
		HDFSUtil.uploadStream2HDFS(ossObject.getObjectContent, remoteFile)
		// 关闭OSSClient。
		ossClient.shutdown();
		
	}
}
