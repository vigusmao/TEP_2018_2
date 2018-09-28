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



#                           40
#             39                          38
#    38           37                   36       37
#         36 37  35  36              34  35  35    36
              
   # P(40)  = 1
   # P(39)  = 1
   # P(38)  = 2
   # P(37)  = 3
   # P(36)  = 5
   # P(1)   = Fib(40)
