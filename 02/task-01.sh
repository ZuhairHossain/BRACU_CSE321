#!/bin/bash

## Write a shell script which takes 10 integers as input from the user. Then calculate the sum of those integers which are multiple of 2 but not multiple of 8. Print the sum as an output.
sum=0
for i in {1..10..1}
  do
     read -p "Enter a number: " num
     if (( $num % 2 == 0  && $num % 8 != 0))
     then
        sum=$(( $sum + $num ))
     fi
 done
 echo $sum