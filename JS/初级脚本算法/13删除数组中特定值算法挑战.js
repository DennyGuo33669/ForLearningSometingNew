// 删除数组中特定值算法挑战
// 删除数组中的所有的假值。

// 在JavaScript中，假值有false、null、0、""、undefined 和 NaN。

// 以下链接可以帮助到你:

// Boolean Objects
// Array.prototype.filter()

// ****************************************

// bouncer([7, "ate", "", false, 9]) 应该返回 [7, "ate", 9].
// bouncer(["a", "b", "c"]) 应该返回 ["a", "b", "c"].
// bouncer([false, null, 0, NaN, undefined, ""]) 应该返回 [].
// bouncer([1, null, NaN, 2, undefined]) 应该返回 [1, 2].

function bouncer (arr) {
  // Don't show a false ID to this bouncer.
  return arr.filter(function (val) {
    // return arr.indexOf("false")>0;
    return val
  })
  // return arr;
}

console.log(bouncer([7, 'ate', '', false, 9, undefined]))
