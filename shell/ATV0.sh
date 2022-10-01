#!/bin/zsh

echo "Nome do processo"
read nome_processo;
pid="$(pgrep -x $nome_processo)"
[ $pid > 0 ] && { echo "Rodando sob o PID: $pid" } || { echo "Processo não encontrado"}
