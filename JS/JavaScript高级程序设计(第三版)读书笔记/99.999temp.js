var colors = ['red', 'green', 'blue'];
var num = 1 + 5;
console.log(num);
for (var i = 0; i < 10; i++) {
  console.log(i);
}
var removed = colors.splice(0, 1); // 删除第一项
console.log(colors); // "green", "blue"
console.log(removed); // "red"

removed = colors.splice(1, 0, 'yellow', 'orange');
console.log(colors); // "green", "yellow", "orange", "blue"
console.log(removed); // 返回一个空数组

removed = colors.splice(1, 1, 'red', 'purple');
console.log(colors); // "green", "red", "purple", "orange", "blue"
console.log(removed); // "yellow"
