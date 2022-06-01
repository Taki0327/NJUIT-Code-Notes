#!/bin/bash
for i in $(seq 1 10000)
do
    d=$(date +%Y%m%d%H%M)
    echo "$d""--------$i" >> /home/hadoop/logGen.log
    sleep 1s
done
