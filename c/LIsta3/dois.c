#include <stdio.h>

int main(int argc, char const *argv[])
{
  int *vetor;
  for(int i =0; i < 30; i++) {
    scanf("%i",&vetor[i]);
  }
  for(int i = 0; i < 30; i++) {
    if(vetor[1] == 0) printf("posição %i: %i\n", i,1);
    else printf("posição %i: %i\n", i,vetor[i]);
  }
  return 0;
}
