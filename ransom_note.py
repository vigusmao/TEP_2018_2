#!/bin/python3

import math
import os
import random
import re
import sys
from collections import defaultdict

# Complete the checkMagazine function below.
def checkMagazine(magazine, note):
    
    countByWord = defaultdict(int)
    for word in magazine:
        countByWord[word] += 1
    for ransomWord in note:
        countInMagazine = countByWord[ransomWord]
        if countInMagazine == 0:
            print("No")
            return
        countByWord[ransomWord] -= 1
    print("Yes")

    
    
    
    
    
if __name__ == '__main__':
    mn = input().split()

    m = int(mn[0])

    n = int(mn[1])

    magazine = input().rstrip().split()

    note = input().rstrip().split()

    checkMagazine(magazine, note)
