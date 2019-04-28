// 确认末尾字符算法挑战
// 检查一个字符串(str)是否以指定的字符串(target)结尾。

// 如果是，返回true;如果不是，返回false。

// 这个挑战可以通过在ES2015中引入的.endsWith()方法来解决。但是出于这个挑战的目的，我们希望您使用JavaScript子串方法之一。

// *************************************

// confirmEnding("Bastian", "n") 应该返回 true.
// confirmEnding("Connor", "n") 应该返回 false.
// confirmEnding("Walking on water and developing software from a specification are easy if both are frozen", "specification") 应该返回 false.
// confirmEnding("He has to give me a new name", "name") 应该返回 true.
// confirmEnding("He has to give me a new name", "me") 应该返回 true.
// confirmEnding("He has to give me a new name", "na") 应该返回 false.
// confirmEnding("If you want to save our world, you must hurry. We dont know how much longer we can withstand the nothing", "mountain") 应该返回 false.

function confirmEnding (str, target) {
  // "Never give up and good luck will find you."
  // -- Falcor
  /*  var a = str.split(' ');
      if(a.length == 1){
          if(a[0][a[0].length-1]==target) {
              return true
          }  else {
              return false
          }
      }else{
          //for(i = 0;i<a.length;i++){
              if(a[a.length-1]==target) {
              return true
          }  else {
              return false
          }

          //}
      }

  */
  // var s = /.*"+target+"$/;
  // var s=eval("/.*"+target+"$/");
  var re = new RegExp('.*' + target + '$')
  return re.test(str)
}

console.log(confirmEnding('Bastian', 'n'))
