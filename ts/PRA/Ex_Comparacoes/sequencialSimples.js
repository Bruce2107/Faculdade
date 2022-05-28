// melhor caso -> Primeiro item
// caso médio -> qualquer outra posição
// pior caso -> ultimo item ou nao encontrado

function generateVector(length) {
  return Array.from({ length }, (v, k) => Math.floor(Math.random() * 100));
}
const sizes = [10, 100, 1000, 10000, 100000];
const key = Math.floor(Math.random() * 100);

const results = (() => {
  const result = [];
  sizes.forEach((size) => {
    const vector = generateVector(size);
    result.push({ l: size, c: sequencial(key, vector, size) });
  });
  return result;
})();

function sequencial(key, vector, length) {
  let count = 0;
  for (let i = 0; i < length; i++) {
    count += 2;
    if (vector[i] == key) return count;
  }
  return count;
}

console.log(key);
results.forEach((r) => console.log(`${r.l} -> ${r.c}`));
