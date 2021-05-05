
import os
import re
import 清洗数据
import 下载封面


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


def 格式化本地(url):
    msg = file_name(url)

    file_dict = {"content": [],
                 "后缀": [],
                 }

    for file in msg["files"]:
        for i in file:
            file_dict["content"].append(i)
            file_dict["后缀"].append(file_extension(
                os.path.join(str(msg['root']), i)))  # 文件后缀名

    数据 = 清洗数据.match_id(file_dict)
    path = url
    num = 0
    while num < 数据["num"]:
        # print(数据)
        # print(数据['id'][num])
        # print(file_dict['content'][num])
        # print(数据['has_chinese'])
        # print(file_dict['后缀'][num])
        old_name = os.path.join(path, file_dict['content'][num])

        番号数据 = 下载封面.番号搜索(数据['id'][num])
        # print(番号数据)
        标题 = re.sub("[/\:*\"<>|?]+", " ", 番号数据['标题'])
        if 数据['id'][num] in 数据['has_chinese']:
            # print(数据['id'][num]+"有中文")
            if 'favorite' in file_dict['content'][num]:
                new_name = os.path.join(
                    path, 数据['id'][num]+"-C "+标题+'[ favorite ]'+file_dict['后缀'][num])
            else:
                new_name = os.path.join(
                    path, 数据['id'][num]+"-C "+标题+file_dict['后缀'][num])
        else:
            try:
                new_name = os.path.join(
                    path, 数据['id'][num]+" "+标题+file_dict['后缀'][num])

                if 'favorite' in file_dict['content'][num]:
                    new_name = os.path.join(
                        path, 数据['id'][num]+" "+标题+'[ favorite ]'+file_dict['后缀'][num])
                else:
                    new_name = os.path.join(
                        path, 数据['id'][num]+" "+标题+file_dict['后缀'][num])
            except TypeError:
                with open(os.path.join(url, '下载失败.txt'), "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
                    a.writelines(f"下载失败:{数据['id'][num]}\n")
                    a.close()
        try:
            os.rename(old_name, new_name)
        except FileNotFoundError:
            print("[WinError 2] 系统找不到指定的文件。")
        except FileExistsError:
            new_name = os.path.join(
                path, 数据['id'][num]+" "+标题+file_dict['后缀'][num])
            os.rename(old_name, new_name)


        num += 1
        print(f'格式化前:{old_name}')
        print(f'格式化后:{new_name}')
        print(f'进度{num}/{数据["num"]}')
        print()
        print()


# 格式化本地(r'D:\python')
