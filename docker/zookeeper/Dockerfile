#ZooKeeper

FROM java:openjdk-8-jre

ARG MIRROR=http://apache.mirrors.pair.com
ARG VERSION=3.4.9

LABEL name="zookeeper" version=$VERSION

RUN apt-get install -y wget \
    && wget -q -O - $MIRROR/zookeeper/zookeeper-$VERSION/zookeeper-$VERSION.tar.gz | tar -xzf - -C /opt \
    && ln -s /opt/zookeeper-$VERSION /opt/zookeeper \
    && cp /opt/zookeeper/conf/zoo_sample.cfg /opt/zookeeper/conf/zoo.cfg \
    && sed -i 's$dataDir=.*$dataDir=/data/zookeeper$g' /opt/zookeeper/conf/zoo.cfg \
    && mkdir -p /data/zookeeper

EXPOSE 2181 2888 3888
WORKDIR /opt/zookeeper

ADD scripts/entrypoint.sh /entrypoint.sh

VOLUME ["/opt/zookeeper/conf", "/data/zookeeper"]

ENTRYPOINT ["/entrypoint.sh"]
CMD ["zookeeper"]

