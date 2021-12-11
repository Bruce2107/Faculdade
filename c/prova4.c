#include <stdio.h>

int main(int argc, char const *argv[])
{
  int n,k;
  scanf("%i",&n);
  int vetor[n];
  for(int i = 0; i < n; i++)
    scanf("%i",&vetor[i]);
  scanf("%i",&k);
  for(int i = 0; i < n; i++) {
    for(int j = i + 1; j < n; j++)
      if(vetor[i] + vetor[j] == k)
        printf("true");
        return 1;
  }
  return 0;
}
