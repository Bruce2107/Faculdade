#include <stdio.h>
#include <string.h>
#include "PilhaString.h"

int eh_palindrome( char palavra[] );
void inverte(Pilha *p1, Pilha *p2);

void main() {
  if(eh_palindrome("anas"))
		printf("palindromo");
	else
		printf("nao palindromo");
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



int eh_palindrome( char palavra[] ) {
  Pilha p1;
  Pilha p2;
	
	int size = strlen(palavra);
	inicializa_pilha(&p1,size);
	for(int i = 0; i < size; i++)
	 empilha(&p1,palavra[i]);
  inicializa_pilha(&p2,size);	

  inverte(&p1,&p2);
	for(int i = 0; i < p2.topo; i++) {
		if(palavra[i] != p2.dados[i]) return 0;
	}
	return 1;
}

