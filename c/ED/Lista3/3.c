#include <stdio.h>
#include "PilhaString.h"

void inverte( Pilha *p1, Pilha *p2 );

void main() {
  Pilha p1;
  Pilha p2;
	
	inicializa_pilha(&p1,4);	
	empilha(&p1,'c');
	empilha(&p1,'a');
	empilha(&p1,'b');
	empilha(&p1,'o');
  mostra_pilha(p1);
  inicializa_pilha(&p2,4);	

  inverte(&p1,&p2);
	
	mostra_pilha(p2);
}

void inverte(Pilha *p1, Pilha *p2) {
  if(pilha_vazia(*p1)) {
    return;
  }
  char temp;
  while (desempilha(p1, &temp) != ERRO_PILHA_VAZIA) {
    empilha(p2,temp);
  }
  desaloca_pilha(p1);
}

