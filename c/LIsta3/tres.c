#include <stdio.h>

int main(int argc, char const *argv[])
{
  int *vetor;

  for(int i = 0; i < 20; i++) {
    scanf("%i",&vetor[i]);
  }
  for(int i = 0; i < 20; i++) {
    if(vetor[i] > 0) printf("%i\t",vetor[i]);
  }
  return 0;
}