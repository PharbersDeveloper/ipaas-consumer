package com.pharbers.common.cmd

import scala.sys.process._

case class ShellCmdExec(cmd: String) {
	 def execute(): Unit = {
		 cmd.run()
//		 cmd.!
	}
}
