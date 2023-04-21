#!/bin/bash

# Alunos: Eduardo Henrique e Tarso
nomes="eduardo_tarso"
date=$(date +'%Y%m%d')
user=$1
curDir=$(pwd)

filename=$nomes"_AcessoRecente_"$curDir"_"$date".txt"
FILE="./${filename//\//\\}"

COMMAND=$(find ./ atime -2 -ls)
printf $COMMAND >> $FILE