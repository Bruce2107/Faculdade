#include <stdio.h>

int mdc(int a,int b) {
  if((a>=b) && (a % b == 0)){
    return b;
  }
  if(a < b) {
    return mdc(b,a);
  }
  return mdc(a, a % b);
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
  int x = mdc(a,b);
  printf("%i\n",x);
  return 0;
}
