// ListDelete(&L,i,&e) 删除操作. 删除表L中第i个位置的元素,并用e返回删除元素的值.

#include <iostream>
using namespace std;

bool ListDelete(SqList &L, int i, ElemType &e) {
  // 判断删除是否合法
  if (i < 1 || i > L.length) {
    return false;
  }

  e = L.data[i - 1];

  for (int j = i; j < L.length; j++) {
    L.data[j - 1] = L.data[j];
  }

  L.length--;

  return true;
}

int main() {
  cout << "Hello World!" << endl;

  ListDelete(L, 3, 'e');
  return 0;
}