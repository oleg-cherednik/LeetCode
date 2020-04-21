#!/bin/bash
#2020.04.20
while ((i++)); read -r line
do
  if [[ $i = 10 ]]; then
    echo "$line"
	break
  fi
done < "file.txt"

