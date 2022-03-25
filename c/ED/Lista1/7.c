#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *repetidor( char *s, int n );

int main() {  
  char s1[] = "abc";
  char *s2 = repetidor(s1, 4);
  
  printf("%s\n", s2);
  
  free(s2);

  return 0;
}

char *repetidor( char *s, int n ){
  int n1 = strlen(s);
  char *p = malloc( (n1*n) + 1 );
  int i, j, controle = 0;
    
  for( i = 0 ; i < n ; i++){
    for( j = 0 ; j < n1 ; j++){
      p[controle] = s[j];
      controle++;
    }
  }
  p[n*n1] = '\0';
  
  return p;
}