#include "matrizLib.h"
#include <stdlib.h>
#include <stdio.h>

Matrix createMatrix(int row, int col) {
  Matrix m;
  m.col = col;
  m.row = row;
  m.matrix = calloc(row, sizeof(double*));
  for(int i = 0; i < row; i++) {
    m.matrix[i] = calloc(col, sizeof(double));
    // for(int j = 0; j < col; j++)
      // m.matrix[i][j] = 0.0;
  }
  return m;
}

void printMatrix(Matrix m){
  for(int i = 0; i < m.row; i++) {
    for(int j = 0; j < m.col; j++) {
      printf("%.2f\t",m.matrix[i][j]);
    }
    printf("\n");
  }
}

void updateMatrix(int pr,int pc,double v,Matrix m) {
  if(pr > (m.row -1) || pc > (m.col - 1)) {
    printf("Posição invalida");
    return;
  }
  m.matrix[pr][pc] = v;
}
void getMatrixPos(int pr,int pc,Matrix m) {
  if(pr > (m.row-1) || pc > (m.col-1)) {
    printf("Posição invalida");
    return;
  }
  printf("%.2f",m.matrix[pr][pc]);
}

int compareMatrix(Matrix m1, Matrix m2) {
  if(m1.row != m2.row || m1.col != m2.col) return 0;
  for(int i = 0; i < m1.row; i++)
    for(int j = 0; j < m1.col; j++)
      if(m1.matrix[i][j] != m2.matrix[i][j])
        return 0;
  return 1;
}

Matrix sumMatrix(Matrix m1, Matrix m2) {
  if(m1.row == m2.row && m1.col == m2.col) {
    Matrix sum = createMatrix(m1.row,m1.col);
    for(int i = 0; i < m1.row; i++)
      for(int j = 0; j < m1.col; j++)
        sum.matrix[i][j] = m1.matrix[i][j] + m2.matrix[i][j];
    return sum;
  }
  printf("soma n realizada");
}

Matrix multiMatrix(Matrix m1, Matrix m2) {
  Matrix m3 = createMatrix(m1.row,m2.col);
  for(int i=0; i <m1.row; i++)
    for(int j=0; j<m2.col; j++){
      int somaprod=0;
      for(int k=0; k<m1.row; k++) somaprod+=m1.matrix[i][k]*m2.matrix[k][j];
      m3.matrix[i][j]=somaprod;
    } 
}