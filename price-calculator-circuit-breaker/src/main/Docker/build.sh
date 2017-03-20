#! /bin/bash -e

rm -fr build
mkdir build
cp ../build/libs/sprice-calculator-circuit-breaker-0.0.1-SNAPSHOT.jar build

docker build -t sb_web .