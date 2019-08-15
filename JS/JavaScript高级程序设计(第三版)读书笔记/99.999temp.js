
function createComparisonFunction (propertyName) {
  return function (obj1, obj2) {
    var value1 = obj1[ propertyName];
    var value2 = obj2[propertyName];

    if (value1 < value2) {
      return -1;
    } else if (value1 > value2) {
      return 1;
    } else {
      return 0;
    }
  };
}

// 创建函数
var compareNames = createComparisonFunction('name');

// 调用函数
var result = compareNames({ name: 'Emma' }, { name: 'Jam' });

// 解除对匿名函数的引用(以便释放内存)
compareNames = null;

console.log(result);
