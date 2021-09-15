#include <stdio.h>

int isPrime(int n, int i) {
  if (n <= 2)
    return (n == 2) ? 1 : 0;
  if(n % i == 0)
    return 0;
  if (i * i > n)
    return 1;
  return isPrime(n, i + 1);
}

int funcPrimo(int a, int i)
{
  if(a < 2) return 0;
  if (a == 2) {
    return 1;
  }
  if (a % i == 0) return 0;
  if (i * i > a)
    return 1;
  return funcPrimo(a,i+1);
}

void main(){
  int n;
  scanf("%i",&n);
  if(funcPrimo(n,2)) {
    printf("numero primo");
  }else {
    printf("não é um numero primo");
  }
}