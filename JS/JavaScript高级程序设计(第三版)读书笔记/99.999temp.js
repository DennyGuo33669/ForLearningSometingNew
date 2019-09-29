
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

// var pageWidth = window.innerWidth;
// var pageHeight = window.innerHeight;

// if (typeof pageWidth !== 'number') {
//   if (document.compatMode == 'CSS1Compat') {
//     pageWidth = document.documentElement.clientWidth;
//     pageHeight = document.documentElement.clientHeight;
//   } else {
//     pageWidth = document.body.clientWidth;
//     pageHeight = document.body.clientHeight;
//   }
// }
var app = new Vue({
  el: '#app',
  data: {
    message: 'Hello Vue!'
  }
});

var app = new Vue({
  el: '#app-2',
  data: {
    message: '页面加载于' + new Date().toLocaleString()
  }
});
