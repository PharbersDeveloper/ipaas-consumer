package com.pharbers.ipaas.patterns.strategy

import com.pharbers.common.cmd.ShellCmdExec

case class JarJobStrategy() extends StrategyTrait(){
	override def DoExecute(): Unit = {
		println("exec Jar")
		val cmd =
			s"""spark-submit
			   |--class org.apache.spark.examples.SparkPi
			   |--master yarn
			   |--deploy-mode cluster
			   |--executor-memory 1G
			   |--num-executors 1
			   |hdfs:///test/alex/spark-examples_2.11-2.3.0.jar
			   |""".stripMargin.replaceAll("\n", " ")
		ShellCmdExec(cmd).execute()
	}
}
