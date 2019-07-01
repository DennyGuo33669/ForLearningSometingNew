var colors = new Array(); // 创建
var count = colors.push('red', 'green'); // 推入两项
console.log(count);

count = colors.push('black'); // 推入另一项
console.log(count);

var item = colors.shift(); // 取得第一项
console.log(item); // red
console.log(colors.length);
