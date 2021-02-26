
# r'[a-zA-Z0-9]+-[a-zA-Z0-9]+\s|[a-zA-Z0-9]+_[a-zA-Z0-9]+\s|[0-9]{6}\s|[a-z][0-9]{4}'


import os


def file_name(file_dir):
    for root, dirs, files in os.walk(file_dir):
        # print(root)  # 当前目录路径
        # print(dirs)  # 当前路径下所有子目录
        # print(files)  # 当前路径下所有非目录子文件
        return files


# 文件名 = file_name(r'D:\视频\porn\日系\有码\_筛选不行 待删除D')
文件名 = file_name(os.getcwd())

counter = 0
for i in 文件名:
    counter += 1
    print(i)

print("==========================================")
print(f"文件数:{counter}")
