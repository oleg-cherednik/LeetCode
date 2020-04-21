#!/bin/bash
#2020.04.22
declare -a arr

while IFS= read -r line
do
    i=0

    for word in $line
    do
        [[ ${arr[$i]} ]] && arr[$i]="${arr[$i]} $word" || arr[$i]=$word
        ((i++))
    done
done < file.txt

for ((i=0; i < ${#arr[@]}; i++))
do
    echo ${arr[i]}
done

