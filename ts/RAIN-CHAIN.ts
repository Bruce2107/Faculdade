const heightA = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1];
const heightB = [4, 2, 0, 3, 2, 5];
function trap(height: number[]): number {
  let count = 0;
  let ref = 0;

  function hasBrick(height: number[], index: number, ref: number): boolean {
    const result = Math.max(...height.slice(index)) > ref;
    return !!result;
  }

  function hasBigger(height: number[], index: number, ref: number): boolean {
    const result = Math.max(...height.slice(index)) > ref;
    return !!result;
  }

  for (let i = 0; i < height.length; i++) {
    if (height[i] === 0 && i == 0) continue;
    if (height[i] < ref && i == height.length - 1) continue;

    if (i == 0 || height[i] > ref) {
      ref = height[i];
    }
    const brick = hasBrick(height, i, ref);
    const hill = height[i] < height[i - 1] && hasBigger(height, i, height[i]);
    // console.log(
    //   `${i} ${height[i]} ${brick} ${hill} ${Math.abs(
    //     height[i] - ref
    //   )} ${count}`
    // );
    if (!brick && hill) {
      count += Math.max(0, Math.abs(height[i] - height[i - 1]));
      continue;
    }
    if (!brick && !hill) continue;

    count += Math.max(0, Math.abs(height[i] - ref));
  }
  return count;
}

console.assert(trap(heightA) === 6);
console.assert(trap(heightB) === 9);
// https://leetcode.com/problems/trapping-rain-water/solution/
