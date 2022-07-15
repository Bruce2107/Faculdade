#include <stdlib.h>
#include <time.h>
#include "util.h"

int * generateRandomArray(int n) {
  time_t t;
  srand((unsigned) time(&t));
  int * array = (int *) malloc(n * sizeof(int));
  int i;
  for (i = 0; i < n; i++) {
    array[i] = rand() % 100;
  }
  return array;
}

int * generateOrderedArray(int n) {
  int * array = (int *) malloc(n * sizeof(int));
  int i;
  for (i = 0; i < n; i++) {
    array[i] = i;
  }
  return array;
}

int * generateOrderedArrayDescending(int n) {
  int * array = (int *) malloc(n * sizeof(int));
  int i;
  for (i = 0; i < n; i++) {
    array[i] = n - i;
  }
  return array;
}

int * loop(void (callback)(int)) {
  int loop_size = 10;
  while(loop_size > 0) {
    callback(loop_size);
    loop_size--;
  }
}