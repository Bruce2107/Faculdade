#include <stdio.h>
#include <stdlib.h>

void imprimir(float *v, int tamanho){
  for (int i = 0; i < tamanho; i++) {
    printf("%f",v[i]);
  }
  printf("\n");
}
int main() {
  int size ,j=0,k=0;
  scanf ("%i", &size) ;
  float vet[size] , vetorA[j],vetorB[k] ;
  for (int i = 0;i<size;i++) {
    float temp;
    scanf("%f",&temp);
    vet[i] =temp;
  }

  for(int i = 0; i < size; i++) {
    if(vet[i] >= 0) {
      vetorA[j] = vet[i];
      j++;
    }else{
      vetorB[k] = vet[i];
      k++;
    }
  }
  imprimir(vet,size);
  imprimir (vetorA,j);
  imprimir(vetorB,k);
}
