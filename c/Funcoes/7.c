#include <stdio.h>

int fibonacci(int a) {
  if(a==1 || a==2) // Para evitar o n+1: a <= 1 ? 1 : continue
    return 1;
  return fibonacci(a-1) + fibonacci(a-2); 
}

int degrau(int n) {
  int resposta = 0, i;

  if (n <= 1)
    return 1;

  for (i = 1; i <= 2 && i <= n; i++) {
    resposta = resposta + degrau(n - i);
  }
  
  return resposta;
}
void read(int *n) {
  do{
    scanf("%i",n);
  }while (*n < 0);
  
}

int main(int argc, char const *argv[])
{
  int a;
  read(&a);
  int x = fibonacci(a+1);
  printf("%i\n",x);
  return 0;
}