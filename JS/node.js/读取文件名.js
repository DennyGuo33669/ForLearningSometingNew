var fs = require('fs');

// const url = 'D:/下载/迅雷下载/日系/';
const url = 'D:/下载/BT Backup/无法下载&贼慢/';

const components = [];
const files = fs.readdirSync(url);
files.forEach(function (item, index) {
//   const stat = fs.lstatSync(url + item);
//   if (stat.isDirectory() === true) {
//     components.push(item);
//   }
  components.push(item);
});

console.log(components);

const str = JSON.stringify(components);

fs.writeFile('./JS/node.js/BT.json', str, function (err) {
  if (err) { res.status(500).send('Server is error...'); }
});
