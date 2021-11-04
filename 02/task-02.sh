# First prompt the user for a number.

# → Print ""Rasengan" if the number is neither a multiple of 4 nor a multiple of 5 but divisible by 10.

# → Print "Oodama Rasengan" if the number is a multiple of either 5 or 6 but not with both.

# → Print "Rasen Shuriken" if the number is a multiple of both 5 and 6

#!/bin/bash

read -p "Enter a number: " num

if (( $num % 4 != 0  && $num % 5 != 0 && $num % 10 == 0))
then
    echo "Rasengan"

elif (( $num % 5 == 0  || $num % 6 == 0))
    then
        if (( $num % 5 == 0  && $num % 6 == 0))
        then 
            echo "Rasen Shuriken"
        else
            echo "Oodama Rasengan"
        fi
    fi

