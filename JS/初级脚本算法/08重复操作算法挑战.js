// 重复操作算法挑战
// 循环拼接一个指定的字符串 num次，如果num是一个负数,则返回一个空字符串。

// 以下链接可以帮助到你:

// Global String Object

// ********************************

// repeat("*", 3) 应该返回 "***".
// repeat("abc", 3) 应该返回 "abcabcabc".
// repeat("abc", 4) 应该返回 "abcabcabcabc".
// repeat("abc", 1) 应该返回 "abc".
// repeat("*", 8) 应该返回 "********".
// repeat("abc", -2) 应该返回 "".

function repeat (str, num) {
  // repeat after me
  if (num < 0) {
    return ''
  } else {
    return str.repeat(num)
  }
}

console.log(repeat('abc', 3))
