# Docker Image里面mvn构建太慢了，网速硬伤，直接在本地吧Scala项目打成jar放入镜像

FROM pharbers/spark-2.3.0-bin-hadoop2.7:1.1

RUN apt-get update \
	&& apt-get clean \
	&& apt-get install -f -y git wget

ENV IPAASCONSUMERHOME=/app
ENV IPAASCONSUMERKAFKACONFIG=${IPAASCONSUMERHOME}/kafka_config.xml

#Scala micro-service-libs库需要，就离谱哦，lib包里面还有直接获取运行地址的
ENV PHA_CONF_HOME=""

WORKDIR /home/spark/github/ESNTMRCal

RUN git clone -b alfred-对数 https://github.com/PharbersDeveloper/NTMRCal.git

WORKDIR ${IPAASCONSUMERHOME}

# 本地打包
RUN wget https://raw.githubusercontent.com/PharbersDeveloper/ipaas-consumer/master/pharbers_config/kafka_config.xml
COPY ./job-submit.jar  .

ENTRYPOINT ["java", "-jar", "job-submit.jar"]

