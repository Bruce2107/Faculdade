#include <stdio.h>
#include <stdlib.h>

float *clone(float *v, int n);

void main() {
  float vetor[4] = {5.0, 10.0, 15.0, 20.0};

  float *clonado = clone(vetor, 4);
  for(int i = 0; i < 4; i++) {
    printf("%.2f\t",clonado[i]);
  }
  free(clonado);
}

float *clone( float *v, int n ){
  float *vet = (float *) malloc(n * sizeof(float));
  for(int i=0; i<n; i++){
    vet[i] = v[i]; 
  }
  return vet; //&vet[0]
}