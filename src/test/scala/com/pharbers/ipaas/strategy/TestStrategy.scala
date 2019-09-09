package com.pharbers.ipaas.strategy

import com.pharbers.ipaas.model
import com.pharbers.ipaas.patterns.strategy.JobContext
import org.scalatest.FunSuite

class TestStrategy extends FunSuite {
	test("strategy") {
		val c = model.JobConfig(
			"MAX-Submit",
			"com.pharbers.max.submit.Main",
			"yarn",
			"cluster",
			"2G",
			"1",
			"1",
			"default",
			"hdfs:///test/dcs/job/max-context-Json.jar",
			"""hdfs:///test/dcs/job/MZmax.yaml 0000001 "0 1 2" """,
			"Jar",
			"hdfs:///test/dcs/job/kafka_config.xml,hdfs:///test/dcs/job/kafka.broker1.truststore.jks,hdfs:///test/dcs/job/kafka.broker1.keystore.jks",
			"spark.yarn.appMasterEnv.PHA_CONF_HOME=,spark.driver.extraClassPath=./__app__.jar",
			"参数"
		)
		
		val context = JobContext(c)
		context.DoExecute()
		Thread.sleep(60 * 1000 * 10)
	}
}
