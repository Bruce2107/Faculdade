#include <stdio.h>

int main(int argc, char const *argv[])
{
  int vetor[30], qnt = 0,sum=0;

  for(int i = 0; i < 3; i++) {
    scanf("%i",&vetor[i]);
    if(vetor[i] % 2 != 0 && vetor[i] > 10) {qnt++;sum+=vetor[i];};
  }
  if(qnt != 0)
    printf("%d",sum/qnt);
  return 0;
}