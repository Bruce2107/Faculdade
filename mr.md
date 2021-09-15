# Olá

## como vc pode ver parece que eu sou bem pequeno, mas não se engane, passei por umas turbulencias e acabei sendo dividido, por favor "revise" o MR [!58](https://linkinvalido/gif-odete/odete-react/portal-adm/merge_requests/58)

Primeiramente vou explicar o motivo de ter dois MR e um já estar mergeado.

No inicio de setembro (01/09 até 08/09), eu precisei me ausentar, nesse periodo um dev do meu time estava resolvendo um problema de CORS e para testar se estava funcionado corretamente. Não cabe agora discutirmos o motivo de ocorrer esse merge sem os code reviews necessarios, mas agradeço se revisar e adicionar comentarios neste MR, mesmo que referentes ao outro

Agora vamos listar as funcionalidades dessa tela

### Atualize as dependencias

1. Criação de um componente de loading simples
2. Atualização do axios
3. Uso do dropzone para o .csv

4. Campo de DN do produto, com duas variações
  4.1 Caso a busca de dns ocorra com sucesso é usado um select
  4.2 Caso ocorra um erro o campo é alterado para um texto simples com validação de intervalo
5. No cenario em que há erro ao enviar o arquivo para cashback, os erros são listados no modal

Dicas para criar um cartão

1. Passe o valor de 0(zero) no campo de quantidade de clientes para gerar erro no modal
2. Passar mais de um campo errado, mostrará mais efetivamente a listagem de erro
3. Massa para teste:
 3.1 Qnt: 10, valor: 0,10,
 3.2 Qnt: 50k, valor: ,
 3.3 Qnt: 200k, valor: , 