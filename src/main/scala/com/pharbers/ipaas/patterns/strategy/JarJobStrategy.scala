package com.pharbers.ipaas.patterns.strategy

import com.pharbers.common.cmd.ShellCmdExec
import com.pharbers.ipaas.model.JobConfig
import com.pharbers.kafka.producer.PharbersKafkaProducer
import com.pharbers.kafka.schema.JobResponse

case class JarJobStrategy(config: JobConfig) extends StrategyTrait(){
	override def DoExecute(): Unit = {
		println("exec Jar")
		val cmd = s"spark-submit${config.toString}"
		ShellCmdExec(cmd).execute()
		println(cmd)
//		val jobResponse = new JobResponse()
//		jobResponse.put("JobId", "000000000000000000")
//		val pkp = new PharbersKafkaProducer[String, JobResponse]
//		pkp.produce("cjob-test", "value", jobResponse)
	}
}
