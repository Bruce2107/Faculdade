type Occurrence = {
  count: number;
  value: number;
};

type DataOccurrence = {
  [key: string]: number;
};

export type WeightedData = {
  value: number;
  pound: number;
};

export class Statistic {
  constructor(
    private data: number[] = [],
    private weightedData: WeightedData[] = []
  ) {}

  private sort(a: number, b: number) {
    return a - b;
  }
  private reduce(a: number, b: number) {
    return a + b;
  }
  private greatest(counter: number[]): number {
    return Math.max.apply(null, counter);
  }
  private mapOccurrences(value: number): Occurrence {
    return { count: 1, value };
  }
  private countOccurrences(a: DataOccurrence, b: Occurrence) {
    a[b.value] = (a[b.value] || 0) + b.count;
    return a;
  }
  private mapToArray(obj: DataOccurrence) {
    const counter: number[] = [];
    Object.keys(obj).filter((a) => {
      counter.push(obj[a]);
    });
    return counter;
  }
  private filterMode(contagem: DataOccurrence, MAX: number) {
    return Object.keys(contagem).filter((a) => {
      return contagem[a] === MAX && contagem[a] > 1 ? contagem[a] : null;
    });
  }

  public median() {
    if (this.data.length === 0) return 0;

    this.data.sort(this.sort);

    const half = Math.floor(this.data.length / 2);

    if (this.data.length % 2) return this.data[half];
    return (this.data[half - 1] + this.data[half]) / 2.0;
  }

  public mean(v?: number[]) {
    const temp = v || this.data;
    return temp.reduce(this.reduce) / temp.length;
  }

  public mode() {
    const temp = this.data;
    const count = temp
      .sort(this.sort)
      .map(this.mapOccurrences)
      .reduce(this.countOccurrences, {});

    const filtered = this.filterMode(
      count,
      this.greatest(this.mapToArray(count))
    );
    return filtered.length ? filtered : 0;
  }

  public midpoint() {
    this.data.sort(this.sort);
    return (this.data[0] + this.data[this.data.length - 1]) / 2;
  }

  public weightedAverage() {
    let pound = 0;
    let value = 0;
    this.weightedData.forEach((i) => {
      pound += i.pound;
      value += i.value * i.pound;
    });
    return value / pound;
  }

  public harmonic() {
    const temp = this.data;
    const sum = temp.map((i) => 1 / i).reduce(this.reduce);
    return temp.length / sum;
  }

  public geometric() {
    const temp = this.data;
    const multi = temp.reduce((a, b) => a * b);
    return Math.pow(multi, temp.length);
  }
  public quadratic() {
    const temp = this.data;
    const sum = temp.map((i) => Math.pow(i, 2)).reduce(this.reduce);
    return Math.sqrt(sum / temp.length);
  }

  public truncate(p: number) {
    const removeNumber = Math.trunc(this.data.length * (p / 100));
    this.data.sort(this.sort);
    return this.mean(
      this.data.slice(removeNumber, this.data.length - removeNumber)
    );
  }
}
