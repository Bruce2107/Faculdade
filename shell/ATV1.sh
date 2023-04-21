#!/bin/bash

# Alunos: Eduardo Henrique e Tarso
header="Total de processos ativos sistema,Número de processos do usuário,Total Threads,Mais Velho,Usuário,Qtd processos -Usuário,Qtd processos Root"
date=$(date +'%Y%m%d')
user=$1

if [ -z "$user" ];then
  user=$($USER | logname)
fi

filename=$date"_Processos_$user.csv"
totalSysProcesses=$(ps -ef | wc -l)
totalUserProcesses=$(ps -u $user | wc -l)
oldestProcess=$(pgrep -o)
totalThreads=$(ps -eo nlwp | tail -n +2 | awk '{ num_threads += $1 } END { print num_threads }')
curUser=$user
totalProcessAliveExceptCurUser=$[totalSysProcesses - $totalUserProcesses]
totalProcessRoot=$(ps -u root | wc -l)

line=$totalSysProcesses","$totalUserProcesses","$totalThreads","$oldestProcess","$curUser","$totalProcessAliveExceptCurUser","$totalProcessRoot
FILE="./$filename"
if [ -f "$FILE" ]; then
  printf "$line\n" >> $FILE
else
  printf "$header\n$line\n" >> $FILE
fi