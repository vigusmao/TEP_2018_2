#include <stdlib.h>
#include <stdio.h>

int loop1(int n) {
    int i, j, count=0;
    for (i=1; i<=n; i++) {
        for (j=1; j<=n; j++) {
            count++;
        }
    }
    return count;
}

int loop2(int n) {
    int i, j, count=0;
    for (i=1; i<=n; i++) {
        for (j=i+1; j<=n; j++) {
            count++;
        }
    }
    return count;
}

int loop3(int n) {
    int i, j, count=0;
    for (i=1; i<=n; i++) {
        for (j=1; j<=n; j*=2) {
            count++;
        }
    }
    return count;
}

int loop4(int n) {
    int i, j, count=0;
    for (i=1; i<=n; i++) {
        for (j=i; j<=n; j+=i) {
            count++;
        }
    }
    return count;
}

int loop5(int n) {
    int i, j, count=0, step=1;
    for (i=0; i<n; i++) {
        for (j=1; j<=n; j+=step) {
            count++;
        }
        if (step < n) {
            step*=2;
        }
    }
    return count;
}

int loop6(int n, int m) {
    int v, w; 
    for (v=1; v<=n; v++) {
        for w in N(v) {
            faca algo com w em tempo O(1)
        }
    }
}



}








int main() {
    int N;
    for (N=10; N<=10240; N*=2) {
        printf("\n\nN=%d", N);
        printf("\nloop1 --> %d", loop1(N));
        printf("\nloop2 --> %d", loop2(N));
        printf("\nloop3 --> %d", loop3(N));
        printf("\nloop4 --> %d", loop4(N));
        printf("\nloop5 --> %d", loop5(N));    
    }
    return 0;
}



