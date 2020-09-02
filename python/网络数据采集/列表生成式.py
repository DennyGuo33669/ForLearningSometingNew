import os
# print(list(range(1, 101)))


# print([x * x for x in range(1, 11)])
# # [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

# print([x * x for x in range(1, 11) if x % 2 == 0])
# # [4, 16, 36, 64, 100]

# print([m + n for m in 'ABC' for n in 'XYZ'])
# # ['AX', 'AY', 'AZ', 'BX', 'BY', 'BZ', 'CX', 'CY', 'CZ']

# print([item for item in os.listdir('D:\视频')])


# d = {'x': 'A', 'y': 'B', 'z': 'C'}
# for k, v in d.items():
#     print(k, '=', v)
# # x = A
# # y = B
# # z = C

L1 = ['Hello', 'World', 18, 'Apple', None]
L2 = [item.lower() for item in L1 if isinstance(item, str) == True]
# 测试:
print(L2)
if L2 == ['hello', 'world', 'apple']:
    print('测试通过!')
else:
    print('测试失败!')

