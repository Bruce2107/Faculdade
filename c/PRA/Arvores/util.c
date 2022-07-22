#include <stdlib.h>
#include <time.h>
#include "util.h"

int *generateRandomArray(int n)
{
  // time_t t;
  // srand((unsigned) time(&t));
  // int * array = (int *) malloc(n * sizeof(int));
  // int i;
  // for (i = 0; i < n; i++) {
  //   array[i] = rand() % 100;
  // }
  // return array;
  // srand(time(0));
  int *array = generateOrderedArray(n);
  shuffle(array, n, sizeof(int));
  return array;
}

int *generateOrderedArray(int n)
{
  int *array = (int *)malloc(n * sizeof(int));
  int i;
  for (i = 0; i < n; i++)
  {
    array[i] = i + 1;
  }
  return array;
}

int *generateOrderedArrayDescending(int n)
{
  int *array = (int *)malloc(n * sizeof(int));
  int i;
  for (i = 0; i < n; i++)
  {
    array[i] = n - i;
  }
  return array;
}

int rand_comparison(const void *a, const void *b)
{
  (void)a;
  (void)b;
  return rand() % 2 ? +1 : -1;
}

void shuffle(void *base, size_t nmemb, size_t size)
{
  qsort(base, nmemb, size, rand_comparison);
}