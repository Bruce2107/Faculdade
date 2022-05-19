#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct  {
  int** matrix;
  int row;
  int col;
} Matrix;

Matrix createMatrix(int row, int col) {
  Matrix m;
  m.col = col;
  m.row = row;
  m.matrix = calloc(row, sizeof(int*));
  for(int i = 0; i < row; i++) {
    m.matrix[i] = calloc(col, sizeof(int));
  }
  return m;
}

void printMatrix(Matrix m){
  for(int i = 0; i < m.row; i++) {
    for(int j = 0; j < m.col; j++) {
      printf("%d\t",m.matrix[i][j]);
    }
    printf("\n");
  }
}

void updateMatrix(int pr,int pc,int v,Matrix m) {
  if(pr > (m.row -1) || pc > (m.col - 1)) {
    return;
  }
  m.matrix[pr][pc] = v;
}
int getMatrixPos(int pr,int pc,Matrix m) {
  if(pr > (m.row-1) || pc > (m.col-1)) {
    return;
  }
  return m.matrix[pr][pc];
}

int min(int a, int b) {
    return (a < b) ? a : b;
} 

int levenshtein(char *s1, char *s2) {
    int m = strlen(s1);
    int n = strlen(s2);

    Matrix M = createMatrix(m,n);
    for(int i = 0; i < m; i++)
        updateMatrix(i,0,i,M);
    for(int i = 0; i < n; i++) 
        updateMatrix(0,i,i,M);
    for(int i = 1; i < m; i++)
        for(int j = 1; j < n; j++){
            int custo = (s1[i] == s2[j]) ? 0 : 1;
            int r = min(min(getMatrixPos(i-1,j,M)+1,getMatrixPos(i-1,j-1,M)+custo),getMatrixPos(i,j-1,M)+1);
            updateMatrix(i,j,r,M);
        }
    //printf("%d\n",getMatrixPos(m-1,n-1,M));
    //printMatrix(M);
    return getMatrixPos(m-1,n-1,M);
}

void main() {
    char *p1 = "exercício", *p2 = "exército", p3[20], p4[20];
    fgets(p3, sizeof(p3), stdin);
    fgets(p4, sizeof(p4), stdin);
    printf("%d",levenshtein(p1,p2));
}