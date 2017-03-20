#! /bin/bash -e

rm -fr build
mkdir build
cp ../build/libs/price-calculator-microservice-0.0.1-SNAPSHOT.jar build

docker build -t ms_web .