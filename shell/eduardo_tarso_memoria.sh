#!/bin/bash

# Alunos: Eduardo Henrique e Tarso
nomes="eduardo_tarso"
header="Data,Usuário,Host,CTMP,QTMPU,CTMS,QTMSU,QProcessos,QTMOP,QPF"
date=$(date +'%Y%m%d')
user=$1
SALT=20
TOTAL_TIME=300

if [ -z "$user" ];then
  user=$(logname)
fi

filename=$nomes"_"$data"_memoria_$user.csv"
for((i=0;i<=$TOTAL_TIME;i+=$SALT)) do
  host=$(hostname)

  CTMP=$(head /proc/meminfo | grep -i 'memtotal' | grep -o '[[:digit:]]*')
  CTMPF$(head /proc/meminfo | grep -i 'memfree' | grep -o '[[:digit:]]*')
  QTMPU=$CTMP-$CTMPF
  CTMS=$(head /proc/meminfo | grep -i 'swaptotal' | grep -o '[[:digit:]]*')
  CTMSF=$(head /proc/meminfo | grep -i 'swapfree' | grep -o '[[:digit:]]*')
  QTMSU=$CTMS-$CTMSF
  QPF=$(grep pgfault /proc/vmstat | grep -o '[[:digit:]]*')

  totalSysProcesses=$(ps -ef | wc -l)
  #totalUserProcesses=$(ps -u $user | wc -l) # Comando da erro no labvirtual user = CPF id out of range
  totalProcessRoot=$(ps -u root | wc -l)
  totalUserProcesses=$[totalSysProcesses - totalProcessRoot] # solução pro lab

  line=$data","$user","$host","$CTMP","$QTMPU","$CTMS","$QTMSU","$totalSysProcesses","$totalUserProcesses","$QPF
  FILE="./$filename"
  if [ -f "$FILE" ]; then
    printf "$line\n" >> $FILE
  else
    printf "$header\n$line\n" >> $FILE
  fi
  sleep $SALT
done