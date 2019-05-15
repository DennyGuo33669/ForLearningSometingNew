// 数组截断算法挑战
//    返回一个数组被截断n个元素后还剩余的元素，从索引0开始截断。

// 以下链接可以帮助到你:

// Array.prototype.slice()
// Array.prototype.splice()

// ********************************

// slasher([1, 2, 3], 2) 应该返回 [3].
// slasher([1, 2, 3], 0) 应该返回 [1, 2, 3].
// slasher([1, 2, 3], 9) 应该返回 [].
// slasher([1, 2, 3], 4) 应该返回 [].
// slasher(["burgers", "fries", "shake"], 1) 应该返回 ["fries", "shake"].
// slasher([1, 2, "chicken", 3, "potatoes", "cheese", 4], 5) 应该返回 ["cheese", 4].

function slasher (arr, howMany) {
  // it doesn't always pay to be first
  var newArr = arr.slice(howMany)
  // newArr = arr.splice(1,0,newArr);
  return newArr
}

console.log(slasher([1, 2, 3], 2))
