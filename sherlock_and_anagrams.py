#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the sherlockAndAnagrams function below.
def sherlockAndAnagrams(s):
    palavras = {}
    size = len(s)
    for tamanho in range(1, size):
        for pos in range(size - tamanho + 1):
            palavra = s[pos : pos + tamanho]
            palavraSorted = tuple(sorted(list(palavra)))
            palavras[palavraSorted] = palavras.get(palavraSorted, 0) + 1
    total = 0
    for _, count in palavras.items():
        total += int(count * (count - 1) / 2)
    return total       
            
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input())

    for q_itr in range(q):
        s = input()

        result = sherlockAndAnagrams(s)

        fptr.write(str(result) + '\n')

    fptr.close()
