#include <stdio.h>
#include <stdlib.h>

float *maiores(float *v, int n, int *size);

void main() {
  float vetor[4] = {5.0, 10.0, 15.0, 20.0};
  int size;
  float *notasMaiores = maiores(vetor, 4, &size);
  for(int i = 0; i < size; i++) {
    printf("%.2f\t",notasMaiores[i]);
  }
  free(notasMaiores);
}

float *maiores(float *v, int n, int *size){
  float soma = 0.0;
  for(int i = 0; i < n; i++) soma += v[i];
  float media = soma/n;
  *size = 1;
  float *notas = (float *) malloc((*size) * sizeof(float));

  for(int i = 0; i < n; i++) {
    if(v[i] >= media) {
      if((*size) == 1) {
        notas[(*size)-1] = v[i];
        notas = realloc(notas,(*size)+1);
      }else{
        notas = realloc(notas,(*size)+1);
        notas[(*size)-1] = v[i];
      }
      (*size)++;
    }
  }
  (*size)--;

  return notas;
}