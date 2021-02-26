import re

# with open(r"python\百度云盘备份封面查找\已上传.txt", "r", encoding='utf-8', errors='ignore') as f:  # 打开文件
with open(r"D:\文档\表格\有码 不行.txt", "r", encoding='utf-8', errors='ignore') as f:  # 打开文件
    data = f.readlines()  # 读取文件


# for i in data:
#     result = re.search(r'[a-zA-Z0-9]*-[0-9]*', i)
#     print(result.group())
# if result != None:
#     print(result.group())
# else:
#     print('None')

for i in data:
    result = re.search(r'[a-zA-Z0-9]*-[0-9]*', i).group()
    print(result)

# for i in data:
#     print(i)
