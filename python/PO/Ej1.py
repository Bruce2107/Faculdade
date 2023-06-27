# Uma empresa vende dois tipos de computadores.
# O computador do tipo I tem um lucro de R$100, e o computador do tipo II tem um lucro de R$150.
# O computador do Tipo I consome uma placa mãe e 1 pente de memória. Enquanto que o computador do Tipo II, consome 1 placa mãe e 2 pentes de memória.
# Sabendo que no estoque tem-se 10 placas mãe e 12 pentes de memória, encontre a combinação ideal que maximiza o lucro.

# Função Objetivo: 100X1+150X2
# Sujeito a Restrição de Placa Mãe: X1+X2≤10
# Restrição de Pente de Memória: X1+2X2≤12

import pulp as pl

problem = pl.LpProblem("Lucro", pl.LpMaximize)

x1 = pl.LpVariable("PC_Tipo_1", lowBound=0)
x2 = pl.LpVariable("PC_Tipo_2", lowBound=0)

problem += 100 * x1 + 150 * x2
problem += x1 + x2 <= 10
problem += x1 + 2 * x2 <= 12

problem.solve()

# print("Status:", pl.LpStatus[problem.status])
print("Lucro Máximo = R$", pl.value(problem.objective))
for var in problem.variables():
    print(var.name, "=", var.varValue)

problem2 = pl.LpProblem("Lucro", pl.LpMaximize)

x1 = pl.LpVariable("PC_Tipo_1", lowBound=0, cat=pl.LpInteger)
x2 = pl.LpVariable("PC_Tipo_2", lowBound=0, cat=pl.LpInteger)

problem2 += 100 * x1 + 150 * x2
problem2 += x1 + x2 <= 10
problem2 += x1 + 2 * x2 <= 12
problem2 += 48 * x1 + 60 * x2 <= 480

problem2.solve()

print("Status:", pl.LpStatus[problem.status])
print("Lucro Máximo = R$", pl.value(problem2.objective))
for var in problem2.variables():
    print(var.name, "=", var.varValue)
