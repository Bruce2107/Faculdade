function doisFors(n: Array<string>): string {
  let count = 1;
  let result = '';
  one: for (let i = 0; i < n.length; i++) {
    for (let j = i + 1; j < n.length; j++) {
      if (n[i] == n[j]) {
        count++;
      } else {
        result = result.concat(`${count}${n[i]}`);
        count = 1;
        i++;
        continue one;
      }
    }
  }
  result = result.concat(`${count}${n[n.length - 1]}`);

  return result;
}

function umFor(n: Array<string>): string {
  let count = 1;
  let result = '';
  for (let i = 1; i < n.length; i++) {
    if (n[i] == n[i - 1]) {
      count++;
    } else {
      result = result.concat(`${count}${n[i - 1]}`);
      count = 1;
      continue
    }
  }
  result = result.concat(`${count}${n[n.length - 1]}`);

  return result;
}

console.time('Dois');
console.log(doisFors('2231'.split('')));
console.log(doisFors('1'.split('')));
console.log(doisFors('1134234'.split('')));
console.timeEnd('Dois');

console.time('Um');
console.log(umFor('2231'.split('')));
console.log(umFor('1'.split('')));
console.log(umFor('1134234'.split('')));
console.timeEnd('Um');
