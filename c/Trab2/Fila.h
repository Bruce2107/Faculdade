// Algumas constantes �teis
#define MAX 32
#define ERRO_FILA_VAZIA -1
#define ERRO_FILA_CHEIA -2

typedef struct{
   int dados[MAX]; // dados da fila 
   int inicio;     // �ndice do in�cio da fila
   int n;          // qtd. de elementos da fila
} Fila;

void inicializa_fila ( Fila *p );
int fila_vazia ( Fila f );
int fila_cheia ( Fila f );
int inserir ( Fila *p, int info );
int remover ( Fila *p, int *info );
void mostra_fila ( Fila f );

