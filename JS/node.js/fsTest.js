var fs = require('fs');

// const components = [];
// const files = fs.readdirSync('E:/临时porn/无码/未');
// const files = fs.readdirSync('./components');
// files.forEach(function (item, index) {
//   const stat = fs.lstatSync('E:/临时porn/无码/未' + item);
//   if (stat.isDirectory() === true) {
//     components.push(item);
//   }
// });
var readDir = fs.readdirSync('D:\\下载\\BT Backup\\BT种子 Download Later\\迅雷\\', 'utf8');
console.log(`文件数目:${readDir.length}\n文件如下:`);
// console.log(readDir);
readDir.forEach(item => console.log(item));

// console.log(components);
