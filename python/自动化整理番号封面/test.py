import txt_operation
import 清洗数据
import 下载封面
import re
import time
import random
# 数据 = txt_operation.open_txt(
#     r'C:\Users\Denny\Desktop\Coding\LearningSometingNew\python\自动化整理番号封面\有码待下载 .txt')

# # 清洗数据.match_id(数据)
# id_dict = {
#     'id': []
# }

# for i in 数据['content']:
#     try:
#         番号 = re.search(r'\w+-\w+', i).group()
#         id_dict['id'].append(番号)
#         # print(番号)
#     except AttributeError:
#                 pass

# with open(r'C:\Users\Denny\Desktop\Coding\LearningSometingNew\python\自动化整理番号封面\有码待下载_番号.txt', "r", encoding='utf-8', errors='ignore') as f:  # 打开文件
#     data = f.readlines()  # 读取文件
#     # print(data.__len__())
#     # for id in data:
#     #     # print(id)
#     #     av_data = 下载封面.番号搜索(id.strip())
#     #     下载封面.保存图片(av_data,r'C:\Users\Denny\Desktop\有码待下载_封面', 清洗数据 = {'has_chinese':[]})
#     #     # print(av_data)
#     #     time.sleep(1)
#     num = 0
#     count = 0
#     for id in data:
#         with open(f'C://Users//Denny//Desktop//Coding//LearningSometingNew//python//自动化整理番号封面//有码待下载_番号_{count}.txt', "a", encoding='utf-8', errors='ignore') as a:
#             a.writelines(f'{id}')
#             num += 1
#             if num % 500 == 0:
#                 count += 1

# print(id)

with open(r'C:\Users\Denny\Desktop\Coding\LearningSometingNew\python\自动化整理番号封面\有码待下载_番号.txt', "r", encoding='utf-8', errors='ignore') as f:  # 打开文件
    data = f.readlines()  # 读取文件
    # print(data.__len__())
    for id in data:
        # print(id)
        av_data = 下载封面.番号搜索(id.strip())
        if av_data == id.strip():
            with open(r'C:\Users\Denny\Desktop\Coding\LearningSometingNew\python\自动化整理番号封面\有码待下载_番号_下载失败.txt', "a", encoding='utf-8', errors='ignore') as a:
                a.writelines(f'{av_data}\n')
                a.close()
        else:
            下载封面.保存图片(av_data, r'C:\Users\Denny\Desktop\有码待下载_封面_没有种子',
                      清洗数据={'has_chinese': []})
        time.sleep(random.randint(6, 8))
        # time.sleep(1)

# with open(f'C://Users//Denny//Desktop//Coding//LearningSometingNew//python//自动化整理番号封面//有码待下载_番号_{num}.txt', "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
#     for i in data:
#         try:
#             番号 = re.search(r'\w+-\w+', i).group()
#             a.writelines(f'{番号}\n')
#             # 番号信息 = 下载封面.番号搜索(番号)
#             # 下载封面.保存图片(番号信息, r'C:\Users\Denny\Desktop\有码待下载_封面', 清洗数据 = {'has_chinese':[]})
#             # time.sleep(2)
        # except AttributeError:
        #     with open(r'C:\Users\Denny\Desktop\Coding\LearningSometingNew\python\自动化整理番号封面\有码待下载_番号_匹配失败.txt', "a", encoding='utf-8', errors='ignore') as a_f:
        #         a_f.writelines(f'{番号}\n')
        #         print(f"写入失败{番号}")


#     a.writelines(f'写入{data.__len__()}条数据\n\n')


# for i in data:
#     msg['content'].append(i)
#     msg['num'] += 1

# print(id_dict)
# txt_operation.write_txt(')
