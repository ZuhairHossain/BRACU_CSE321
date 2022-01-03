# Write a shell script that takes an integer as the input and checks whether the number is a Happy Prime or not.

# Learn more about Happy Primes:

# https://prime-numbers.info/article/happy-primes

# 1. taking an number input
# 2. calc rem by dividing 10
# 3. calc the square & add to val sum
# check -> if 1 :D (happy)
#           else if 4 :'( (not happy = sad)

echo "Enter a number: "
read num

val=$num

while [ $val != 1 ] && [ $val != 4 ]
do
  sum=0
  rem=0
    while [ $val -gt 0 ]
        do
            rem=$(($val % 10))
            val=$(($val / 10))
            temp=$(($rem * $rem))
            sum=$(($sum + $temp))
    done

    val=$sum
done

if (( $val == 1 ))
then 
    echo "$num is a happy number"

elif (( $val == 4 ))
then 
    echo "$num is not a happy number"
fi
