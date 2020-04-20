#!/bin/bash
while ((i++)); read -r line
do
  if [[ $i = 10 ]]; then
    echo "$line"
	break
  fi
done < "file.txt"

