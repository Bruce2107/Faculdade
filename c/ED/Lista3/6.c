#include <stdio.h>
#include <stdlib.h>
#include "PilhaString.h"

#define MAX 30

int validaMensagem(char orig[]);

void main(int argc, char *argv[]) {
	char entrada[MAX], saida[MAX];
	
	printf("Digite algo: ");
	scanf("%[^\n]", entrada);
	
	int r = validaMensagem(entrada);
	
	printf("Resultado: %i\n", r);
}

int validaMensagem(char orig[]){
	Pilha p1;
	inicializa_pilha(&p1, MAX);

	for(int i = 0 ; orig[i] != '\0' ; i++){
		if(orig[i] == '('){
			empilha(&p1,orig[i]);
		}
    if(orig[i] == ')') {
      if(pilha_vazia(p1)) {
        printf("Fecha parênteses sem abre parênteses (posição %i).",i);
	      desaloca_pilha(&p1);
        return -1;
      }
      char temp;
      desempilha(&p1,&temp);
    }
	}
  if(pilha_vazia(p1)) {
    printf("OK");
    desaloca_pilha(&p1);
    return 1;
  }

  printf("Há parênteses abertos que não foram fechados.");
	desaloca_pilha(&p1);
  return -1;
}

