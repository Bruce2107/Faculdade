#include <stdio.h>
#include <stdlib.h>
#include "PilhaString.h"

void inicializa_pilha ( Pilha *p, char c ){
	p->dados = malloc( sizeof(int) * c );
	p->capacidade = c;
	p->topo = -1;
}

int pilha_vazia ( Pilha p ) {
	return p.topo == -1;
}

int pilha_cheia ( Pilha p ) {
	return p.topo == p.capacidade - 1;
}

int empilha ( Pilha *p, char info ) {
	if( pilha_cheia ( *p ) )
		return ERRO_PILHA_CHEIA;

	p->topo++;
	p->dados[p->topo] = info;
	return 1; // Sucesso
}

int desempilha ( Pilha *p, char *info ) {
	if ( pilha_vazia ( *p ) )
		return ERRO_PILHA_VAZIA;

	*info = p->dados[p->topo];
	p->topo--;
	return 1; // Sucesso
}

int le_topo ( Pilha p, char *info ) {
   if ( pilha_vazia( p ) )
      return ERRO_PILHA_VAZIA;

   *info = p.dados[p.topo];
   return 1; // Sucesso
}

void mostra_pilha ( Pilha p ) {
	if( pilha_vazia ( p ) )
		printf("Pilha vazia!\n");
	else{
		printf("Dados da Pilha:\n");
		int i;
		for( i=0 ; i <= p.topo ; i++)
			printf("%c", p.dados[i]);
   }
	 printf("\n");
}

void desaloca_pilha( Pilha *p ){
	free( p->dados );
}

