#include <stdio.h>
#include "Point.h"

int main(int argc, char const *argv[])
{
  Point pA = createPoint(1,2);
  Point pB = createPoint(1,2);
  double d = distance(pA,pB);
  printf("d: %f",distance(pA,pB));
  return 0;
}
