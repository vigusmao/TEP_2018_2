from time import time

memo = {}

def f(n):
    if n == 1:
        return 1
    if n % 2 == 1:
        return 3*n + 1
    return n/2

def g(n):
    if n == 1:
        return 1
    valor_do_memo = memo.get(n)
    if valor_do_memo is not None:
        return valor_do_memo
    
    result = 1 + g(f(n))
    memo[n] = result
    return result

while True:
    memo.clear()
    lmin, lmax = eval(input("lmin, lmax = "))
    start = time()
    
    melhor_n = lmin
    maior_seq = g(lmin)
    for x in range(lmin + 1, lmax + 1):
        tamanho = g(x)
        if tamanho > maior_seq:
            melhor_n = x
            maior_seq = tamanho
    duracao = time() - start
    print("n* = %d, g(n*) = %d, duracao = %.3f segundos" %
          (melhor_n, maior_seq, duracao))


    
