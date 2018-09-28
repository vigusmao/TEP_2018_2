from random import randint

VALOR = 0
PESO = 1

memo = {}

"""
    params:
      items -- Uma lista de pares (valor, peso)
      indice_max -- maior índice de item que posso colocar na mochila
      capac -- capacidade da mochila

    Retorna o valor máximo obtido.
"""
def mochila(items, capac, indice_max=None):
    if indice_max is None:
        indice_max = len(items) - 1

    result_from_memo = memo.get((capac, indice_max))
    if result_from_memo is not None:
        return result_from_memo
    
    if indice_max < 0 or capac <= 0:
        result = 0
    else:
        # Caso 1: eu LEVO o item de índice máximo
        v = items[indice_max][VALOR] 
        p = items[indice_max][PESO]
        
        valor1 = (v + mochila(items, capac - p, indice_max - 1)) \
                 if capac - p >= 0 else 0

        # Caso 2: eu NÃO LEVO o item de índice máximo
        valor2 = mochila(items, capac, indice_max - 1)

        result = max(valor1, valor2)
        
    memo[(capac, indice_max)] = result

    return result

objetos = []
memo.clear()
n = 50  #eval(input("n = "))
for _ in range(n):
    p = randint(1, 100)
    v = randint(1, 1000)
    objetos.append((v, p))

print(objetos)
print("Resultado = ", mochila(objetos, 5000))


    

