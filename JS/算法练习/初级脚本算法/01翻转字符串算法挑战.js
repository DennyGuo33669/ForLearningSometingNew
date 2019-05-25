// 翻转字符串算法挑战
// 实战翻转字符串算法

// 你可以先把字符串转化成数组，再借助数组的reverse方法翻转数组顺序，然后把数组转化成字符串。

// 提示:你的结果必须得是一个字符串

// 如果不懂可以先通过以下链接学习:

// Global String Object
// String.prototype.split()
// Array.prototype.reverse()
// Array.prototype.join()

// ****************************************************

// reverseString("hello") 应该返回一个字符串
// reverseString("hello") 应该返回 "olleh".
// reverseString("Howdy") 应该返回 "ydwoH".
// reverseString("Greetings from Earth") 应该返回 "htraE morf sgniteerG".

function reverseString (str) {
  // var a = str.split('');
  // var b = a.reverse();
  // var c = b.join('');
  return str.split('').reverse().join('');
}

console.log(reverseString('hello'));
