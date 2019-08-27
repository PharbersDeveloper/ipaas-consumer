package com.pharbers.ipaas.model

class JobConfig {
	
	override def toString: String = {
		"""
		  |--class org.apache.spark.examples.SparkPi
		  |--master yarn
		  |--deploy-mode cluster
		  |--executor-memory 1G
		  |--num-executors 1
		  |hdfs:///test/alex/spark-examples_2.11-2.3.0.jar
		  |""".stripMargin
	}
}
