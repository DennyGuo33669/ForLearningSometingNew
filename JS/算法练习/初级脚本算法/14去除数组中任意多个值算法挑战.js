// 去除数组中任意多个值算法挑战
//  实现一个 destroyer 函数，第一个参数是初始数组，后跟一个或多个参数。从初始数组中删除与这些参数具有相同值的所有元素。

// 当你完成不了挑战的时候，可以点击'求助'。

// 以下链接可以帮助到你:

// Arguments object
// Array.prototype.filter()

// ************************************************

// destroyer([1, 2, 3, 1, 2, 3], 2, 3) 应该返回 [1, 1].
// destroyer([1, 2, 3, 5, 1, 2, 3], 2, 3) 应该返回 [1, 5, 1].
// destroyer([3, 5, 1, 2, 2], 2, 3, 5) 应该返回 [1].
// destroyer([2, 3, 2, 3], 2, 3) 应该返回 [].
// destroyer(["tree", "hamburger", 53], "tree", 53) 应该返回 ["hamburger"].

function destroyer (arr) {
  // Remove all the values
  var a = arguments;
  for (var i = 0; i < a.length; i++) {
    arr = arr.filter(str => str !== a[i]);
  }
  return arr;
}

console.log(destroyer([1, 2, 3, 1, 2, 3], 2, 3));
