package com.pharbers.ipaas.model

case class JobConfig(Name: String,
                     Class:String,
                     Master: String,
                     DeployMode: String,
                     ExecutorMemory: String,
                     ExecutorCores: String,
                     NumExecutors: String,
                     Queue: String,
                     Target: String,
                     Parameters: String,
                     JobType: String,
                     Files: String,
                     Conf: String) {
	
	// 太丑了，第一波结束后换成builder @Alex 留
	override def toString: String = {
		val conf = Conf match {
			case null => ""
			case s =>
				s.split(",").toList match {
					case Nil => return ""
					case c => c.map(s => s"--conf $s ").reduce((a, b) => a + b)
				}
		}

		// --conf spark.yarn.appMasterEnv.PHA_CONF_HOME=
		s"""
		  |${if (Name != "" && Name != null){ s"--name $Name" }else{""}}
		  |${if (Class != "" && Class != null){ s"--class $Class" }else{""}}
		  |${if (Master != "" && Master != null){ s"--master $Master" }else{""}}
		  |--deploy-mode $DeployMode
		  |--executor-memory $ExecutorMemory
		  |--executor-cores $ExecutorCores
		  |--num-executors $NumExecutors
		  |${conf}
		  |${if (Files != "" && Files != null){ s"--files $Files" }else{""}}
		  |${if (Queue != "" && Queue != null){ s"--queue $Queue" }else{""}}
		  |${if (Target != "" && Target != null){ s"$Target" }else{""}}
		  |${if (Parameters != "" && Parameters != null){ s"$Parameters" }else{""}}
		  |""".stripMargin.replaceAll("\n", " ")
	}
}
