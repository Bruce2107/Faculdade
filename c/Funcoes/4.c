#include <stdio.h>

int fatorial(int a) {
  if(a==1)
    return 1;
  return a * fatorial(a-1);
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
  int x = fatorial(a);
  printf("%i\n",x);
  return 0;
}
