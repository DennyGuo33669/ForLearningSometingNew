
// // // // // function createComparisonFunction (propertyName) {
// // // // //   return function (obj1, obj2) {
// // // // //     var value1 = obj1[propertyName];
// // // // //     var value2 = obj2[propertyName];
// // // // //     var value3 = JSON.stringify(arguments);
// // // // //     // if (value1 < value2) {
// // // // //     //   return -1;
// // // // //     // } else if (value1 > value2) {
// // // // //     //   return 1;
// // // // //     // } else {
// // // // //     //   return 0;
// // // // //     // }
// // // // //     console.log(`value1:${value1},value2:${value2},参数:${value3}`);
// // // // //   };
// // // // // }

// // // // // var data = [{ name: 'a' }, { name: 'b' }, { name: 'c' }];

// // // // // data.sort(createComparisonFunction('name'));

// // // // for (var i = 14; i < 100; i++) {
// // // //   console.log(`[^${i + 1}]:`);
// // // // }

// // // // var pageWidth = window.innerWidth;
// // // // var pageHeight = window.innerHeight;

// // // // if (typeof pageWidth !== 'number') {
// // // //   if (document.compatMode == 'CSS1Compat') {
// // // //     pageWidth = document.documentElement.clientWidth;
// // // //     pageHeight = document.documentElement.clientHeight;
// // // //   } else {
// // // //     pageWidth = document.body.clientWidth;
// // // //     pageHeight = document.body.clientHeight;
// // // //   }
// // // // }
// // // var app = new Vue({
// // //   el: '#app',
// // //   data: {
// // //     message: 'Hello Vue!'
// // //   }
// // // });

// // // var app = new Vue({
// // //   el: '#app-2',
// // //   data: {
// // //     message: '页面加载于' + new Date().toLocaleString()
// // //   }
// // // });

// // var data = {
// //   use: false,
// //   url: 'https://www.bilibili.com',
// //   msg: '坎坎坷坷'
// // };
// // var vm = new Vue({
// //   el: '#example',
// //   data: data,
// //   methods: {
// //     reversedMsg: function () {
// //       this.msg = this.msg.split('').reverse().join('');
// //     }
// //   },
// //   filters: {
// //     capitalize: function (val) {
// //       if (!val) {
// //         return '';
// //       }
// //       val = val.toString();
// //       return val.charAt(0).toUpperCase() + val.slice(1);
// //     }
// //   }
// // });
// ;

// // // 调整大小
// // baiduWin.resizeTo(500, 500);

// // // 移动位置
// // baiduWin.moveTo(100, 100);

// // // 关闭新打开的窗口
// // baiduWin.close();

// // baiduWin.close();

// var blocked = false;

// try {
//   var baiduWin = window.open('http://www.baidu.com', '_blank');

//   if (baiduWin == null) {
//     blocked = true;
//   }
// } catch (ex) {
//   blocked = true;
// }

// if (blocked) {
//   console.log('The popup was blocked!');
// }

// // 设置超时调用
// var timeoutId = setTimeout(() => {
//   alert('hell!');
// }, 1000);

// // 取消
// clearTimeout(timeoutId);

// 显示 "打印" 对话框
window.print();

// 显示 "查找" 对话框
window.find();
