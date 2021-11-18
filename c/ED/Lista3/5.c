#include <stdio.h>
#include <stdlib.h>
#include "PilhaString.h"

#define MAX 30

void gera_mensagem(char orig[], char dest[]);

void main(int argc, char *argv[]) {
	char entrada[MAX], saida[MAX];
	
	printf("Digite algo: ");
	scanf("%[^\n]", entrada);
	
	gera_mensagem(entrada, saida);
	
	printf("Mensagem secreta gerada: %s\n", saida);
}

void gera_mensagem(char orig[], char dest[]){
	Pilha p1;
	inicializa_pilha(&p1, MAX);
	int i, j = 0, k;
	for(i = 0 ; orig[i] != '\0' ; i++){
		if(orig[i] == ' '){
			for(k = j ; k < i ; k++)
				empilha(&p1, orig[k]);
			
			while(!pilha_vazia( p1)){
				desempilha( &p1, &dest[j] );
				j++;
			}
			dest[j] = ' ';
			j++;
		}
	}
	
	for(k = j ; k < i ; k++)
		empilha(&p1, orig[k]);
			
	while(!pilha_vazia(p1)){
		desempilha(&p1, &dest[j]);
		j++;
	}
	
	dest[j] = '\0';
	
	desaloca_pilha(&p1);
}

