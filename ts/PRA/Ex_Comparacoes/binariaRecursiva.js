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
    let count = 0;
    result.push({
      l: size,
      c: binariaRecursiva(
        key,
        vector.sort((a, b) => a - b),
        0,
        size - 1,
        count
      )[1],
    });
  });
  return result;
})();

function binariaRecursiva(key, vector, init, end, count) {
  let m = (init + end) / 2;
  count++;
  if (init > end) return [-1, count];
  count++;
  if (vector[m] == key) return [m, count];
  else {
    count++;
    if (key < vector[m])
      return binariaRecursiva(key, vector, init, m - 1, count);
    else return binariaRecursiva(key, vector, m + 1, end, count);
  }
}

console.log(key);
results.forEach((r) => console.log(`${r.l} -> ${r.c}`));
