#include <stdio.h>

int fibonacci(int a) {
  if(a==1 || a==2)
    return 1;
  return fibonacci(a-1) + fibonacci(a-2); 
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
  int x = fibonacci(a);
  printf("%i\n",x);
  return 0;
}
