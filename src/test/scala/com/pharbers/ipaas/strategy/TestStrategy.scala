package com.pharbers.ipaas.strategy

import com.google.gson.Gson
import com.pharbers.ipaas.model.JobConfig
import com.pharbers.ipaas.patterns.strategy.JobContext
import org.scalatest.FunSuite

class TestStrategy extends FunSuite {
	test("strategy") {
		val str =
			"""
			  |{"jobType": "Jar"}
			""".stripMargin
		val gson = new Gson
		val c = gson.fromJson(str, classOf[JobConfig])
		println(c.toString)
		val context = JobContext(c)
		context.DoExecute()
	}
}
