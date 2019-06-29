function createPerson (name) {
  var localPerson = {};
  localPerson.name = name;
  return localPerson;
}

var globalPerson = createPerson('Emma');
// 手动解除globalPerson的引用

globalPerson = null;
