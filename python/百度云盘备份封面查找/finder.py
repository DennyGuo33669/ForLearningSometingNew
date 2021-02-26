from pathlib import Path
import glob
import re
import shutil


# 查找列表
查找列表 = [r'D:\Pictures\porn\封面\Censored Cover',
        r'D:\Pictures\porn\封面\Censored Cover Exclusion',
        r'D:\Pictures\porn\封面\Uncensored Cover',
        r'D:\Pictures\porn\封面\Uncensored Cover Exclusion',
        ]

# 目标文件夹
path_百度云已备份 = r'D:\Pictures\porn\封面\HadBeenBackup'

# 查询前文件个数
前_有码行_num = len(glob.glob(查找列表[0]+'\*'))
前_有码不行_num = len(glob.glob(查找列表[1]+'\*'))
前_无码行_num = len(glob.glob(查找列表[2]+'\*'))
前_无码不行_num = len(glob.glob(查找列表[3]+'\*'))
前_百度云已备份_num = len(glob.glob(r'D:\Pictures\porn\封面\HadBeenBackup\*'))
file_num = 前_有码行_num + 前_有码不行_num + 前_无码行_num + 前_无码不行_num + 前_百度云已备份_num

# 使用glob库
# for i in glob.glob(查找列表[0]+'\*'):
#     print(re.search(r'[a-zA-Z]*-[0-9]*', i).group())

# 单纯匹配


# def finder(番号, 查找列表):
#     # 目标文件夹

#     # matched_有码行 = 0
#     # matched_有码不行 = 0
#     # matched_无码行 = 0
#     # matched_无码不行 = 0
#     matches = [0, 0, 0, 0]
#     for i in 查找列表:
#         path = Path(i)
#         for p in path.iterdir():
#             if(番号 in p.name):
#                 print()
#                 print("============================================================")
#                 print(f"发现目标: {p.name} ")
#                 print(f"所在路径: {i}")
#                 if (i == 查找列表[0]):
#                     matches[0] += 1
#                 if (i == 查找列表[1]):
#                     matches[1] += 1
#                 if (i == 查找列表[2]):
#                     matches[2] += 1
#                 if (i == 查找列表[3]):
#                     matches[3] += 1
#                     print(f'匹配{matched_无码行}')
#                 print("============================================================")
#                 print()

#                 return 番号

#     print(f'未发现:{番号}')
#     return 番号

# # 匹配并移动
# def finder_and_move(番号, 查找列表):

#     for i in 查找列表:
#         path = Path(i)
#         for p in path.iterdir():
#             if(番号 in p.name):
#                 print()
#                 print("============================================================")
#                 print(f"发现目标: {p.name} ")
#                 print(f"所在路径: {i}")
#                 try:
#                     shutil.move(p, path_百度云已备份)
#                 except shutil.Error:
#                     # 对已存在的文件进行处理 移动至指定文件夹
#                     print(
#                         f'{番号}文件已存在******************转移至桌面"已存在的封面"')
#                     shutil.move(p, r'C:\Users\Denny\Desktop\已存在的封面')
#                 print("============================================================")
#                 print()
#                 return 番号

#     print(f'未发现:{番号}')
#     return 番号


# 上传列表
上传列表 = r'D:\Pictures\porn\封面\Uncensored Cover'


# for item in Path(上传列表).iterdir():
#     # 正则匹配番号
#     番号 = re.search(
#         r'[a-zA-Z0-9]+-[a-zA-Z0-9]+\s|[a-zA-Z0-9]+_[a-zA-Z0-9]+\s|[0-9]{6}\s|[a-z][0-9]{4}',
#         item.name).group()
#     # print(番号)
#     finder(番号=番号, 查找列表=查找列表)
#     # finder_and_move(番号=番号, 查找列表=查找列表)


# 查询后文件个数
后_有码行_num = len(glob.glob(查找列表[0]+'\*'))
后_有码不行_num = len(glob.glob(查找列表[1]+'\*'))
后_无码行_num = len(glob.glob(查找列表[2]+'\*'))
后_无码不行_num = len(glob.glob(查找列表[3]+'\*'))
后_百度云已备份_num = len(glob.glob(r'D:\Pictures\porn\封面\HadBeenBackup\*'))
桌面_num = len(glob.glob(r'C:\Users\Denny\Desktop\已存在的封面\*'))


def 匹配(上传列表):

    查找列表 = [r'D:\Pictures\porn\封面\Censored Cover',
            r'D:\Pictures\porn\封面\Censored Cover Exclusion',
            r'D:\Pictures\porn\封面\Uncensored Cover',
            r'D:\Pictures\porn\封面\Uncensored Cover Exclusion',
            ]

    # matched_有码行 = 0
    # matched_有码不行 = 0
    # matched_无码行 = 0
    # matched_无码不行 = 0
    matches = [0, 0, 0, 0]

    for item in Path(上传列表).iterdir():
        # 正则匹配番号    \w+-\w+| \w+
        番号 = re.search(
            r'[a-zA-Z0-9]+-[a-zA-Z0-9]+\s|[a-zA-Z0-9]+_[a-zA-Z0-9]+\s|[0-9]{6}\s|[a-z][0-9]{4}',
            item.name).group()
        for 路径 in 查找列表:
            path = Path(路径)
            for 所有番号路径 in path.iterdir():
                if(番号 in 所有番号路径.name):
                    print(所有番号路径.name)
                    if (路径 == 查找列表[0]):
                        matches[0] += 1
                    if (路径 == 查找列表[1]):
                        matches[1] += 1
                    if (路径 == 查找列表[2]):
                        matches[2] += 1
                    if (路径 == 查找列表[3]):
                        matches[3] += 1

    print(f'''
    \t\t操作信息
    ******************************************************
    \t总计(个)\t\t{file_num}\t

    \t\t\t匹配\t前\t后\t移动
    \t有码留\t\t{matches[0]}\t{前_有码行_num}\t{后_有码行_num}\t{前_有码行_num-后_有码行_num}
    \t有码不留\t{matches[1]}\t{前_有码不行_num}\t{后_有码不行_num}\t{前_有码不行_num-后_有码不行_num}
    \t无码留\t\t{matches[2]}\t{前_无码行_num}\t{后_无码行_num}\t{前_无码行_num-后_无码行_num}
    \t无码不留\t{matches[3]}\t{前_无码不行_num}\t{后_无码不行_num}\t{前_无码不行_num-后_无码不行_num}
    \t百度云已备份\t0\t{前_百度云已备份_num}\t{后_百度云已备份_num}\t{后_百度云已备份_num-前_百度云已备份_num}

    \t已移动\t\t\t\t\t{后_百度云已备份_num-前_百度云已备份_num}
    \t已移动至桌面\t\t\t\t{桌面_num}
    ******************************************************
    ''')


# 匹配(r'D:\视频\H265\porn\Japanese\Censored\[done]\_百度云上传')
匹配(r'D:\视频\porn\日系\有码')
