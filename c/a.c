#include <stdio.h>
int main(int argc, char const *argv[])
{
  int size;
  scanf("%i",&size);
  int hi[size], ho[size], escalar = 0;

  for(int i = 1; i <=size; i++) {
    scanf("%i",&hi[i]);
  }
  for(int i = 1; i <= size; i++) {
    scanf("%i",&ho[i]);
  }
  for(int i = 1; i <= size; i++) {
    escalar += hi[i] * ho[i];
  }
  for(int i = 1; i <= 5; i++) {
    printf("vetor[%d] = %d\n",i,hi[i]);
  }
  for(int i = 1; i <= 5; i++) {
    printf("vetor[%d] = %d\n",i,ho[i]);
  }
  printf("escalar = %d",escalar);
}
