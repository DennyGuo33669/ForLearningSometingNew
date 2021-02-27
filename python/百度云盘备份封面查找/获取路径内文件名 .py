import os
import time


def file_name(file_dir):
    for root, dirs, files in os.walk(file_dir):
        # print(root)  # 当前目录路径
        # print(dirs)  # 当前路径下所有子目录
        # print(files)  # 当前路径下所有非目录子文件
        return files


文件名 = file_name(r'D:\视频\porn\日系\有码\_筛选不行 待删除D')
# 文件名 = file_name(os.getcwd())

print()
print()

counter = 0
for i in 文件名:
    counter += 1
    print(i)

print("==========================================")
print(f"文件数:{counter}")

with open(r"D:\文档\表格\有码 不行.txt", "a", encoding='utf-8', errors='ignore') as f:  # 打开文件

    for i in 文件名:
        f.writelines(f'\n{i}')

    # 记录写入日期格式化成2016-03-20 11:45:39形式
    f.writelines('\n==========================================')
    f.writelines('操作日期:')
    f.writelines(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()))
    f.writelines('\n')
    f.writelines('\n')
    f.close()
