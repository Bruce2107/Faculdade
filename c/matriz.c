#include <stdio.h>


#define DIM 5

int main(int argc, char const *argv[])
{
  // int m[DIM][DIM] = {
  //   5,12,44,2,-1,
  //   27,81,18,9,56,
  //   20,-7,36,99,84,
  //   110,125,45,27,66,
  //   0,3,7,11-3
  // };

  int m[DIM][DIM],maior,menor,linha,coluna;

  for(int i = 0; i < DIM; i++ ){
    for(int j = 0; j < DIM; j++ ){
      scanf("%d", &m[i][j]);
    }
  }
  for(int i = 0; i < DIM; i++)
    for(int j = 0; j < DIM; j++) {
      if(i == 0 && j == 0) maior = m[i][j];
      if(j == 0) menor = m[i][j];
      if(m[i][j] < menor) {
        menor = m[i][j];
        coluna = j;
      }
      if(m[i][j] > maior) {
        maior = m[i][j];
        linha = i;
      };
    }
  // for(int i = 0; i < DIM; i++) {
  //   if(i == 0) menor = m[linha][i];
  //   if(m[linha][i] < menor) {
  //     menor = m[linha][i];
  //     coluna = i;
  //   }
  // }

  printf("%i posicao A(%i,%i)",m[linha][coluna],linha,coluna);
  return 0;
}
