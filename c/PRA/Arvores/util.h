#include <stdio.h>
#include <stdlib.h>

int * generateRandomArray(int size);
int * generateOrderedArray(int n);
int * generateOrderedArrayDescending(int n);
int rand_comparison(const void *a, const void *b);
void shuffle(void *base, size_t nmemb, size_t size);