export class Discount {
  /**
   * Desconto Racional Simples
   * @param D Desconto
   * @param N Valor nominal
   * @param i Taxa de juros (valor decimal)
   * @param n Tempo
   * @returns
   */
  DRS(D?: number, N?: number, i?: number, n?: number) {
    if (!D && N && i && n) {
      return (1 - 1 / (1 + i * n)) * N;
    }
    if (D && !N && i && n) {
      return D / (1 - 1 / (1 + i * n));
    }
    if (D && N && !i && n) {
      const x = 1 - D / N;
      return (1 - x) / (x * n);
    }
    if (D && N && i && !n) {
      const x = 1 - D / N;
      return (1 - x) / (x * i);
    }

    return 0;
  }

  /**
   * Desconto Comercial Simples
   * @param D Desconto
   * @param N Valor nominal
   * @param d Taxa de desconto (valor decimal)
   * @param n Tempo
   * @returns
   */
  DCS(D?: number, N?: number, d?: number, n?: number): number {
    if (!D && N && d && n) {
      return N * d * n;
    }
    if (D && !N && d && n) {
      return D / (d * n);
    }
    if (D && N && !d && n) {
      return D / (N * n);
    }
    if (D && N && d && !n) {
      return D / (d * N);
    }

    return 0;
  }

  /**
   * Desconto Racional Composto
   * @param D Desconto
   * @param N Valor nominal
   * @param i Taxa de juros (valor decimal)
   * @param n Tempo
   * @returns
   */
  DRC(D?: number, N?: number, i?: number, n?: number): number {
    if (!D && N && i && n) {
      return (1 - 1 / Math.pow(1 + i, n)) * N;
    }
    if (D && !N && i && n) {
      return Math.pow((1 - 1 / Math.pow(1 + i, n)) / D, -1);
    }
    if (D && N && !i && n) {
      return Math.pow(N / (N - D), 1 / n) - 1;
    }
    if (D && N && i && !n) {
      return -Math.log(1 - D / N) / Math.log(1 + i);
    }

    return 0;
  }

  /**
   * Desconto Comercial Composto
   * @param D Desconto
   * @param N Valor nominal
   * @param i Taxa de juros (valor decimal)
   * @param n Tempo
   * @returns
   */
  DCC(D?: number, N?: number, i?: number, n?: number): number {
    if (!D && N && i && n) {
      return N * (Math.pow(1 + i, n) - 1);
    }
    if (D && !N && i && n) {
      return D / (Math.pow(1 + i, n) - 1);
    }
    if (D && N && !i && n) {
      const x = D / N + 1;
      return Math.pow(x, 1 / n) - 1;
    }
    if (D && N && i && !n) {
      const x = D / N + 1;
      const y = 1 + i;
      return Math.log(x) / Math.log(y);
    }

    return 0;
  }
}

export class InterestRate {
  /**
   * Taxa Aparente
   * @param i Taxa aparente
   * @param ir Taxa real
   * @param I Inflação
   * @returns
   */
  TA(i?: number, ir?: number, I?: number): number {
    if (!i && ir && I) {
      return (1 + ir) * (1 + I) - 1;
    }
    if (i && !ir && I) {
      return (1 + i) / (1 + I) - 1;
    }
    if (i && ir && !I) {
      return (1 + i) / (1 + ir) - 1;
    }
    return 0;
  }
  /**
   * Equivalência de juros para juros compostos
   * @param iM Taxa de juros do maior período
   * @param im Taxa de juros do menor período
   * @param k Multiplicidade do período menor dentro do maior
   * @returns
   */
  EJ(iM?: number, im?: number, k?: number): number {
    if (!iM && im && k) {
      return Math.pow(1 + im, k) - 1;
    }
    if (iM && !im && k) {
      return Math.pow(1 + iM, 1 / k) - 1;
    }
    if (iM && im && !k) {
      return Math.log(1 + iM) / Math.log(1 + im);
    }
    return 0;
  }
  /**
   * Capitalização Juros Compostos
   * @param S Montante gerado
   * @param P Montante inicial
   * @param i Taxa de jutos
   * @param n Tempo (negativo para descapitalização)
   * @returns
   */
  CJC(S?: number, P?: number, i?: number, n?: number): number {
    if (!S && P && i && n) {
      return P * Math.pow(1 + i, n);
    }
    if (S && !P && i && n) {
      return S / Math.pow(1 + i, n);
    }
    if (S && P && !i && n) {
      return Math.pow(S / P, 1 / n) - 1;
    }
    if (S && P && i && !n) {
      return Math.log(S / P) / Math.log(1 + i);
    }
    return 0;
  }
  /**
   * Juros Compostos Parcelado
   *
   * Usar para cálculos com tempo sequencial (1,2,3,...)
   * @param n Tempo
   * @param S Montante final
   * @param P Montante da parcela
   * @param i Taxa de juros
   * @returns
   */
  JCP(n: number, S?: number, P?: number, i?: number): number {
    if (!S && P && i && n > 0) {
      if (n === 0) {
        return P;
      } else {
        return P * Math.pow(1 + i, n) + this.JCP(n - 1, undefined, P, i);
      }
    }
    if (!S && P && i && n < 0) {
      if (n === 0) {
        return 0;
      } else {
        return P * Math.pow(1 + i, n) + this.JCP(n + 1, undefined, P, i);
      }
    }
    return 0;
  }
}
