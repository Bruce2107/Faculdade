#define ERRO_PILHA_VAZIA -1
#define ERRO_PILHA_CHEIA -2

typedef struct{
   char *dados;		// dados da pilha 
   int topo;		// indica o �ndice do topo
   int capacidade;	// capacidade do vetor alocado
} Pilha;

void inicializa_pilha ( Pilha *p, char c );
int pilha_vazia ( Pilha p );
int pilha_cheia ( Pilha p );
int empilha ( Pilha *p, char info );
int desempilha ( Pilha *p, char *info );
int le_topo ( Pilha p, char *info );
void mostra_pilha ( Pilha p );
void desaloca_pilha( Pilha *p );

