# write a shell script that will take a number of inputs that the user will take and then sort the inputs. {Hint: to use an array in bash, use this command “$ declare -A my_array”} 

#!/bin/bash
echo "Please enter the size of an array"
read length
read -a my_array 

sort_check=1

for (( i=0;i<$length-1;i++ ))
do
    sort_check=0
    for (( j=0;j<$length-1-$i;j++ ))
    do
        if (( ${my_array[$j]} > ${my_array[$((j+1))]} ))
        then
            temp=${my_array[j]}
            my_array[$j]=${my_array[$((j+1))]}
            my_array[$((j+1))]=$temp
            sort_check=1
        fi
    done

    if ((sort_check == 0))
    then
        break
    fi
done
echo "${my_array[*]}"