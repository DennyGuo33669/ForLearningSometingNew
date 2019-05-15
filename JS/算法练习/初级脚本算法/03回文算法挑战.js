// 回文算法挑战
// 如果给定的字符串是回文，返回true，反之，返回false。

// palindrome(回文)是指一个字符串忽略标点符号、大小写和空格，正着读和反着读一模一样。

// 注意:您需要删除字符串多余的标点符号和空格，然后把字符串转化成小写来验证此字符串是不是回文。

// 函数参数的值可以为"racecar"，"RaceCar"和"race CAR"。

// 您可能需要用到的链接:

// String.prototype.replace()
// String.prototype.toLowerCase()

// *****************************************************

// palindrome("eye") 应该返回一个布尔值
// palindrome("eye") 应该返回 true.
// palindrome("race car") 应该返回 true.
// palindrome("not a palindrome") 应该返回 false.
// palindrome("A man, a plan, a canal. Panama") 应该返回 true.
// palindrome("never odd or even") 应该返回 true.
// palindrome("nope") 应该返回 false.
// palindrome("almostomla") 应该返回 false.
// palindrome("My age is 0, 0 si ega ym.") 应该返回 true.
// palindrome("1 eye for of 1 eye.") 应该返回 false.
// palindrome("0_0 (: /-\ :) 0-0") 应该返回 true.

function palindrome (str) {
  // Good luck!
  var re = /[^a-z0-9]/g
  var a = str.toLowerCase().replace(re, '').split('').reverse().join('')
  var b = str.toLowerCase().replace(re, '').split('').join('')
  if (a === b) {
    return true
  } else {
    return false
  }
}

console.log(palindrome('?>,eye123,,,??'))
