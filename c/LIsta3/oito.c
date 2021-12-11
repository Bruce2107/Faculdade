/*aça um algoritmo que gere os N primeiros elementos da série de Fibonacci, 
armazene-os num vetor, e por fim mostre a série gerada. Nessa série, os dois 
primeiros elementos são 1 e 1. A partir do terceiro, os elementos são gerados a partir 
da soma dos dois anteriores. Por exemplo, numa série com N= 9, temos: (1, 1, 2, 3,
5, 8, 13, 21, 34). Defina um vetor com capacidade 50 e garanta que o usuário não 
entre com N > 50. */

#include <stdio.h>

int main(int argc, char const *argv[])
{
  int qtd;
  do{
    scanf("%i",&qtd);
  }while (qtd < 0 || qtd > 50);
  int vetor[50];
  if(qtd == 1) {
    printf("1");
  }else if(qtd == 2) {
    printf("1, 1");
  }else{
    vetor[0] = vetor[1] = 1;
    for(int i = 2; i < qtd; i++) {
      vetor[i] =  vetor[i -1] + vetor[i -2];
    }
    for(int i = 0; i < qtd; i++) {
      printf("%i, ",vetor[i]);
    }
  }
  return 0;
}
