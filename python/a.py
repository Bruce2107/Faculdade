# Leitura de dados
L = int(input())
texto=list()

for i in range (L):
  t=input()
  texto.append(t.lower())

mensagem=input()
count=0
indiceLetra = 0
countPalavra = 0
for frase in texto:
  if len(frase)>0:
    aux=frase.split(" ")
    for palavra in aux:
      countPalavra+=1
      if (palavra.lower().find(mensagem[indiceLetra])):
        print(palavra)
        #print(mensagem[indiceLetra],": palavra ",countPalavra,", letra ")
        indiceLetra+=1