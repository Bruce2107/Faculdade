#include <stdio.h>
#include <stdlib.h>

int *uniao( int *v1, int n1, int *v2, int n2, int *p3 );

void main() {
  int v1[4] = {5, 10, 15, 20};
  int v2[4] = {5, 10, 12, 20};
  int p3;
  int *unido = uniao(v1, 4,v2,4,&p3);

  for(int i = 0; i < p3; i++) {
    printf("%d\t",unido[i]);
  }
  free(unido);
}
int *uniao( int *v1, int n1, int *v2, int n2, int *p3 ){
  int *vet = (int *) malloc((n1) * sizeof(int));
  *p3 = n1;
  int achou = 0;
  for(int i=0; i < n1; i++) vet[i] = v1[i];
  for(int i = 0; i < n2; i++) {
    for(int j = 0; j < n1; j++) {
      if(achou == 1) break;
      if(v2[i] == v1[j]) {
        achou = 1;
        break;
      }
    }
    if(achou != 1) {
      vet = realloc(vet,(*p3)+1);
      vet[(*p3)] = v2[i];
      (*p3)++;
    }
    achou = 0;
  }
  return vet; //&vet[0]
}