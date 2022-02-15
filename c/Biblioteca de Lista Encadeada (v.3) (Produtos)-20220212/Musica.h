#include "Lista.h"
#include <stdio.h>

typedef struct {
	int dia, mes, ano;
} Data;

typedef struct {
	char nome[30];
	char nacionalidade[20];
} Artista;

typedef struct{
	char nome_musica[30];
	int duracao;
	char estilo[20];
	Artista artista;
	Data data;
}Musica;

void le_musica( Musica *p );
void mostra_musica( Musica x );
void busca_musica_por_nome(Lista *l, char *nome_musica );
void busca_musica_por_artista(Lista *l, char *nome_artista);
void busca_musica_por_estilo(Lista *l, char *nome_estilo);
int insere_musica(Lista *l, Musica *m);
int compara_nome_musica(void *x, void *y);
int compara_artista_musica(void *x, void *y);
int compara_estilo(void *x, void *y);
void mostra_music(void *x);
int remove_musica(Lista *l, int pos);
int valida_data_musica(Musica *m);

void carrega_arquivo(Lista *l);
FILE *inicializa_arquivo(char *mode);
void salva_arquivo(Lista *l);