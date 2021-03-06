import sys
import webbrowser
import 获取本地文件名称
import 清洗数据

# sys.path.append("libs")
文件名称数据 = 获取本地文件名称.file_name(r'D:\Pictures\porn\封面\Download Later')

data ={
    "content":[]
}

for i in 文件名称数据['files']:
    for j in i:
        data["content"].append(j)
        # print(j)

id_dict = 清洗数据.match_id(data)

for id in id_dict["id"]:
    番号 = id
    url = 'https://www.javbus.com/'+番号
    print(url)
webbrowser.open(url)



