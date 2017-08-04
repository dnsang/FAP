# Kafka

FROM java:openjdk-8-jre

ENV DEBIAN_FRONTEND noninteractive
ENV SCALA_VERSION 2.11
ENV KAFKA_VERSION 0.10.1.0
ENV KAFKA_HOME /opt/kafka

# Install Kafka and other needed things
RUN apt-get update && \
    apt-get install -y wget && \
    rm -rf /var/lib/apt/lists/* && \
    apt-get clean && \
    wget -q http://apache.mirrors.spacedump.net/kafka/"$KAFKA_VERSION"/kafka_"$SCALA_VERSION"-"$KAFKA_VERSION".tgz -O /tmp/kafka_"$SCALA_VERSION"-"$KAFKA_VERSION".tgz && \
    tar xfz /tmp/kafka_"$SCALA_VERSION"-"$KAFKA_VERSION".tgz -C /opt && \
    ln -s /opt/kafka_"$SCALA_VERSION"-"$KAFKA_VERSION" $KAFKA_HOME && \
    rm /tmp/kafka_"$SCALA_VERSION"-"$KAFKA_VERSION".tgz

ADD scripts/start-kafka.sh /usr/bin/start-kafka.sh
ADD scripts/entrypoint.sh /entrypoint.sh

#9092 is kafka
EXPOSE 9092

VOLUME ["/opt/kafka/config", "/opt/kafka/data"]

ENTRYPOINT ["/entrypoint.sh"]
CMD ["kafka-server"]

