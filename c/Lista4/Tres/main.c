#include "matrizLib.h"
#include <stdio.h>

int main(int argc, char const *argv[])
{
  Matrix mat = createMatrix(3,3);
  // printMatrix(mat);
  updateMatrix(1,1,1.1,mat);
  // printMatrix(mat);
  Matrix mat2 = createMatrix(3,3);
  updateMatrix(1,2,2.1,mat2);

  // int r = compareMatrix(mat,mat2);
  Matrix sum = sumMatrix(mat,mat2);
  printMatrix(sum);
  // printf("%i",r);
  return 0;
}
