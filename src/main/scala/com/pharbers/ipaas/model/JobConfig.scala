package com.pharbers.ipaas.model

case class JobConfig(Class:String, Master: String,
                     DeployMode: String, ExecutorMemory: String,
                     ExecutorCores: String, NumExecutors: String,
                     Queue: String, Target: String,
                     Parameter: String, JobType: String) {
	
	override def toString: String = {
		s"""
		  |--class ${Class}
		  |--master ${Master}
		  |--deploy-mode ${DeployMode}
		  |--executor-memory ${ExecutorMemory}
		  |--executor-cores ${ExecutorCores}
		  |--num-executors ${NumExecutors}
		  |--queue ${Queue}
		  |${Target}
		  |${Parameter}
		  |""".stripMargin.replaceAll("\n", " ")
	}
}
