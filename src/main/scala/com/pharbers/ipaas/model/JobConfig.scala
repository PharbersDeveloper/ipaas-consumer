package com.pharbers.ipaas.model

case class JobConfig(Name: String, Class:String, Master: String,
                     DeployMode: String, ExecutorMemory: String,
                     ExecutorCores: String, NumExecutors: String,
                     Queue: String, Target: String,
                     Parameters: String, JobType: String,
                     Files: String) {
	
	override def toString: String = {
		val jar =
			"""
			  |--conf spark.yarn.appMasterEnv.PHA_CONF_HOME=
			  |""".stripMargin
		s"""
		  |${if (Name != ""){ s"--name $Name" }else{""}}
		  |${if (Class != ""){ s"--class $Class" }else{""}}
		  |${if (Master != ""){ s"--master $Master" }else{""}}
		  |--deploy-mode ${DeployMode}
		  |--executor-memory ${ExecutorMemory}
		  |--executor-cores ${ExecutorCores}
		  |--num-executors ${NumExecutors}
		  |${if (JobType == "Jar") { jar }else{""}}
		  |${if (Files != ""){ s"--files $Files" }else{""}}
		  |${if (Queue != ""){ s"--queue $Queue" }else{""}}
		  |${if (Target != ""){ s"$Target" }else{""}}
		  |${if (Parameters != ""){ s"$Parameters" }else{""}}
		  |""".stripMargin.replaceAll("\n", " ")
	}
}
