// 1 2 3
// 4 5 6
const v = { m: [1, 2, 3, 4, 5, 6], row: 2, col: 3 };

function a(p1: number, p2: number) {
  return v.m[p1 * v.col + p2];
}

console.log(a(0, 2)); // 3
// console.log(a(1, 1)); // 5
