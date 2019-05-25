// 字符串截取算法挑战
//   如果字符串的长度比给定的参数num长，则把多余的部分用...来表示。

// 切记，插入到字符串尾部的三个点号也会计入字符串的长度。

// 然而，如果指定的参数num小于或等于3，则添加的三个点号不会计入字符串的长度。

// 以下链接可以帮助你:

// String.prototype.slice()

// ********************************

// truncate("A-tisket a-tasket A green and yellow basket", 11) 应该返回 "A-tisket...".
// truncate("Peter Piper picked a peck of pickled peppers", 14) 应该返回 "Peter Piper...".
// truncate("A-tisket a-tasket A green and yellow basket", "A-tisket a-tasket A green and yellow basket".length) 应该返回 "A-tisket a-tasket A green and yellow basket".
// truncate("A-tisket a-tasket A green and yellow basket", "A-tisket a-tasket A green and yellow basket".length + 2) 应该返回 "A-tisket a-tasket A green and yellow basket".
// truncate("A-", 1) 应该返回 "A...".
// truncate("Absolutely Longer", 2) 应该返回 "Ab...".

function truncate (str, num) {
  // Clear out that junk in your trunk
  var s = '';
  if (str.length > num) {
    if (num <= 3) {
      s = str.slice(0, num) + '...';
    } else {
      s = str.slice(0, num - 3) + '...';
    }
  } else {
    s = str;
  }

  return s;
}

console.log(truncate('A-tisket a-tasket A green and yellow basket', 11));
