#!/bin/bash

cd ./contrib/ || exit 1

docker-compose up -d

cd ../

docker build --rm=true -t spark-app-lab5 ./

docker run --net contrib_default --link spark-master:spark-master spark-app-lab5
