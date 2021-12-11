#include <stdio.h>

int main(int argc, char const *argv[])
{
  int n;
  scanf("%i",&n);
  int *vetor = (int*) calloc(n,sizeof(int));
  for(int i = 0; i < n; i++)
    scanf("%i",&vetor[i]);
  int *novo = (int*) calloc(n*2,sizeof(int));
  for(int i = 0; i < n; i++)
    novo[i] = &vetor[i];
  free(vetor);
  return 0;
}
