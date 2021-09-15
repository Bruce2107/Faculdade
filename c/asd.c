#include <stdio.h>

void imprimir(float *v, int tamanho){
  for (int i = 0; i < tamanho; i++) {
    printf("%.2f\t",v[i]);
  }
  printf("\n");
}

int main(int argc, char const *argv[])
{
  int size;
  scanf("%i",&size);
  int positivos = 0, negativos = 0;
  float vetor[size],vetA[size],vetB[size];
  for(int i = 0; i < size; i++) {
    scanf("%f",&vetor[i]);
    if(vetor[i] >= 0){
      vetA[positivos] = vetor[i];
      positivos++;
    }else {
      vetB[negativos] = vetor[i];
      negativos++;
    }
  }

  imprimir(vetA,positivos);
  imprimir(vetB,negativos);
  imprimir(vetor,size);

  return 0;
}
