package com.pharbers.ipaas.patterns.strategy

import com.pharbers.common.cmd.ShellCmdExec

case class PythonJobStrategy() extends StrategyTrait {
	override def DoExecute(): Unit = {
		println("exec Py")
		ShellCmdExec("").execute()
	}
}
