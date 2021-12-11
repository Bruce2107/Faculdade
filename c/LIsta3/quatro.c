#include <stdio.h>

int main(int argc, char const *argv[])
{
  int qnt = 20, vetor1[qnt], vetor2[qnt], vetor3[qnt];

  for(int i = 0; i < qnt; i++) {
    scanf("%i",&vetor1[i]);
  }
  for(int i = 0; i < qnt; i++) {
    scanf("%i",&vetor2[i]);
  }
  for(int i = 0; i < qnt; i++) {
    vetor3[i] = vetor1[i] * vetor2[i];
  }
  for(int i = 0; i < qnt; i++) {
    printf("%i\t",vetor3[i]);
  }
  return 0;
}