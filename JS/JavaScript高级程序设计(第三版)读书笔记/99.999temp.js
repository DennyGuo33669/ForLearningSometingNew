
var person = {
  name: 'Emma',
  age: 17,
  job: 'student',

  sayName: function () {
    console.log(this.name);
  }
};

person.sayName();
