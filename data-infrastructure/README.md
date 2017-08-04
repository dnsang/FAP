Setup Dev:

Start ZooKeeper
docker run --name fap-zk --restart always -d zkidkid/zookeeper
Start Kafka
docker run --name fap-kafka --restart always -p 9092:9092 -e KAFKA_HEAP_OPTS=-Xmx1g  --log-opt max-size=10m --log-opt max-file=5 --link fap-zk:zk -d zkidkid/kafka kafka-server -z zk:2181 -D broker.id=0 -D advertised.host.name=127.0.0.1
