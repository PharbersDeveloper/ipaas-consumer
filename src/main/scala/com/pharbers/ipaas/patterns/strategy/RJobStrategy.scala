package com.pharbers.ipaas.patterns.strategy

import com.pharbers.common.cmd.ShellCmdExec

case class RJobStrategy() extends StrategyTrait {
	override def DoExecute(): Unit = {
		println("exec R")
		ShellCmdExec("").execute()
	}
}
