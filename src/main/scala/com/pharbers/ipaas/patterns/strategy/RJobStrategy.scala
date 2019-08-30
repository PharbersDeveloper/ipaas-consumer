package com.pharbers.ipaas.patterns.strategy

import com.pharbers.common.cmd.ShellCmdExec
import com.pharbers.ipaas.model.JobConfig

case class RJobStrategy(config: JobConfig) extends StrategyTrait {
	override def DoExecute(): Unit = {
		println("exec R")
		val cmd = s"spark-submit${config.toString}"
		println(cmd)
		ShellCmdExec(cmd).execute()
	}
}
