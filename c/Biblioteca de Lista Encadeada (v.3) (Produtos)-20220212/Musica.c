#include "Musica.h"
#include "Lista.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define FILENAME "musicas.txt"

void le_musica(Musica *p ){
	int cont = 0;
	printf("Digite o nome da musica: ");
	scanf(" %[^\n]", &p->nome_musica);
	printf("Digite a estilo: ");
	scanf(" %[^\n]", &p->estilo);
	printf("Digite a duracao: ");
	scanf("%d", &p->duracao);
	printf("Digite o nome do artista: ");
	scanf(" %[^\n]", &p->artista.nome);
	printf("Digite a nacionalidade do artista: ");
	scanf(" %[^\n]", &p->artista.nacionalidade);
	do {
		if(cont > 0) {
			printf("Data invalida\n");
		}
		printf("Digite o dia de hoje: ");
		scanf("%d", &p->data.dia);
		printf("Digite o mes atual: ");
		scanf("%d", &p->data.mes);
		printf("Digite o ano atual: ");
		scanf("%d", &p->data.ano);
		cont++;
		
	} while (!valida_data_musica(p));
}

void mostra_musica(Musica x ){
	printf("Nome: %s\tEstilo: %s\tDuracao: %ds\tArtista: %s\tNacionalidade artista: %s\tData: %d/%d/%d\n", 
			x.nome_musica,
			x.estilo,
			x.duracao,
			x.artista.nome,
			x.artista.nacionalidade,
			x.data.dia,
			x.data.mes,
			x.data.ano);
}

int compara_nome_musica( void *x, void *y ){
	Musica *a = x;
	char *b = y;
	return strcmp(a->nome_musica, b);
}

int compara_artista_musica( void *x, void *y ){
	Musica *a = x;
	char *b = y;
	return strcmp(a->artista.nome, b);
}

int compara_musica(void *x, void *y) {
	Musica *a = x, *b = y;
	return strcmp(a->artista.nome, b->artista.nome) && strcmp(a->nome_musica, b->nome_musica);
}

int compara_estilo( void *x, void *y ){
	Musica *a = x;
	char *b = y;
	return strcmp(a->estilo, b);
}

void busca_musica_por_nome(Lista *l, char *nome_musica ){
	Lista nomes = busca_varios((*l), nome_musica, compara_nome_musica);
	if(lista_vazia(nomes))
		printf("\nMusica nao encontrada!\n");
	else{
		//loop
		// busca 1 musica da lista de nomes por -> artista + nome
		// retorna a posicao na lista l
		// int qnt = nomes.qtd;
		mostra_lista(nomes, mostra_music);
		Musica auxMusica;
		for (int i = 0; le_valor(nomes,&auxMusica,i) != ERRO_POS_INVALIDA; i++) {
			// mostra_musica(auxMusica);
			// mostra_musica((Musica) nomes.cabeca[i].info);
			// int idx = busca((*l), nomes.cabeca[i].info, compara_musica);
			// Musica m;
			// printf("Encontrada no indice %d: ", idx);
			// le_valor( (*l), &m, idx );
			// mostra_musica(m);
		}
	}
}

void busca_musica_por_artista(Lista *l, char *nome_artista ){
	int idx = busca((*l), nome_artista, compara_artista_musica);
	if( idx == -1 )
		printf("\nMusica nao encontrada!\n");
	else{
		Musica m;
		printf("Encontrada no indice %d: ", idx);
		le_valor( (*l), &m, idx );
		mostra_musica(m);
	}
}

void busca_musica_por_estilo(Lista *l, char *nome_estilo ){
	int idx = busca((*l), nome_estilo, compara_estilo);
	if( idx == -1 )
		printf("\nMusica nao encontrada!\n");
	else{
		Musica m;
		printf("Encontrada no indice %d: ", idx);
		le_valor( (*l), &m, idx );
		mostra_musica(m);
	}
}

void mostra_music( void *x ){
	Musica *p = x;
	mostra_musica(*p);
}

int insere_musica(Lista *l, Musica *m) {
	Lista indices = busca_varios( (*l), m, compara_nome_musica);
	if( lista_vazia( indices ) ) {
		insere_ordem(l, m, compara_nome_musica);
		return 1;
	}

	if(lista_vazia(busca_varios(indices,m,compara_artista_musica))) {
		insere_ordem(l, m, compara_nome_musica);
		return 1;
	}
	return 0;	
}

int valida_data_musica(Musica *m) {
	return (m->data.dia >= 1 && m->data.dia <= 31) && 
	(m->data.mes >= 1 && m->data.mes <= 12) && 
	(m->data.ano >= 1900 && m->data.ano <= 3022);
}

int remove_musica(Lista *l,int pos) {
	Musica m;
	int res;

	if(pos > l->qtd) {
		printf("Posição inválida. A música não será apagada!\n");
		return 0;
	}

	le_valor((*l), &m, pos);
	printf("Deseja apagar esta musica? 1 - sim 0 - n\n");
	mostra_musica(m);
	scanf("%d", &res);
	if(res) {
		remove_pos(l, &m, pos);
		return 1;
	}
	return 0;
}


FILE* inicializa_arquivo(char* mode){
  FILE *f;
  f = fopen(FILENAME, mode);

  if (f == NULL) {
    printf("Não foi possível abrir o arquivo.");
    return 0;
  }

  return f;
}

int carrega_arquivo(Musica **pV, int *pN ){
	FILE *f = inicializa_arquivo("rt");
	int n;
	fscanf(f, "%d", &n);
	Musica *v = malloc( sizeof(Musica) * n );
	int i;
	for( i = 0 ; i < n ; i++ ){
		fscanf(f, " %[^\n]", &v[i].nome_musica);
		fscanf(f, " %[^\n]", v[i].estilo);
		fscanf(f, "%d", &v[i].duracao);
	}
	fclose( f );
	*pV = v;
	*pN = n;
	return 1; // Sucesso!
} 

int salva_arquivo(Lista *l){
 	FILE *file = inicializa_arquivo("r+");
	Musica newMusic;
	for (int i = 0; le_valor((*l),&newMusic,i) != ERRO_POS_INVALIDA;i++) {
		fwrite(&newMusic, sizeof(Musica), 1, file);
	}

	fclose(file);
}