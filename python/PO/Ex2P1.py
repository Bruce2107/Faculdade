import pandas as pd
import pulp as pl


def resolve_problema(df_problem):
    Nomes = df_problem.columns[1:-3]
    print(Nomes)
    Variaveis = [pl.LpVariable(nome, lowBound=0) for nome in Nomes]
    c = df_problem.iloc[1, 1:-3].values
    rest = df_problem.iloc[2:, 0].values
    M = df_problem.iloc[2:, 1:-3].values
    b = df_problem["b"].values[2:]

    def SOMARPRODUTO(vetor1, vetor2):
        return pl.LpAffineExpression(list(zip(vetor1, vetor2)))

    problema_excel = pl.LpProblem("Portfolio", pl.LpMaximize)

    problema_excel += SOMARPRODUTO(Variaveis, c)
    for i in range(len(M)):
        problema_excel += (SOMARPRODUTO(Variaveis, M[i]) <= b[i], rest[i])
    problema_excel.solve()

    for v in problema_excel.variables():
        print(f"Variável {v.name}:{v.varValue}")
        df_problem.loc[0, v.name] = v.varValue
    df_problem.loc[1, "Formulas"] = pl.value(problema_excel.objective)
    df_problem.to_excel("./Resultado.xlsx", index=False)


FILE_PATH = "./Ex2P2.xlsx"  # "./Ex2P1.xlsx"
df_problem = pd.read_excel(FILE_PATH)
resolve_problema(df_problem)
