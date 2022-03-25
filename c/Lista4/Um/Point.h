typedef struct  {
  int x;
  int y;
} Point;

Point createPoint(int x,int y);
double distance(Point A,Point B);
int getX(Point p);
int getY(Point p);
void showPoint(Point p);