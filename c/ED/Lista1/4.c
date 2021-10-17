#include <stdio.h>
#include <stdlib.h>

void max_min(int vet[], int tam, int *pMin, int *pMax);

void main () {

  int vetor[5] = {10, 20, 30, 50, 70};
  int max, min;

  max_min(vetor, 5, &min, &max);
  
  printf("O valor minimo eh: %d\n", min);
  printf("O valor maximo eh: %d\n", max);
}

void max_min(int vet[], int tam, int *pMin, int *pMax){
  for( int i = 0; i < tam; i++){
    if (i == 0){
      *pMin = vet[0];
      *pMax = vet[0]; 
    }
    if(*pMax < vet[i]){
      *pMax = vet[i];
    }
    if(*pMin > vet[i]){
      *pMin = vet[i];
    }
  }
}