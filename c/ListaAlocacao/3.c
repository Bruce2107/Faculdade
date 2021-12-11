#include <stdio.h>
#include <stdlib.h>


int main(int argc, char const *argv[])
{
  int n;
  scanf("%i",&n);
  int *vetor = (int*) calloc(n,sizeof(int));
  for(int i = 0; i < n; i++)
    scanf("%i",&vetor[i]);

  float *pesos = (int*) calloc(n,sizeof(float));
  for(int i = 0; i < n; i++)
    scanf("%f",&pesos[i]);
  float somaPesos = 0, somaValores = 0;
  for(int i = 0; i < n; i++) {
    somaPesos+=pesos[i];
    somaValores+= pesos[i] * vetor[i];
  }

  printf("MEdia %.2f",somaValores/somaPesos);
  return 0;
}
