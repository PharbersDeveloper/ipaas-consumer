package com.pharbers.ipaas.patterns.strategy

import com.pharbers.common.cmd.ShellCmdExec
import com.pharbers.ipaas.model.JobConfig

case class JarJobStrategy(config: JobConfig) extends StrategyTrait(){
	override def DoExecute(): Unit = {
		println("exec Jar")
		val cmd = s"spark-submit${config.toString}"
		println(cmd)
		ShellCmdExec(cmd).execute()
	}
}
