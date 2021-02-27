import os
import re
import shutil

封面路径 = [r'D:\Pictures\porn\封面\Censored Cover',
        r'D:\Pictures\porn\封面\Censored Cover Exclusion',
        r'D:\Pictures\porn\封面\Uncensored Cover',
        r'D:\Pictures\porn\封面\Uncensored Cover Exclusion',
        r'D:\Pictures\porn\封面\HadBeenBackup',
        ]


def file_name(file_dir):
    # 获取文件名
    for root, dirs, files in os.walk(file_dir):
        # print(root)  # 当前目录路径
        # print(dirs)  # 当前路径下所有子目录
        # print(files)  # 当前路径下所有非目录子文件
        return files


def 番号匹配(files):
    # 通过获取的文件名进行正则匹配 得到番号
    match_data = {
        '成功': 0,
        '失败': 0,
        '失败列表': [],
        '番号列表': []
    }
    files_num = 0
    try:
        for data in files:
            files_num += 1
            try:
                番号 = re.search(r'[a-zA-Z0-9]+-[0-9]+', data).group()
                # 番号 = re.search(
                #     r'[a-zA-Z0-9]+-[a-zA-Z0-9]+\s|[a-zA-Z0-9]+_[a-zA-Z0-9]+\s|[0-9]{6}\s|[a-z][0-9]{4}', data).group()
                match_data['成功'] += 1
                match_data["番号列表"].append(番号)
                # print(番号)
            except AttributeError:
                match_data["失败"] += 1
                match_data["失败列表"].append(data)

        if match_data['成功']+match_data["失败"] == files_num:
            # 数据校验
            # print("数据匹配成功√")
            return match_data

        else:
            print("数据匹配失败×")
            print("成功 + 失败 ≠ 文件列表数量")
    except:
        # print(data)
        pass


# files = file_name(r'D:\视频\porn\日系\有码\百度云上传\测试')

# match_data = 番号匹配(files)


def move_file(封面路径):
    # 获取文件名
    move_file_data = {
        "已存在": [],
        "moved_list": [],
        "移动": 0
    }
    for file_dir in 封面路径:
        for root, dirs, files in os.walk(file_dir):
            # print(root)  # 当前目录路径
            # print(dirs)  # 当前路径下所有子目录
            # print(files)  # 当前路径下所有非目录子文件
            for 封面_pic in files:
                for 番号 in match_data['番号列表']:
                    if 番号 in 封面_pic:
                        if file_dir == r'D:\Pictures\porn\封面\HadBeenBackup':
                            # print()
                            # print(f"警告!!!:{封面_pic}")
                            # print(f"已存在于{file_dir}")
                            # print()
                            move_file_data["已存在"].append(封面_pic)

                        else:
                            print()
                            print(f"发现目标:{封面_pic}")
                            print(f"文件所在位置:{root}")
                            src = os.path.join(root, 封面_pic)
                            file_to = r'D:\Pictures\porn\封面\HadBeenBackup'
                            try:
                                shutil.move(src, file_to)
                                move_file_data["移动"] += 1
                                move_file_data["moved_list"].append(封面_pic)
                                # print(f"已移动至{file_to}")
                            except shutil.Error:
                                # os.remove(os.path.join(
                                #     r'C:\Users\Denny\Desktop\已存在的封面', 封面_pic))
                                shutil.move(
                                    src, r'C:\Users\Denny\Desktop\已存在的封面')

    return move_file_data


# move_file_data = move_file(封面路径)


def show(data):
    # 数据展示
    """
        data= {
            '成功': 0,
            '失败': 0,
            '失败列表': [],
            '番号列表': []
        }

        move_file_data = {
        "已存在": [],
        "移动": 0
        }

        """
    print("==================匹配数据========================")

    # for i in data:
    #     print(i, data.get(i))
    print(f"文件总数{data['成功']+data['失败']} 成功{data['成功']} 失败{data['失败']}")
    print()

    if data['失败列表'] != []:
        print()
        print("==================失败列表========================")
        for i in data['失败列表']:
            print(i)

    # if data['番号列表'] != []:
    #     print()
    #     print("==================番号列表========================")
    #     for i in data['番号列表']:
    #         print(i)

    if move_file_data != '':
        print()
        print("==================移动信息========================")
        # print(move_file_data)
        print(move_file_data['移动'])


files = file_name(r'D:\视频\porn\日系\有码\百度云上传')

match_data = 番号匹配(files)

move_file_data = move_file(封面路径)

show(match_data)
