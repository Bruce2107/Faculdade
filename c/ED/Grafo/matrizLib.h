typedef struct  {
  double** matrix;
  int row;
  int col;
} Matrix;
Matrix createMatrix(int row, int col);
void printMatrix(Matrix matrix);
void updateMatrix(int pr,int pc,double v,Matrix m);
void getMatrixPos(int pr,int pc,Matrix m);
int compareMatrix(Matrix m1, Matrix m2);
Matrix sumMatrix(Matrix m1, Matrix m2);
Matrix multiMatrix(Matrix m1, Matrix m2);
void inicializa_matriz(Matrix *p, int l, int c);
int carrega_matriz_arquivo(char *nome_arq, Matrix *p);