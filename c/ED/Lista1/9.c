#include <stdio.h>
#include <stdlib.h>

int *separar(int *v, int n,int *sp, int *sn);

void main() {
  int vetor[4] = {5,-10,15,-20};
  int sp,sn;
  separar(vetor,4, &sp,&sn);
}

int *separar(int *v, int n,int *sp, int *sn){
  *sp = *sn = 1;

  int *vp = (int *) malloc((*sp) * sizeof(int));
  int *vn = (int *) malloc((*sn) * sizeof(int));

  for(int i = 0; i < n; i++) {
    if(v[i] > 0) {
      if((*sp) == 1) {
        vp[(*sp)-1] = v[i];
        vp = realloc(vp,(*sp)+1);
      }else{
        vp = realloc(vp,(*sp)+1);
        vp[(*sp)-1] = v[i];
      }
      (*sp)++;
    }else {
      if((*sn) == 1) {
        vn[(*sn)-1] = v[i];
        vn = realloc(vn,(*sn)+1);
      }else{
        vn = realloc(vn,(*sn)+1);
        vn[(*sn)-1] = v[i];
      }
      (*sn)++;
    }
  }
  (*sp)--;
  (*sn)--;

  for(int i = 0; i < n; i++) printf("%d\t",v[i]);
  printf("\n");
  for(int i = 0; i < (*sp); i++) printf("%d\t",vp[i]);
  printf("\n");
  for(int i = 0; i < (*sn); i++) printf("%d\t",vn[i]);
  free(vp);
  free(vn);
}