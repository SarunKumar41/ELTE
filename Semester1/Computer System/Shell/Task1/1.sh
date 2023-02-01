#!/bin/sh

if [ $# -ne 2 ]
then
	echo "We need two parameters"
	exit
fi

first=`echo $1 | grep -c "^[0-9]\+$"`
second=`echo $2 | grep -c "^[0-9]\+$"`

if [ $first -ne 1 -o $second -ne 1 ]
then 
	echo "We need two integers"
	exit
fi

echo "sum: " `expr $1 + $2`
