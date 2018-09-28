def backtrack(estado_corrente, n, k, cont, subconjuntos):
    tamanho_atual = len(estado_corrente)

    # 1. verifique se o estado corrente merece tratamento especial
    #  (se é um estado "final")
    if tamanho_atual == k:
        subconjuntos.append(estado_corrente[:])  # encontrei um subconjunto de tamanho desejado!
        cont[0] += 1
        return  # nada mais a ser feito a partir deste estado atual

    # 2. para cada "candidato a próximo passo", faça...
    ultimo_usado = 0 if tamanho_atual == 0 else estado_corrente[-1]
    posicoes_que_faltam = k-tamanho_atual
    for candidato in range(ultimo_usado + 1, (n+1)-posicoes_que_faltam + 1):
    
        # 2.1 se candidato é de fato um próximo passo válido (verifica as restrições)

        # 2.2 modifica o estado corrente usando o candidato
        estado_corrente.append(candidato) 
        
        # 2.3 chamo recursivamente o próprio backtrack passando o novo estado
        backtrack(estado_corrente, n, k, cont, subconjuntos)
        
        # 2.4 limpo a modificação que fiz
        estado_corrente.pop()

def subconjuntos(n, k):
    # crio o estado inicial
    subconjunto = []
    cont_subconjuntos = [0]  # para fazermos "passagem por referência"
    lista = []
    backtrack(subconjunto, n, k, cont_subconjuntos, lista)
    print(cont_subconjuntos[0])
    for subconjunto in lista:
        print(subconjunto)


    
