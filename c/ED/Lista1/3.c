#include <stdio.h>

void calcula_hora(int totalMinutos, int *ph, int *pm) {
  *ph = totalMinutos / 60;
  *pm = totalMinutos % 60;
}

void main() {
  int tM,ph,pm;

  scanf("%d",&tM);
  calcula_hora(tM,&ph,&pm);
  printf("%dmin = %dh %dmin",tM,ph,pm);
}