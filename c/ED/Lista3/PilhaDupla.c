#include <stdio.h>
#include <stdlib.h>
#include "PilhaDupla.h"

void inicializa_pilha ( Pilha *p, int c ){
	p->dados = malloc( sizeof(int) * c );
	p->capacidade = c;
	p->topo1 = -1;
	p->topo2 = c+1;
}

int pilha_vazia ( Pilha p ) {
	return p.topo1 == -1;
}

int pilha_vazia ( Pilha p ) {
	return p.topo2 == p.capacidade+1;
}

int pilha_cheias ( Pilha p ) {
	return p.topo1 == p.topo2+1;
}

int empilha_topo1 ( Pilha *p, int info ) {
	if( pilha_cheia ( *p ) )
		return ERRO_PILHA_CHEIA;

	p->topo1++;
	p->dados[p->topo1] = info;
	return 1; // Sucesso
}

int empilha_topo2 ( Pilha *p, int info ) {
	if( pilha_cheia ( *p ) )
		return ERRO_PILHA_CHEIA;

	p->topo2--;
	p->dados[p->topo2] = info;
	return 1; // Sucesso
}


int desempilha_topo1 ( Pilha *p, int *info ) {
	if ( pilha_vazia ( *p ) )
		return ERRO_PILHA_VAZIA;

	*info = p->dados[p->topo1];
	p->topo1--;
	return 1; // Sucesso
}

int desempilha_topo2 ( Pilha *p, int *info ) {
	if ( pilha_vazia ( *p ) )
		return ERRO_PILHA_VAZIA;

	*info = p->dados[p->topo2];
	p->topo2++;
	return 1; // Sucesso
}

int le_topo1 ( Pilha p, int *info ) {
   if ( pilha_vazia( p ) )
      return ERRO_PILHA_VAZIA;

   *info = p.dados[p.topo1];
   return 1; // Sucesso
}

int le_topo2 ( Pilha p, int *info ) {
   if ( pilha_vazia( p ) )
      return ERRO_PILHA_VAZIA;

   *info = p.dados[p.topo2];
   return 1; // Sucesso
}

void mostra_pilha1 ( Pilha p ) {
	if( pilha_vazia ( p ) )
		printf("Pilha vazia!\n");
	else{
		printf("Dados da Pilha:\n");
		int i;
		for( i=0 ; i <= p.topo1 ; i++)
			printf("%d\n", p.dados[i]);
   }
}

void mostra_pilha2 ( Pilha p ) {
	if( pilha_vazia ( p ) )
		printf("Pilha vazia!\n");
	else{
		printf("Dados da Pilha:\n");
		int i;
		for( i=p.topo2 ; i > p.topo1 ; i--)
			printf("%d\n", p.dados[i]);
   }
}

void desaloca_pilha( Pilha *p ){
	free( p->dados );
}

