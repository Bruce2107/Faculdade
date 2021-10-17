#include <stdio.h>

void troca_valor(float *x, float *y);

void main(){
  float x, y;
  printf("Informe o valor de x:\n");
  scanf("%f", &x);
  printf("Informe o valor de y:\n");
  scanf("%f", &y);
    
  printf("x = %.2f\n ", x);
  printf("y = %.2f\n", y );

  troca_valor( &x, &y);

  printf("x = %.2f", x);
  printf("y = %.2f", y);
}


void troca_valor(float *x, float *y){
  int aux;

  aux = *x;
  *x = *y;
  *y = aux;
} 