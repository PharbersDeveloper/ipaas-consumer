package com.pharbers.common.cmd

import scala.sys.process._

case class ShellCmdExec(cmd: String) {
	 def execute(): Int = {
		try {
			cmd.!!
			0
		} catch {
			case e : Exception =>
				println(e.getMessage)
				1
		}
	}
}
