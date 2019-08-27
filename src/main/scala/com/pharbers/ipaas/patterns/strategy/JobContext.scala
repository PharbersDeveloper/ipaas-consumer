package com.pharbers.ipaas.patterns.strategy

case class JobContext(job_type: String) {
	def mapping(): StrategyTrait = {
		job_type match {
			case "Py" => PythonJobStrategy()
			case "R" => RJobStrategy()
			case "Jar" => JarJobStrategy()
			case _ => ???
		}
	}
	
	def DoExecute(): Unit = {
		val strategy = mapping()
		strategy.DoExecute()
	}
}
