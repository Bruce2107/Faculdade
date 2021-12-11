#include <stdio.h>
#include <stdlib.h>  

int main () {  
  int n;   
  printf("Informe a quantidade de luvas: ");     
  scanf("%d", &n);      
  int x[n];

  for(int i = 0; i < n; i++) {         
    scanf("%d", &x[i]);     
  }  

  int aux;
  for (int i = 0; i < n; i++){
    for (int j = 0; j < n; j++){
      if (x[i] < x[j]){
        aux = x[i];
        x[i] = x[j];
        x[j] = aux;
      }
    }
  }

  
  int count = 0;
  for(int i=1; i<n; i++) {
    for(int j=i+1; j<n; j++){
      if(x[i] == x[j] && x[i] != x[i-1])
      {
          count++;
          break;
      }
    }
  }
  int vA[n], k = 0;
  for(int i = 0; i < n - 1; i++) {
    if(x[i] == x[i+1]){
      printf("par");
    }
  }
  // if(count > 0){
  //   int values[count],k = 0;
  //   for(int i=1; i<n; i++) {
  //     for(int j=i+1; j<n; j++){
  //       if(x[i] == x[j] && x[i] != x[i-1])
  //       { 
  //           values[k] = x[j];
  //           k++;
  //           break;
  //       }
  //     }
  //   }      
  //   if(count > 1)
  //     printf("\n%i pares (", count);
  //   else
  //     printf("\n%i par (", count);
  //   for(int i = 0; i < count; i++) {
  //     if(count - i == 1)
  //       printf("tamanho %i",values[i]);
  //     else 
  //       if(count - i - 1 == 1)
  //         printf("tamanho %i e ", values[i]);
  //       else
  //         printf("tamanho %i, ", values[i]);
  //   }
  //   printf(")");
  // } else {
  //   printf("Não há pares");
  // }
}