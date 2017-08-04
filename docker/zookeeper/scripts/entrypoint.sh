#!/bin/bash
set -e

[[ "$1" == "zookeeper" ]] && {
	echo "Start ZooKeeper server"
	exec /opt/zookeeper/bin/zkServer.sh start-foreground
}

exec "$@"

