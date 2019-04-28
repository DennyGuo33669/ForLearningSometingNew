// 找出数组间差异算法挑战

// 比较两个数组，然后返回一个新数组，该数组的元素为两个给定数组中所有独有的数组元素。换言之，返回两个数组的差异。

// 如果你被难住了，记得使用 Read-Search-Ask尝试与他人交流编程思路、编写你自己的代码。

// 参考提示：

//     Comparison Operators
//     Array.prototype.slice()
//     Array.prototype.filter()
//     Array.prototype.indexOf()
//     Array.prototype.concat()


function diff(arr1, arr2) {

    var newArr1 = arr1.filter((a) => arr2.indexOf(a) === -1);
    var newArr2 = arr2.filter((a) => arr1.indexOf(a) === -1);


    return newArr1.concat(newArr2);



}
// eslint-disable-next-line no-console
console.log(diff(["andesite", "grass", "dirt", "pink wool", "dead shrub"], ["diorite", "andesite", "grass", "dirt", "dead shrub"]));