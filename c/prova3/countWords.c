#include <stdio.h>
#include <string.h>

FILE* openFile(char* mode){
  FILE *f;
  f = fopen('file.txt', mode);

  if (f == NULL) {
    printf("Não foi possível abrir o arquivo.");
    return 0;
  }

  return f;
}

void count(){
  FILE *file = openFile("r+");
  char name[30];
  int n = 0;
  printf("Digite a palavra: ");
  scanf(" %s",name);
  char fileWord[30];
  while(fread(&fileWord, 30 * sizeof(char), 1, file)){
    if(strcmp(fileWord,name) == 0) {
      n++;
    }
  }
  fclose(file);
  printf("Palavra encontrada %i vezes",n);
}

void main() {
  count();
}