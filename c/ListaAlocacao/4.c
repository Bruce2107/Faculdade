#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int compara(const void* a, const void* b)
{
  return *(int*)a - *(int*)b;
}

float media(int *v, int t) {
  int sum = 0;
  for(int i = 0; i < t; i++)
    sum+=v[i];
  return(sum/t);
}

float variancia(int *v, int t) {
  float sum = 0.0;
  float mean = media(v,t);
  for(int i = 0; i < t; i++)
    sum+=pow(i - mean,2);
  return sum;
}


float desvio(int *v, int t) {
  float variance = variancia(v,t);
  return sqrt(variance);
}

float mediana(int *v,int t) {

  qsort(v, t, sizeof(int), compara);

  int half = floor(t / 2);

  if (t % 2) return v[half];
  return (v[half - 1] + v[half]) / 2.0;
}

int main(int argc, char const *argv[])
{
  int n;
  scanf("%i",&n);
  int *vetor = (int*) calloc(n,sizeof(int));
  for(int i = 0; i < n; i++)
    scanf("%i",&vetor[i]);
  int mean = media(vetor,n);
  int variance = variancia(vetor,n);
  int deviation = desvio(vetor,n);
  int median = mediana(vetor,n);
  printf("media %.2f\nvariancia %.2f\ndesvio %.2f\nmediana %.2f",mean,variance,deviation,median);
  return 0;
}
