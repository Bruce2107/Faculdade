#include <stdio.h>
#include <stdlib.h>
#include "Matriz.h"
#include "Pilha.h"

void inicializa_matriz( Matriz *p, int l, int c ){
	p->lin = l;
	p->col = c;
	
	p->dados = malloc( sizeof(int *) * l );
	int i, j;
	for( i = 0 ; i < l ; i++ ){
		p->dados[i] = calloc(c, sizeof(int) );
	}
}

void mostra_matriz( Matriz m ){
	printf("Dados da matriz %dx%d:\n", m.lin, m.col);
	int i, j;
	for( i = 0 ; i < m.lin ; i++ ){
		for( j = 0 ; j < m.col ; j++ )
			printf("%4d ", m.dados[i][j]);
		printf("\n");
	}
	printf("\n");
}

int set_matriz( Matriz *p, int i, int j, int valor ){
	if( i >= p->lin || j >= p->col )
		return ERRO_COORD_INVALIDA;
	
	p->dados[i][j] = valor;
	return 1; // Sucesso.	
}

int get_matriz( Matriz m, int i, int j, int *p_valor ){
	if( i >= m.lin || j >= m.col )
		return ERRO_COORD_INVALIDA;
	
	*p_valor = m.dados[i][j];
	return 1; // Sucesso.	
}

int compara_matrizes( Matriz m1, Matriz m2 ){
	if( m1.lin != m2.lin || m1.col != m2.col )
		return 0; // Falso, s�o diferentes!
	
	int i, j;
	for( i = 0 ; i < m1.lin ; i++ )
		for( j = 0 ; j < m1.col ; j++ )
			if( m1.dados[i][j] != m2.dados[i][j] )
				return 0; // Falso, s�o diferentes!
				
	return 1; // Verdadeiro, s�o iguais!
}


int carrega_matriz_arquivo( char *nome_arq, Matriz *p ){
	FILE *f = fopen( nome_arq, "rt" );
	if( f == NULL )
		return 0; // 0 (falso) --> erro no arquivo ou arquivo n�o existe!
		
	int dim, i, j;
	fscanf( f, "%d", &dim );
	
	inicializa_matriz( p, dim, dim );
	
	for( i = 0 ; i < dim ; i++ )
		for( j = 0 ; j < dim ; j++ ){
			int valor;
			fscanf( f, "%d", &valor);
			set_matriz( p , i, j, valor );
		}
	
	fclose( f );
	return 1; // 1 (verdadeiro) --> carga realizada!
}

int * nodes(Matriz m, int row, int *size) {
	int n = 0;
	*size = 0;
	for (int i = 0; i < m.col; i++) {
		if(m.dados[row][i] == 1)
			n++;
	}
	int *v = calloc(n, sizeof(int));
	for (int i = 0; i < m.col; i++) {
		if(m.dados[row][i] == 1) {
			v[*size] = i;
			(*size)++;
		}
	}
	return v;
}

void DFS(Matriz m, int init) {
	Pilha p;
	inicializa_pilha(&p, 32);
	int *status = calloc(m.col,sizeof(int));
	empilha(&p, init);

	int temp;

	while (desempilha(&p, &temp) != ERRO_PILHA_VAZIA)
	{
		if(status[temp - 1] == 0){
			printf("%d\n", temp);
			status[temp - 1] = 1;
			int size;
			int *n = nodes(m, temp - 1, &size);
			for (int i = 0; i < size; i++)
			{
				if(status[n[i]] == 0) {
					empilha(&p, n[i]+1);
				}
			}
		}
	}
	
}