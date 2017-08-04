#!/bin/bash

CONFIG_FILE="/opt/kafka/config/server.properties"
ZOOKEEPER="zk:2181"
ADV_HOST=0.0.0.0
ADV_PORT=9092
LOGDIR="/opt/kafka/data"

declare -A otherConfig

while [[ $# -gt 1 ]]
do
key="$1"

IFS='='

case $key in
    -c|--config)
    CONFIG_FILE="$2"
    shift # past argument
    ;;
    -z|--zookeeper)
    ZOOKEEPER="$2"
    shift # past argument
    ;;
    -p|--port)
	ADV_PORT="$2"
	shift
    ;;
    -D)
	read -a PAIR <<< "$2"
	# echo "${PAIR[@]}"
	if [ ${#PAIR[@]} -ne 2 ]; then 
		echo "Custom configuration must be declare as -D <key>=<value>"
		exit 1
	fi
	otherConfig[${PAIR[0]}]=${PAIR[1]}
	shift # past argument
	;;
	--logdir)
	LOGDIR="$2"
	shift
	;;
	--logdirs)
	LOGDIRS="$2"
	shift
	;;
    *)
            # unknown option
    ;;
esac
shift # past argument or value
done

echo "CONFIG_FILE=$CONFIG_FILE"
echo "ZOOKEEPER=$ZOOKEEPER"

#Change zookeeper host:port
sed -i "s,zookeeper.connect=.*,zookeeper.connect=$ZOOKEEPER,g" $CONFIG_FILE

#Change advertised host
grep -q -E "^#?advertised.host.name=" $CONFIG_FILE && \
	sed -r -i "s,#?advertised.host.name=.*,advertised.host.name=$ADV_HOST,g" $CONFIG_FILE \
	|| echo "advertised.host.name=$ADV_HOST" >> $CONFIG_FILE

#Change log.dir
grep -q -E "^#?log.dir=" $CONFIG_FILE && \
	sed -r -i "s,#?log.dir=.*,log.dir=$LOGDIR,g" $CONFIG_FILE \
	|| echo "log.dir=$LOGDIR" >> $CONFIG_FILE

#Change log.dirs
grep -q -E "^#?log.dirs=" $CONFIG_FILE && \
	sed -r -i "s,#?log.dirs=.*,log.dirs=$LOGDIR,g" $CONFIG_FILE \
	|| echo "log.dirs=$LOGDIR" >> $CONFIG_FILE

#Change advertised port
grep -q -E "^#?advertised.port=" $CONFIG_FILE && \
	sed -r -i "s,#?advertised.port=.*,advertised.port=$ADV_PORT,g" $CONFIG_FILE \
	|| echo "advertised.port=$ADV_PORT" >> $CONFIG_FILE

#Change others config
for k in "${!otherConfig[@]}"
do
	grep -q -E "^#?${k}=" $CONFIG_FILE && \
		sed -r -i "s/#?(${k})=(.*)/\1=${otherConfig[$k]}/g" $CONFIG_FILE \
		|| echo "${k}=${otherConfig[$k]}" >> $CONFIG_FILE
done

exec /opt/kafka/bin/kafka-server-start.sh $CONFIG_FILE

