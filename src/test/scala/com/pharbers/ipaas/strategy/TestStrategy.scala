package com.pharbers.ipaas.strategy

import com.pharbers.ipaas.patterns.strategy.JobContext
import org.scalatest.FunSuite

class TestStrategy extends FunSuite {
	test("strategy") {
		val context = JobContext("Jar")
		context.DoExecute()
	}
}
