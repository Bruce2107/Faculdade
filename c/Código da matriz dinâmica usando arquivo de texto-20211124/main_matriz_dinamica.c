#include <stdio.h>
#include <stdlib.h>
#include "Matriz.h"

void main(int argc, char *argv[]) {
	Matriz m1;
	
	carrega_matriz_arquivo( "m2.txt", &m1 );
	DFS(m1, 1);
	free(m1.dados);
}
