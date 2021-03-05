import os

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
