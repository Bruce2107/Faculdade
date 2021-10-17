#include <stdlib.h>
#include <stdio.h> 
#define PI 3.14

void calcula_circulo(float raio, float *pPerimetro, float *pArea);

void main(){
  float raio, pPerimetro, pArea;

  scanf("%f", &raio);

  calcula_circulo(raio, &pPerimetro, &pArea);

  printf("Perimetro : %.2f\n", pPerimetro);
  printf("\nArea : %.2f\n", pArea);
}


void calcula_circulo(float raio, float *pPerimetro, float *pArea){
  *pPerimetro = 2 * PI * raio;
  *pArea = PI * raio * raio;
} 