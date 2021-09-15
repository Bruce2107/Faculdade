def converte(num):
    binario = []
    numero = num
    # cria um vetor com o numero binario da direira pra esquerda
    if numero == 1:
        binario.append(1)
    else:
        while True:
            if numero % 2 == 0:  # se o resto da divisao for 0 guarda 0 no vetor senao 1
                binario.append(0)
            else:
                binario.append(1)
            numero //= 2  # pega a parte inteira da divisao
            if numero == 1:  # se o numero chegar a 1 guarda 1 e para o loop
                binario.append(1)
                break
        # inverte o vetor
        invertido = []
        for i in range(0, len(binario)):
            invertido.append(binario[len(binario) - 1 - i])
        binario = invertido
    return binario




numero = 15
print((converte(255)))
print((converte(100)))
print((converte(89)))
print((converte(52)))
print((converte(150)))