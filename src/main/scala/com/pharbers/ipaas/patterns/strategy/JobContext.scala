package com.pharbers.ipaas.patterns.strategy

import com.pharbers.ipaas.model.JobConfig

case class JobContext(config: JobConfig) {
	def mapping(): StrategyTrait = {
		config.JobType match {
			case "Py" => PythonJobStrategy(config)
			case "R" => RJobStrategy(config)
			case "Jar" => JarJobStrategy(config)
			case _ => ???
		}
	}
	
	def DoExecute(): Unit = {
		val strategy = mapping()
		strategy.DoExecute()
	}
}
