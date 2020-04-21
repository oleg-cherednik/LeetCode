#!/bin/bash
#2020.04.20
regex="^([0-9]{3}-|\([0-9]{3}\)\ )[0-9]{3}-[0-9]{4}$"
while IFS= read -r line
do
  if [[ $line =~ $regex ]]; then
    echo "$line"
  fi
done < "file.txt"
