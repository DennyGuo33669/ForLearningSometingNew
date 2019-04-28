// 数组查询算法挑战
// 如果数组第一个字符串元素包含了第二个字符串元素的所有字符，则函数返回true。

// 举例，["hello", "Hello"]应该返回true，因为在忽略大小写的情况下，第二个字符串的所有字符都可以在第一个字符串找到。

// ["hello", "hey"]应该返回false，因为字符串"hello"并不包含字符"y"。

// ["Alien", "line"]应该返回true，因为"line"中所有字符都可以在"Alien"找到。

// 以下链接可以帮助到你:

// String.prototype.indexOf()

// **************************************

// mutation(["hello", "hey"]) 应该返回 false.
// mutation(["hello", "Hello"]) 应该返回 true.
// mutation(["zyxwvutsrqponmlkjihgfedcba", "qrstu"]) 应该返回 true.
// mutation(["Mary", "Army"]) 应该返回 true.
// mutation(["Mary", "Aarmy"]) 应该返回 true.
// mutation(["Alien", "line"]) 应该返回 true.
// mutation(["floor", "for"]) 应该返回 true.
// mutation(["hello", "neo"]) 应该返回 false.

function mutation (arr) {
  var newArr = arr[0].toLowerCase()
  var newArr1 = arr[1].toLowerCase()
  // newArr = arr.indexOf('hey')
  // newArr = arr[0].indexOf("l")
  for (var i = 0; i < newArr1.length; i++) {
    if (newArr.indexOf(newArr1[i]) < 0) {
      return false
    }
  }
  return true
}

console.log(mutation(['hello', 'hey']))
