package com.pharbers.ipaas.model

case class JobConfig(`class`:String, master: String,
                     deployMode: String, driverMemory: String,
                     target: String, parameter: String) {
	
	override def toString: String = {
		s"""
		  |--class ${`class`}
		  |--master ${master}
		  |--deploy-mode ${deployMode}
		  |--executor-memory ${driverMemory}
		  |--num-executors ${1}
		  |${target}
		  |${parameter}
		  |""".stripMargin
	}
}
