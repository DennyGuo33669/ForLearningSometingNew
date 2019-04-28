// 计算所提供整数的阶乘。

// 如果使用字母n代表一个整数，则阶乘是所有小于或等于n的整数的乘积。

// 阶乘通常简写成 n!

// 例如: 5! = 1 * 2 * 3 * 4 * 5 = 120

// [参考]教程链接:

// Arithmetic Operators

// ********************************

// factorialize(5) 应该返回一个数字
// factorialize(5) 应该返回 120.
// factorialize(10) 应该返回 3628800.
// factorialize(20) 应该返回 2432902008176640000.
// factorialize(0) 应该返回 1.

function factorialize (num) {
  var sum = 1
  for (var i = 1; i <= num; i++) {
    sum *= i
  }
  return sum
}
console.log(factorialize(5))
