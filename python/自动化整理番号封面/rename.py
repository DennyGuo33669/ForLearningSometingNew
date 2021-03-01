
import os
import re
import 清洗数据


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


def file_extension(path):
    return os.path.splitext(path)[1]


msg = file_name(r'D:\python')
file_dict = {"content": [],
             "后缀": [],
             }
for file in msg["files"]:
    for i in file:
        file_dict["content"].append(i)
        file_dict["后缀"].append(file_extension(
            os.path.join(str(msg['root']), i)))  # 文件后缀名


数据 = 清洗数据.match_id(file_dict)
path = "D:\\python"
num = 0
while num < 数据["num"]:
    # print(数据['id'][num])
    # print(file_dict['content'][num])
    # print(file_dict['后缀'][num])
    old_name = os.path.join(path, file_dict['content'][num])
    new_name = os.path.join(path, 数据['id'][num]+" "+file_dict['后缀'][num])
    print(old_name)
    print(new_name)
    print()
    print()
    try:
        os.rename(old_name, new_name)
    except FileNotFoundError:
        print("[WinError 2] 系统找不到指定的文件。")
    num += 1
