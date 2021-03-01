from typing import Match
import time


# txt_file = r"C:\Users\Denny\Desktop\封面测试\123.txt"


def open_txt(url):
    msg = {
        'content': [],
        'num': 0,
    }
    with open(url, "r", encoding='utf-8', errors='ignore') as f:  # 打开文件
        data = f.readlines()  # 读取文件
    for i in data:
        msg['content'].append(i)
        msg['num'] += 1

    # print(f"读取数据{msg['num']}条")

    f.close()
    return msg


def del_txt(id, txt_file):
    with open(txt_file, 'r', encoding='utf-8', errors='ignore') as r:
        lines = r.readlines()
        # for i in lines:
        #     print(i)
    with open(txt_file, 'w', encoding='utf-8', errors='ignore') as w:
        for l in lines:
            if id not in l:
                w.write(l)
                print(f'删除{id}')
    r.close()
    w.close()


def write_txt(信息, url):
    with open(url, "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
        for i in 信息:
            a.writelines(f'{i}\n')

    # 记录写入日期格式化成2016-03-20 11:45:39形式
    # a.writelines('\n==========================================')
    # a.writelines('操作日期:')
    # a.writelines(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()))
    # a.writelines('\n')
    # a.writelines('\n')
    # a.close()


# def confirm_txt(url):
#     ff = open(r"C:\Users\Denny\Desktop\封面测试\下载列表.txt", 'w',
#               encoding='utf-8', errors='ignore')  # 打开一个文件，可写模式
#     with open(r"C:\Users\Denny\Desktop\封面测试\清洗完毕.txt", 'r', encoding='utf-8', errors='ignore') as f:  # 打开一个文件只读模式
#         line = f.readlines()  # 读取文件中的每一行，放入line列表中
#         for line_list in line:
#             line_new = line_list.replace('\n', '')  # 将换行符替换为空('')
#             line_new = line_new+r'√'+'\n'  # 行末尾加上"|",同时加上"\n"换行符
#             print(line_new)
#             ff.write(line_new)  # 写入一个新文件中


# del_txt('rbd-999', txt_file)
# confirm_txt('2')
