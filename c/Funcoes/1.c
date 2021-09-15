#include <stdio.h>

int multiplication(int a,int b) {
  if(b == 1){
    return a;
  }
  return a + multiplication(a,b-1);
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
  int x = multiplication(a,b);
  printf("%i\n",x);
  return 0;
}
