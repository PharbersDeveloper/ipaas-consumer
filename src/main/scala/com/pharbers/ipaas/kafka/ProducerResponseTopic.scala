package com.pharbers.ipaas.kafka

import com.pharbers.kafka.producer.PharbersKafkaProducer
import com.pharbers.kafka.schema.JobResponse

case class ProducerResponseTopic(topic: String, jobResponse: JobResponse) {

}
