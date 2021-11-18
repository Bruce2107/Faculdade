// Algumas constantes �teis
#define ERRO_PILHA_VAZIA -1
#define ERRO_PILHA_CHEIA -2

typedef struct{
   int *dados;		// dados da pilha 
   int topo1,topo2;		// indica o �ndice do topo
   int capacidade;	// capacidade do vetor alocado
} Pilha;

void inicializa_pilha ( Pilha *p, int c );
int pilha_vazia1 ( Pilha p );
int pilha_vazia2 ( Pilha p );
int pilha_cheias ( Pilha p );
int empilha_topo1 ( Pilha *p, int info );
int empilha_topo2 ( Pilha *p, int info );
int desempilha_topo1 ( Pilha *p, int *info );
int desempilha_topo2 ( Pilha *p, int *info );
int le_topo1 ( Pilha p, int *info );
int le_topo2 ( Pilha p, int *info );
void mostra_pilha1 ( Pilha p );
void mostra_pilha2 ( Pilha p );
void desaloca_pilha( Pilha *p );