#include <stdio.h>

int main(int argc, char const *argv[])
{
  int qnt = 30,vetor[qnt],vetorAux[qnt];

  for(int i = 0; i < qnt; i++) {
    scanf("%i",&vetor[i]);
  }
  for(int c = 0; c < qnt / 2 + 1; c++) {
    int last = vetor[qnt - c - 1];
    vetor[qnt - c - 1] = vetor[c];
    vetor[c] = last;
  }

  for(int i = 0; i < qnt; i++) {
    printf("%i\t",vetor[i]);
  }
  return 0;
}