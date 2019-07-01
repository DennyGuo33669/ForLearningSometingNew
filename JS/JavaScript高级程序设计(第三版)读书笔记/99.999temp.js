var colors = new Array(); // 创建
var count = colors.unshift('red', 'green'); // 推入两项
console.log(count);

count = colors.unshift('black'); // 推入另一项
console.log(count);

var item = colors.pop(); // 取得第一项
console.log(item); // green
console.log(colors.length);
