
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

(function () {
  var name = '';
  Person = function (value) {
    name = value;
  };

  Person.prototype.getName = function () {
    return name;
  };

  Person.prototype.setName = function (value) {
    name = value;
  };

  var person1 = new Person('Emma');
  console.log(person1.getName()); // Emma
  person1.setName('Jam');
  console.log(person1.getName()); // Jam

  var person2 = new Person('CCC');
  console.log(person1.getName()); // CCC
  console.log(person2.getName()); // CCC
})();
