// 位移密码算法挑战
// 下面我们来介绍著名的凯撒密码Caesar cipher，又叫移位密码。

// 移位密码也就是密码中的字母会按照指定的数量来做移位。

// 一个常见的案例就是ROT13密码，字母会移位13个位置。由'A' ↔ 'N', 'B' ↔'O'，以此类推。

// 写一个ROT13函数，实现输入加密字符串，输出解密字符串。

// 所有的字母都是大写，不要转化任何非字母形式的字符(例如：空格，标点符号)，遇到这些特殊字符，就跳过它们。

// 以下链接可以帮助到你:

// String.prototype.charCodeAt()
// String.fromCharCode()

// *************************************

// rot13("SERR PBQR PNZC") 应该解码为 "FREE CODE CAMP"
// rot13("SERR CVMMN!") 应该解码为 "FREE PIZZA!"
// rot13("SERR YBIR?") 应该解码为 "FREE LOVE?"
// rot13("GUR DHVPX OEBJA QBT WHZCRQ BIRE GUR YNML SBK.") 应该解码为 "THE QUICK BROWN DOG JUMPED OVER THE LAZY FOX."

function rot13 (str) { // LBH QVQ VG!
  var char
  var str1 = ''
  for (var i = 0; i < str.length; i++) {
    char = str.charCodeAt(i)
    if (char < 65 || char > 90) {
      str1 += String.fromCharCode(char)
    } else {
      if (char > 77) {
        str1 += String.fromCharCode(char - 13)
      } else {
        str1 += String.fromCharCode(char + 13)
      }
    }
  }
  return str1// String.fromCharCode(char);
}
// Change the inputs below to test
console.log(rot13('SERR PBQR PNZC'))
