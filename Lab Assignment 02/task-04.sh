# Write a shell script that takes 3 integers as input from the user. Depending on some comparisons, you need to carry out three operations: addition ( + ), subtraction ( - ) and multiplication ( * )

# Each of these operations will be implemented in separate methods.

# If the first number is greater than the second number, do subtraction and print the result.

# If the third number is less than the second number, do addition and print the result.

# If the second number is equal to the third number, do multiplication and print the result.

#!/bin/bash

echo "Enter first number "
read num1

echo "Enter second number "
read num2

echo "Enter third number "
read num3

if (( $num1 > $num2 ))
then
    c=$(( $num1 - $num2))
    echo $c
    
elif (( $num3 < $num2 ))
then
    c=$(( $num3 + $num2))
    echo $c

elif (( $num2 == $num3 ))
then
    c=$(( $num3 * $num2))
    echo $c

else
    echo "wrong input"
fi