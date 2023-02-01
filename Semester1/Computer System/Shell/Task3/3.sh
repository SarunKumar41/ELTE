#!/bin/sh

if [ $# -ne 1 ]
then 
	echo "we need a filename"
	exit
fi

#for i in `cat $1`
#do
#	Check=`echo $`
# 	echo $i
#done
if [ -f $1 ]
then
	x=`cat $1 | grep "^[0-9]\+3\+$" | wc -l`
else
	echo "This file does not exist"
fi

echo "Count of integer is: " $x

