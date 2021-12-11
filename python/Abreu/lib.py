import numpy as np


def bisseccao( F, M , A, B,TOL=1E-5):
    p = (A+B)/2.0
    Fa = F(A,M)
    Fb = F(B,M)

    while ((B-A)/2)>TOL:
        Fp = F(p,M)
        if Fp == 0:
            return p
        if Fa == 0:
            return A
        if Fa*Fp<0:
            B = p
            Fb =Fp
        else:
            A = p
            Fa= Fp
        p = (A+B)/2.0
    return p

def gauss(P):
    lin,col = P.shape
    for i in range(lin):
        for j in range(i + 1, lin):
            ratio = P[j][i] / P[i][i]

            for k in range(col):
                P[j][k] = P[j][k] - ratio * P[i][k]

    x = np.zeros(lin)
    x[lin-1] = P[lin-1][lin]/P[lin-1][lin-1]
    for i in range(lin - 2, -1, -1):
        x[i] = P[i][lin]

        for j in range(i + 1, lin):
            x[i] = x[i] - P[i][j] * x[j]

        x[i] = x[i] / P[i][i]


    return x

