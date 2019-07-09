function createComparisonFunction (propertyName) {
  return function (object1, object2) {
    var value1 = object1[propertyName];
    var value2 = object2[propertyName];

    if (value1 < value2) {
      return -1;
    } else if (value1 > value2) {
      return 1;
    } else {
      return 0;
    }
  };
}

var data = [{ name: 'Jam', age: 28 }, { name: 'Emma', age: 29 }];

data.sort(createComparisonFunction('name'));
console.log(data[0].name); // "Emma"

data.sort(createComparisonFunction('age'));
console.log(data[0].name); // Jam
