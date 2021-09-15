#include <stdio.h>

int main(int argc, char const *argv[])
{
  int qnt= 30,vetor[qnt], soma = 0, acimaDaMedia =0,somaAcimaDaMedia = 0;
  double media;

  for(int i = 0; i < qnt; i++) {
    scanf("%i",&vetor[i]);
    if(vetor[i] % 2 == 0) soma++;
  }
  media = soma/30.0;
  printf("Media %d\n", media);
  for(int i = 0; i < qnt; i++) {
    if(vetor[i] > media) {
      printf("pocisao %i: %i",i,vetor[i]);
      somaAcimaDaMedia += vetor[i];
      acimaDaMedia++;
    }
  }
  printf("Qnt acima da media %i\n", acimaDaMedia);
  printf("Soma acima da media %i\n", somaAcimaDaMedia);
  printf("Media %d\n", 10/3*acimaDaMedia);

  return 0;
}