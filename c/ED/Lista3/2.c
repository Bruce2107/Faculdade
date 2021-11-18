#include <stdio.h>
#include "Pilha.h"

void concatena( Pilha *p1, Pilha *p2 );

void main() {
  Pilha p1;
  Pilha p2;
	
	inicializa_pilha(&p1,10);	
	empilha(&p1,4);
	empilha(&p1,6);
	empilha(&p1,8);
	empilha(&p1,10);
  inicializa_pilha(&p2,5);	
	empilha(&p2,4);
	empilha(&p2,6);
	empilha(&p2,8);
	empilha(&p2,10);

  concatena(&p1,&p2);
	
	mostra_pilha(p1);

}

void concatena(Pilha *p1, Pilha *p2) {
  if(pilha_vazia(*p2)) {
    return;
  }
  int temp;
  while (desempilha(p2, &temp) != ERRO_PILHA_VAZIA) {
    empilha(p1,temp);
  }
  desaloca_pilha(p2);
}

