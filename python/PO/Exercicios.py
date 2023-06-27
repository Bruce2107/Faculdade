# Eduardo Henrique

import pulp as pl

problem = pl.LpProblem("Custo", pl.LpMinimize)

x1 = pl.LpVariable("X1", lowBound=0)
x2 = pl.LpVariable("X2", lowBound=0)

problem += x1 + 2 * x2
problem += 8 * x1 + 2 * x2 >= 16
problem += 1 * x1 + 1 * x2 >= 6
problem += 2 * x1 + 7 * x2 >= 28

problem.solve()

print("Status:", pl.LpStatus[problem.status])
print("Custo = R$", pl.value(problem.objective))
for var in problem.variables():
    print(var.name, "=", var.varValue)

problem2 = pl.LpProblem("Lucro", pl.LpMaximize)

x1 = pl.LpVariable("X1", lowBound=0)
x2 = pl.LpVariable("X2", lowBound=0)

problem2 += 18 * x1 + 22 * x2
problem2 += 4 * x1 + 6 * x2 <= 500
problem2 += (1 / 16) * x1 + (1 / 9) * x2 <= 8

problem2.solve()

print("Status:", pl.LpStatus[problem2.status])
print("Lucro = R$", pl.value(problem2.objective))
for var in problem2.variables():
    print(var.name, "=", var.varValue)

problem3 = pl.LpProblem("Lucro", pl.LpMaximize)

x1 = pl.LpVariable("X1", lowBound=0)
x2 = pl.LpVariable("X2", lowBound=0)

problem3 += 60 * x1 + 40 * x2
problem3 += 10 * x1 + 10 * x2 <= 100
problem3 += 3 * x1 + 7 * x2 <= 42

problem3.solve()

print("Status:", pl.LpStatus[problem3.status])
print("Lucro = R$", pl.value(problem3.objective))
for var in problem3.variables():
    print(var.name, "=", var.varValue)

problem4 = pl.LpProblem("Custo", pl.LpMinimize)

x1 = pl.LpVariable("X1", lowBound=0)
x2 = pl.LpVariable("X2", lowBound=0)

problem4 += 0.06 * x1 + 0.08 * x2
problem4 += 8 * x1 + 6 * x2 <= 48
problem4 += 1 * x1 + 2 * x2 <= 20
problem4 += 1 * x1 + 2 * x2 >= 12

problem4.solve()
print("Status:", pl.LpStatus[problem4.status])
print("Lucro = R$", pl.value(problem4.objective))
for var in problem4.variables():
    print(var.name, "=", var.varValue)

problem5 = pl.LpProblem("Lucro", pl.LpMaximize)

x1 = pl.LpVariable("X1", lowBound=0)
x2 = pl.LpVariable("X2", lowBound=0)

problem5 += 0.12 * x1 + 0.35 * x2

problem5 += 1 * x1 + 1 * x2 <= 160000
problem5 += 0.4 * x1 + 0.2 * x2 <= 70000
problem5 += x1 <= 100000
problem5 += x2 <= 85000

problem5.solve()

print("Status:", pl.LpStatus[problem5.status])
print("Lucro = R$", pl.value(problem5.objective))
for var in problem5.variables():
    print(var.name, "=", var.varValue)
