#include <stdio.h>
#include <stdlib.h>

int BuscaMaior(int *v, int t , int *p ) {
   int Maior = *v;
   *p = 0;
   for (int i = 1; i < t; i++)
    if (*(v+i) > Maior) {
      Maior = *(v+i);
      *p = i;
    }
   return(Maior);
}

int BuscaMenor(int *v, int t ,int *p) {
   int Menor = *v;
   *p = 0;
   for (int i = 1; i < t; i++)
    if (*(v+i) < Menor) {
    Menor = *(v+i);
    *p = i;
   }
   return(Menor);
}

int main(int argc, char const *argv[])
{
  int n;
  scanf("%i",&n);
  int *vetor = (int*) calloc(n,sizeof(int));
  for(int i = 0; i < n; i++)
    scanf("%i",vetor + i);
  int posMaior, posMenor;
  int maior = BuscaMaior(vetor,n, &posMaior);
  int menor = BuscaMenor(vetor,n, &posMenor);
  int soma = vetor[posMenor] + vetor[posMaior];
  printf("Maior %i\nMenor %i\nSoma %i",maior,menor,soma);
  return 0;
}
