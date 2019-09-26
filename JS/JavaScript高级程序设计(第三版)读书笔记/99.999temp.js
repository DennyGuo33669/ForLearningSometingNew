
// // function createComparisonFunction (propertyName) {
// //   return function (obj1, obj2) {
// //     var value1 = obj1[propertyName];
// //     var value2 = obj2[propertyName];
// //     var value3 = JSON.stringify(arguments);
// //     // if (value1 < value2) {
// //     //   return -1;
// //     // } else if (value1 > value2) {
// //     //   return 1;
// //     // } else {
// //     //   return 0;
// //     // }
// //     console.log(`value1:${value1},value2:${value2},参数:${value3}`);
// //   };
// // }

// // var data = [{ name: 'a' }, { name: 'b' }, { name: 'c' }];

// // data.sort(createComparisonFunction('name'));

// for (var i = 14; i < 100; i++) {
//   console.log(`[^${i + 1}]:`);
// }

// 将窗口移动到屏幕左上角
window.moveTo(0, 0);

// 将窗口向下移动100像素
window.moveBy(0, 100);

// 将窗口移动到(200,300)
window.moveTo(200, 300);

// 将窗口向左移动50像素
window.moveBy(-50, 0);
