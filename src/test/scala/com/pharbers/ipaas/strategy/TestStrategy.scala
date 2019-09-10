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
			"",//2G
			"",//1
			"",//1
			"default",
			"hdfs:///test/dcs/job/max-context-Json.jar",
			"""hdfs:///test/dcs/job/MZmax.yaml 0000001 {"companyId":"5ca069bceeefcc012918ec72","cpa":"hdfs:///data/nhwa/pha_config_repository1809/Nhwa_201809_CPA_20181126.csv","mkt":"麻醉市场","ym":"201809","date":"201809","missHospPath":"hdfs:///repository/miss_hosp/5ca069bceeefcc012918ec72","notPublishHosp":"hdfs:///repository/not_published_hosp/5ca069bceeefcc012918ec72","fullHosp":"hdfs:///repository/full_hosp/5ca069bceeefcc012918ec72/20180629","sampleHosp":"hdfs:///repository/sample_hosp/5ca069bceeefcc012918ec72/mz","universe":"hdfs:///repository/universe_hosp/5ca069bceeefcc012918ec72/mz"}""",
			"Jar",
			"hdfs:///test/dcs/job/kafka_config.xml,hdfs:///test/dcs/job/kafka.broker1.truststore.jks,hdfs:///test/dcs/job/kafka.broker1.keystore.jks",
			"spark.yarn.appMasterEnv.PHA_CONF_HOME=,spark.driver.extraClassPath=./__app__.jar",
			""
		)
		
		val context = JobContext(c)
		context.DoExecute()
		Thread.sleep(60 * 1000 * 10)
	}
}
