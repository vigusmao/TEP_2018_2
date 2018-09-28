def backtrack(estado_corrente, n):

    # 1. verifique se o estado corrente merece tratamento especial
    #  (se é um estado "final")
    if len(estado_corrente) == n:
        print(estado_corrente)  # encontrei uma permutacao caótica!
        return  # nada mais a ser feito a partir deste estado atual

    posicao_a_ser_preenchida = len(estado_corrente) + 1
    
    # 2. para cada "candidato a próximo passo", faça...
    for candidato in range(1, n+1):
    
        # 2.1 se candidato é de fato um próximo passo válido (verifica as restrições)
        if candidato == posicao_a_ser_preenchida:
            continue  # descarto esse candidato, passo para o próximo
        if candidato in estado_corrente:
            continue  # esse número já apareço, não posso usá-lo!

        # 2.2 modifica o estado corrente usando o candidato
        estado_corrente.append(candidato) 
        
        # 2.3 chamo recursivamente o próprio backtrack passando o novo estado
        backtrack(estado_corrente, n)
        
        # 2.4 limpo a modificação que fiz
        estado_corrente.pop()

def perm_caoticas(n):
    # crio o estado inicial
    permutacao = []
    backtrack(permutacao, n)
    
