// LocateElem(L,e) 按值查找操作.在表L中查找e的元素 返回第一个查找到的元素

#include <iostream>
using namespace std;

int LocateElem(SqList L, ElemType e) {
  int i;
  for (i = 0; i < L.length; i++) {
    if (L.data[i] == e) {
      return i + 1;  //返回顺序表的标号 不是数组的下标
    }
  }
  return 0;  // 查找失败
}

int main() {
  cout << "Hello World!" << endl;

  LocateElem(L, 'e');
  return 0;
}