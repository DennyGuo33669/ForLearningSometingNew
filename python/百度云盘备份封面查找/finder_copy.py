
r'[a-zA-Z0-9]+-[a-zA-Z0-9]+\s|[a-zA-Z0-9]+_[a-zA-Z0-9]+\s|[0-9]{6}\s|[a-z][0-9]{4}'
from pathlib import Path
import glob
import re
import shutil

file_list = [r'D:\Pictures\porn\封面\Censored Cover',
             r'D:\Pictures\porn\封面\Censored Cover Exclusion',
             r'D:\Pictures\porn\封面\Uncensored Cover',
             r'D:\Pictures\porn\封面\Uncensored Cover Exclusion',
             ]

matches = [0, 0, 0, 0]


def 解析番号(url):
    # 正则匹配番号
    番号 = re.search(
        # r'[a-zA-Z0-9]+-[a-zA-Z0-9]+\s|[a-zA-Z0-9]+_[a-zA-Z0-9]+\s|[0-9]{6}\s|[a-z][0-9]{4}',
        r'[a-zA-Z0-9]+-[0-9]+',
        url.name).group()
    return 番号


def 判断路径(路径):
    if (路径 == file_list[0]):
        matches[0] += 1
    if (路径 == file_list[1]):
        matches[1] += 1
    if (路径 == file_list[2]):
        matches[2] += 1
    if (路径 == file_list[3]):
        matches[3] += 1


def move_file(file_name, 目标文件夹, 番号):
    try:
        shutil.move(file_name, 目标文件夹)
    except shutil.Error:
        # 对已存在的文件进行处理 移动至指定文件夹
        print(
            f'{番号}已存在******************转移至桌面"已存在的封面"')
        shutil.move(file_name, r'C:\Users\Denny\Desktop\已存在的封面')


def 匹配(查找路径):

    for item in Path(查找路径).iterdir():

        # 所有路径
        for i in file_list:
            for p in Path(i).iterdir():
                番号 = 解析番号(item)
                if(番号 in p.name):
                    # 输出信息
                    print()
                    print(f"发现目标: {p.name}  ")
                    print(f"所在路径: {i}")
                    print()

                    # 判断匹配路径
                    判断路径(路径=i)

                    # 移动文件
                    move_file(file_name=p,
                              番号=番号,
                              目标文件夹=r'D:\Pictures\porn\封面\HadBeenBackup')

    print(matches[2])


# 匹配(r'D:\视频\H265\porn\Japanese\Censored\[done]\_百度云上传')
匹配(r'D:\视频\porn\日系\有码\百度云上传')
