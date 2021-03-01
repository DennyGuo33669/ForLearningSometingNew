import os
import time


def file_name(file_dir):
    msg = {
        "root": [],
        "dirs": [],
        "files": [],

    }
    for root, dirs, files in os.walk(file_dir):
        # print(root)  # 当前目录路径
        # print(dirs)  # 当前路径下所有子目录
        # print(files)  # 当前路径下所有非目录子文件
        msg["root"] = root
        msg["dirs"].append(dirs)
        msg["files"].append(files)
        return msg


url = '有码 不行.txt'

# 文件名 = file_name(r'D:\视频\porn\日系\有码\_筛选不行 待删除D')
# 文件名 = file_name(os.getcwd())


def 写入(读取, name):
    counter = 0
    with open(os.path.join(r"D:\Pictures\porn\封面", name), "a", encoding='utf-8', errors='ignore') as f:  # 打开文件
        for i in file_name(读取)['dirs']:
            for dir in i:
                f.writelines(f'\n{dir}')
                counter += 1
        for i in file_name(读取)['files']:
            for dir in i:
                f.writelines(f'\n{dir}')
                counter += 1

        # 记录写入日期格式化成2016-03-20 11:45:39形式
        f.writelines('\n==========================================')
        f.writelines('操作日期:')
        f.writelines(
            f'{time.strftime("%Y-%m-%d %H:%M:%S", time.localtime())}  写入{counter}条')
        f.writelines('\n')
        f.writelines('\n')
        print(f"写入{counter}条")
        f.close()
    return counter




# print(file_name(f"D:\视频\porn\日系\有码\_筛选不行 待删除D"))
