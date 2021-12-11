#include <stdio.h>
#include <string.h>

void Exibe_invertido(char mensagem[], int tamanho) {
  if (tamanho >= 0) {
    printf("%c", mensagem[tamanho]);
    Exibe_invertido(mensagem,tamanho-1);
  }
}
int main(){
  char mensagem[10];
  int tamanho;
  scanf("%s", mensagem);
  tamanho=strlen(mensagem)-1;
  Exibe_invertido(mensagem, tamanho);
  return 0;
}