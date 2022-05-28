// melhor caso -> item do meio
// caso médio -> qualquer outra posição
// pior caso -> item das pontas ou nao encontrado

function generateVector(length) {
  return Array.from({ length }, (v, k) => Math.floor(Math.random() * 100));
}
const sizes = [10, 100, 1000, 10000, 100000];
const key = Math.floor(Math.random() * 100);

const results = (() => {
  const result = [];
  sizes.forEach((size) => {
    const vector = generateVector(size);
    result.push({
      l: size,
      c: binaria(
        key,
        vector.sort((a, b) => a - b),
        size
      ),
    });
  });
  return result;
})();

function binaria(key, vector, length) {
  vector.sort((a, b) => a - b);
  let i = 0,
    m,
    f = length - 1;
  let count = 0;
  while (i <= f) {
    m = Math.trunc((i + f) / 2);
    count++;
    if (key < vector[m]) {
      f = m - 1;
      count += 1;
    } else if (key > vector[m]) {
      i = m + 1;
      count += 2;
    } else {
      return count + 2;
    }
  }
  return count;
}

console.log(key);
results.forEach((r) => console.log(`${r.l} -> ${r.c}`));
