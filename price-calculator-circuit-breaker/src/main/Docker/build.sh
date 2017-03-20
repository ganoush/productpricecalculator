#! /bin/bash -e

rm -fr build
mkdir build
cp ../build/libs/price-calculator-circuit-breaker-0.0.1-SNAPSHOT.jar build

docker build -t ct_web .