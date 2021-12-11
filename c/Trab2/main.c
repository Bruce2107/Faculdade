#include <stdio.h>
#include <stdlib.h>
#include "Matriz.h"
#include "Pilha.h"
#include "Fila.h"

int * nodes(Matriz m, int row, int *size) {
  int n = 0;
  *size = 0;
	for (int i = 0; i < m.col; i++) {
		if(m.dados[row][i] == 1) {
			n++;
		}
	}
	int *v = calloc(n, sizeof(int));
	for (int i = 0; i < m.col; i++)
  {
    if(m.dados[row][i] == 1) {
			v[*size] = i;
			(*size)++;
		}
  }
  return v;
}

void BFS(Matriz m, int A, int B) {
	Fila f;
	inicializa_fila(&f);
  
  int *VS = calloc(m.col, sizeof(int));
  int *VA = calloc(m.col,sizeof(int));
	VS[A - 1] = 1;
	inserir(&f, A);
	int achou = 0;
	int x = 0;
	
	while(!fila_vazia(f) && !achou) {
		remover(&f, &x);
		
		if (x == B) {
			achou = 1;
		}
		else {
      int size = 0;
			int *n = nodes(m, x - 1, &size);
			for(int i = 0; i < size; i++) {
				if (VS[n[i]] == 0)
				{
					VS[n[i]] = 1;
					VA[n[i]] = x;
					inserir(&f, n[i] + 1);
				}
			}
		}
	}
	if (achou)
	{
		Pilha p;
		
		inicializa_pilha(&p, 32);
		x = B;
		while (x!=0){
			empilha(&p, x);
			x = VA[x - 1];
		}
		int temp = 0;
		while(desempilha(&p,&temp) != ERRO_PILHA_VAZIA) {
			printf("%d\n", temp);
		}
	}
	else {
		printf("B não é alcançável a partir de A!");
	}
}

void main(int argc, char *argv[]) {
	Matriz m1;
	carrega_matriz_arquivo("input.txt", &m1);
	BFS(m1, 5,6);
	free(m1.dados);
}
