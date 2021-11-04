#include "Point.h"
#include <math.h>
#include <stdio.h>

Point createPoint(int cx, int cy) {
  Point P;
  P.x = cx;
  P.y = cy;
  return P;
}

double distance(Point A, Point B) {
  return sqrt(pow((B.x-A.x),2)+pow((B.y- A.y),2));
}

int getX(Point p) {
  return p.x;
}

int getY(Point p) {
  return p.y;
}

void showPoint(Point P) {
  printf("(%i,%i)",P.x,P.y);
}