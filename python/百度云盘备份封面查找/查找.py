from pathlib import Path
import re
import 读取已上传列表
from collections import Counter
import shutil

目标文件夹 = r'D:\Pictures\porn\封面\HadBeenBackup'


def finder(番号):
    path_censored_cover = Path(r'D:\Pictures\porn\封面\Censored Cover')
    path_censored_cover_exclusion = Path(
        r'D:\Pictures\porn\封面\Censored Cover Exclusion')

    for p in path_censored_cover.iterdir():
        if(番号 in p.name):
            print(f"发现目标: {番号} 有码 行 ")
            shutil.move(p, 目标文件夹)
            print("已转移")
            return p.name

    for p in path_censored_cover_exclusion.iterdir():
        if(番号 in p.name):
            print(f"发现目标: {番号} 有码 不行***********")
            shutil.move(p, 目标文件夹)
            print("已转移")
            return p.name

    print(f'未发现:{番号}')
    return 番号


f = 0
for i in 读取已上传列表.data:
    番号 = re.search(r'[a-zA-Z]*-[0-9]*', i).group()
    # print(番号)
    f += 1
    print(f"第{f}个")
    finder(番号)


file_moved = 0
file_not_moved = 0

已备份列表 = Path(r'D:\Pictures\porn\封面\HadBeenBackup').iterdir()

已备份列表个数 = Counter(i.suffix for i in 已备份列表)


# # 输出信息
# print(f'''
#                     操作信息
# ****************************************************************
#         上传列表\t{len(读取已上传列表.data)}个文件
#         查找列表  \t
#         已移动\t{file_moved}个文件
#         未移动\t{file_not_moved}个文件
#         已备份列表移动前\t{已备份列表个数}
#         已备份列表移动后\t

# ****************************************************************
# ''')
