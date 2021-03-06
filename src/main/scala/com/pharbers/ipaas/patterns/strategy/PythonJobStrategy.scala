package com.pharbers.ipaas.patterns.strategy

import com.pharbers.common.cmd.ShellCmdExec
import com.pharbers.ipaas.model.JobConfig

case class PythonJobStrategy(config: JobConfig) extends StrategyTrait {
	override def DoExecute(): Unit = {
		println("exec Py")
		ShellCmdExec("").execute()
	}
}
