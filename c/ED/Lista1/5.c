#include <stdio.h>
#include <stdlib.h>

void max_vetor(float vet[], int tam, float *pMax, int *pIndice);

void main(){
  int vetor[4] = {5, 10, 15, 20};
  int max, indice;

  max_vetor(vetor, 4, &max, &indice );

  printf("O maior valor do vetor eh: %d\n",  max);
  printf("E seu indice eh: %d\n", indice);
}

void max_vetor(float vet[], int tam, float *pMax, int *pIndice){
  for( int i = 0; i < tam; i++){
    if (i == 0){
      *pMax = vet[0];
      *pIndice = 1; 
    } 
    if(*pMax < vet[i]){
      *pMax = vet[i];
      *pIndice = i + 1;
    } 
  }
}