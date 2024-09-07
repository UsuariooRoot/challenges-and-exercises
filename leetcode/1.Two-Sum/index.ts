function twoSum(nums: number[], target: number): number[] {
  const numIndices = new Map<number, number>();

  for (let i = 0; i < nums.length; i++) {
      const complement = target - nums[i];
      
      if (numIndices.has(complement)) {
          return [numIndices.get(complement)!, i];
      }
      
      numIndices.set(nums[i], i);
  }
  
  return [];
}

function twoSum2(nums: number[], target: number): number[] {
  let idxs: Array<number> = [];
  
  for (let i = 0; i < nums.length; i++) {
      for (let j = i + 1; j < nums.length; j++) {
          let sum = nums[i] + nums[j];
          if (sum === target) {
              idxs.push(i, j);
              return idxs;
          }
      }
  }
  return [];
};

console.log()