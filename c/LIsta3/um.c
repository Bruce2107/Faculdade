#include <stdio.h>

int main(int argc, char const *argv[])
{
  int *vetor, qnt = 0;

  for(int i = 0; i < 20; i++) {
    scanf("%i",&vetor[i]);
    if(vetor[i] % 2 == 0) qnt++;
  }
  printf("%i",qnt);
  return 0;
}
