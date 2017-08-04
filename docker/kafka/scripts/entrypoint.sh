#!/bin/bash

set -e

[[ "$1" == "kafka-server" ]] && {
	shift
	exec /usr/bin/start-kafka.sh "$@"
}

exec "$@"

