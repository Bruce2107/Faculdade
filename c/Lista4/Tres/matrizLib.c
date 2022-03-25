#include "matrizLib.h"
#include <stdlib.h>
#include <stdio.h>

int convertPosition(int row, int col, int colReference) {
  return (row * colReference) + col;
}

Matrix createMatrix(int row, int col) {
  Matrix m;
  m.col = col;
  m.row = row;
  m.matrix = calloc(row*col, sizeof(double*));
  return m;
}

void printMatrix(Matrix m){
  for(int i = 0; i < m.row; i++) {
    for(int j = 0; j < m.col; j++) {
      printf("%.2f\t",m.matrix[convertPosition(i,j,m.col)]);
    }
    printf("\n");
  }
}

void updateMatrix(int pr,int pc,double v,Matrix m) {
  if(pr > (m.row -1) || pc > (m.col - 1)) {
    printf("Posição invalida");
    return;
  }
  m.matrix[convertPosition(pr,pc,m.col)] = v;
}

void getMatrixPos(int pr,int pc,Matrix m) {
  if(pr > (m.row-1) || pc > (m.col-1)) {
    printf("Posição invalida");
    return;
  }
  printf("%.2f",m.matrix[convertPosition(pr,pc,m.col)]);
}

int compareMatrix(Matrix m1, Matrix m2) {
  if(m1.row != m2.row || m1.col != m2.col) return 0;
  for(int i =  0; i < m1.row*m1.col; i++) 
    if(m1.matrix[i] != m2.matrix[i]) return 0;
  return 1;
}

Matrix sumMatrix(Matrix m1, Matrix m2) {
  if(m1.row == m2.row && m1.col == m2.col) {
    Matrix sum = createMatrix(m1.row,m1.col);
    for(int i = 0; i < sum.col*sum.row; i++) 
      sum.matrix[i] = m1.matrix[i]+m2.matrix[i];
    return sum;
  }
  printf("soma n realizada");
}

Matrix multiMatrix(Matrix m1, Matrix m2) {
  Matrix m3 = createMatrix(m1.row,m2.col);
  for(int i=0; i <m1.row; i++)
    for(int j=0; j<m2.col; j++){
      int somaprod=0;
      for(int k=0; k<m1.row; k++) somaprod+=m1.matrix[convertPosition(i,k,m3.col)]*m2.matrix[convertPostion(k,j,m3.col)];
      m3.matrix[convertPosition(i,j,m3.col)]=somaprod;
    } 
}