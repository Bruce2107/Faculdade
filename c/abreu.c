#include <stdio.h>

int main(int argc, char** argv) {

    int vetor[4];
    int existe=0;
    int g=0, a;
    for(int i=0;i<4;i++){
        printf("Digite o %d numero ",i+1);
        scanf("%d",&vetor[i]);
        if(vetor[i]==0){g++;}
    }
    printf("\n\n");
    for(int i=0;i<4;i++){
        existe=1;
        a=vetor[i];
        for(int j=0;j<4;j++){
            if(a==vetor[j]&&i!=j){
                existe++;
                vetor[j]=0;
            }
        }
    printf(" o valor -->  %d - saiu --> %d - vezes\n",vetor[i],existe);
    }
    return 0;
}