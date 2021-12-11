#include <stdio.h>

int division(int a,int b) {
  if(b == 1){
    return a;
  }
  if(a < b) return 0;
  return 1 + division(a - b,b);
}

void read(int *n) {
  do{
    scanf("%i",n);
  }while (*n < 0);
  
}

int main(int argc, char const *argv[])
{
  int a,b;
  read(&a);
  read(&b);
  int x = division(a,b);
  printf("%i\n",x);
  return 0;
}
