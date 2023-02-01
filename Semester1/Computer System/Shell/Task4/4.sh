#!/bin/sh


c=0

while read line
do
	x=`echo $line | cut -d " " -f1 | grep -c "^[0-9]\+$"`
	if [ $x -eq 1 ]
	then
	c=`expr $c + 1`
	else
	echo "not a integer"
	fi

	y=`echo $line | cut -d " " -f2 | grep -c "^[0-9]\+$"`
	if [ $y -eq 1 ]
	then
	c=`expr $c + 1`
	else
	echo "not a word"
	fi

done < $1
cat $1 | awk '{print $2, $1}'
