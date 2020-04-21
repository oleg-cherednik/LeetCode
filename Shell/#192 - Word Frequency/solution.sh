#!/bin/bash
#2020.04.20
declare -A map

while IFS= read -r line
do
  for word in $line
  do
    let map[$word]=${map[$word]}+1
  done
done < words.txt

for word in ${!map[@]}
do
  echo $word ${map[$word]}
done | sort -rn -k2
