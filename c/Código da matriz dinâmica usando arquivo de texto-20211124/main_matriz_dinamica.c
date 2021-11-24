#include <stdio.h>
#include <stdlib.h>
#include "Matriz.h"

int main(int argc, char *argv[]) {
	Matriz m1;
	
	carrega_matriz_arquivo( "m2.txt", &m1 );
	// mostra_matriz(m1);
	DFS(m1, 1);
	// int size;

	// int *n = nodes(m1, 1, &size);

	// for (int i = 0; i < size;i++){
	// 	printf("ad: %d\t", n[i]);
	// }
	// printf("%d", size);

	/*
	inicializa_matriz( &m1, 4, 4 );
	mostra_matriz( m1 );
	
	set_matriz( &m1, 0, 0, 5 );
	mostra_matriz( m1 );
	
	set_matriz( &m1, 2, 3, 7 );
	mostra_matriz( m1 );

	int x;
	get_matriz( m1, 2, 3, &x );
	
	printf("Valor lido: %d\n", x);
	*/

	return 0;
}
