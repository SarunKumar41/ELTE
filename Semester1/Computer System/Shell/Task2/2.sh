#!/bin/sh

if [ $# -ne 1 ]
then
	echo "We need only one word"
	exit
fi

check=`echo $1 | grep -c "^[a-zA-Z]\+$"`

if [ check -ne 1 ]
then
	echo "We need a word"
	exit
fi

echo $1 | sed 's/.\{1\}/& /g'
