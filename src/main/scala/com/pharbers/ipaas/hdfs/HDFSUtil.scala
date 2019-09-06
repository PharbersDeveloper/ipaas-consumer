package com.pharbers.ipaas.hdfs

import java.io.InputStream
import java.net.URI

import org.apache.commons.lang3.StringUtils
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs._
import org.apache.hadoop.io.IOUtils

object HDFSUtil {
	
	val hdfsUrl = "hdfs://192.168.100.137:9000"
	var realUrl = ""
	
	def mkdir(dir : String) : Boolean = {
		var result = false
		if (StringUtils.isNoneBlank(dir)) {
			realUrl = hdfsUrl + dir
			val config = new Configuration()
			val fs = FileSystem.get(URI.create(realUrl), config)
			if (!fs.exists(new Path(realUrl))) {
				fs.mkdirs(new Path(realUrl))
			}
			fs.close()
			result = true
		}
		result
	}
	
	def deleteHDFSFile(hdfsFile : String) : Boolean = {
		var result = false
		if (StringUtils.isNoneBlank(hdfsFile)) {
			realUrl = hdfsUrl + hdfsFile
			val config = new Configuration()
			val hdfs = FileSystem.get(URI.create(realUrl), config)
			val path = new Path(realUrl)
			val isDeleted = hdfs.delete(path, true)
			hdfs.close()
			result = isDeleted
		}
		result
	}
	
	def uploadLocalFile2HDFS(localFile : String, hdfsFile : String) : Boolean = {
		var result = false
		if (StringUtils.isNoneBlank(localFile) && StringUtils.isNoneBlank(hdfsFile)) {
			realUrl = hdfsUrl + hdfsFile
			val config = new Configuration()
			val hdfs = FileSystem.get(URI.create(hdfsUrl), config)
			val src = new Path(localFile)
			val dst = new Path(realUrl)
			hdfs.copyFromLocalFile(src, dst)
			hdfs.close()
			result = true
		}
		result
	}
	
	def uploadStream2HDFS(in: InputStream, hdfsFile : String): Boolean = {
		var result = false
		if (StringUtils.isNoneBlank(hdfsFile)) {
			realUrl = hdfsUrl + hdfsFile
			val config = new Configuration()
			config.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");
			val hdfs = FileSystem.get(URI.create(hdfsUrl), config)
			val out = hdfs.create(new Path(realUrl))
			IOUtils.copyBytes(in, out, 4096, true)
			hdfs.close()
			result = true
		}
		result
	}
}
