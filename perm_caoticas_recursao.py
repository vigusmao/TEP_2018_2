memo = {}


def perm_caoticas(n):
    result_from_memo = memo.get(n)
    if result_from_memo is not None:
        return result_from_memo
    
    if n == 1:
        result = 0
    elif n == 2:
        result = 1
    else:
        result = (n-1) * (perm_caoticas(n-1) + perm_caoticas(n-2))

    memo[n] = result
    return result
