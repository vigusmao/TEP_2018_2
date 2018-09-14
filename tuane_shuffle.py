from random import randint

def sortear(n, k):
    tabela = {}
    sorteados = []
    for i in range(k):
        pos = randint(1, n-i)
        sorteado = tabela.get(pos, pos)
        sorteados.append(sorteado)
        elemento_da_ultima_pos = tabela.get(n-i, n-i)
        tabela[pos] = elemento_da_ultima_pos  # "swap"
    return sorteados



n, k = eval(input("n, k = "))
for _ in range(20):
    print(sortear(n, k))


        
        
