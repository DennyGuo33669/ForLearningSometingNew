// 数字转罗马数字
// 将给定的数字转换成罗马数字。

// 所有返回的 罗马数字 都应该是大写形式。

// 如果你被难住了，记得使用 Read-Search-Ask尝试与他人交流编程思路、但编写你自己的代码。

// 参考资料:

// Array.prototype.splice()
// Array.prototype.indexOf()
// Array.prototype.join()

// *****************************************

// convert(2) 应该返回 "II"。
// convert(3) 应该返回 "III"。
// convert(4) 应该返回 "IV"。
// convert(5) 应该返回 "V"。
// convert(9) 应该返回 "IX"。
// convert(12) 应该返回 "XII"。
// convert(16) 应该返回 "XVI"。
// convert(29) 应该返回 "XXIX"。
// convert(44) 应该返回 "XLIV"。
// convert(45) 应该返回 "XLV"。
// convert(68) 应该返回 "LXVIII"。
// convert(83) 应该返回 "LXXXIII"。
// convert(97) 应该返回 "XCVII"。
// convert(99) 应该返回 "XCIX"。
// convert(500) 应该返回 "D"。
// convert(501) 应该返回 "DI"。
// convert(649) 应该返回 "DCXLIX"。
// convert(798) 应该返回 "DCCXCVIII"。
// convert(891) 应该返回 "DCCCXCI"。
// convert(1000) 应该返回 "M"。
// convert(1004) 应该返回 "MIV"。
// convert(1006) 应该返回 "MVI"。
// convert(1023) 应该返回 "MXXIII"。
// convert(2014) 应该返回 "MMXIV"。
// convert(3999) 应该返回 "MMMCMXCIX"。

function convert (num) {
  var nums = [1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1];
  var romans = ['m', 'cm', 'd', 'cd', 'c', 'xc', 'l', 'xl', 'x', 'ix', 'v', 'iv', 'i'];
  var str = '';
  nums.forEach((item, index) => {
    while (num >= item) {
      str += romans[index];
      num -= item;
    }
  });

  return str.toUpperCase();
}

console.log(convert(36));
