// 设置首字母大写算法挑战
// 返回一个字符串,确保字符串的每个单词首字母都大写，其余部分小写。

// 像'the'和'of'这样的连接符同理。

// 你可能需要使用到以下链接:

// String.prototype.split()

// **********************************
// titleCase("I'm a little tea pot") 应该返回一个字符串
// titleCase("I'm a little tea pot") 应该返回 "I'm A Little Tea Pot".
// titleCase("sHoRt AnD sToUt") 应该返回 "Short And Stout".
// titleCase("HERE IS MY HANDLE HERE IS MY SPOUT") 应该返回 "Here Is My Handle Here Is My Spout".

function titleCase (str) {
  var a = str.split(' ');
  // var re = /[a-z]/;
  for (var i = 0; i < a.length; i++) {
    a[i] = a[i][0].toUpperCase() + a[i].slice(1).toLowerCase();
  }
  return a.join(' ');
}

console.log(titleCase("I'm a little tea pot"));
