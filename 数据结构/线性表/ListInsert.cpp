// ListInsert(&ListInsert,i,e) 插入操作. 在表L中的第i个位置上插入指定元素e(前插)
#include <iostream>
using namespace std;

bool ListInsert(SqList &L, int i, ElemType e) {
  
  // 判断插入位置是否正确
  if (i < 1 || i > L.length + 1) {
    return false;
  }

  //判断顺序表是否已满
  if (L.length >= MaxSize) {
    return false;
  }

  //将其余元素后移
  for (int j = L.length; j >= i; j--) {
    L.data[j] = L.data[j - 1];
  }

  //插入元素
  L.data[i - 1] = e;
  L.length++;

  return true;
}

int main() {
  cout << "Hello World!" << endl;
  return 0;
}