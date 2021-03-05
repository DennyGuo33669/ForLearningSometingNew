import txt_operation
import 清洗数据
import 下载封面
import 写入txt
import rename
import time
import os


# url = r"D:\文档\表格\有码 不行.txt"
# url = r"C:\Users\Denny\Desktop\封面测试"
url = r"D:\Pictures\porn\封面"
有码待删除路径 = r'D:\视频\porn\日系\有码\_筛选不行 待删除D'
有码筛选路径 = r'D:\视频\porn\日系\有码\_筛选D'


def 有码不行(有码待删除路径):

    if 写入txt.写入(有码待删除路径, '有码 不行.txt') == 0:
        return print("空列表!!!")
    txt_content = txt_operation.open_txt(
        os.path.join(url, '有码 不行.txt'))  # 打开txt
    番号数据_清洗 = 清洗数据.match_id(txt_content)
    清洗完毕_成功 = f'清洗完毕_成功_{time.strftime(" %Y-%m-%d", time.localtime())}.txt'
    清洗完毕_失败 = f'清洗完毕_失败_{time.strftime(" %Y-%m-%d", time.localtime())}.txt'
    txt_operation.write_txt(番号数据_清洗['id'], os.path.join(
        url, 清洗完毕_成功))  # 清洗数据后成功的txt地址
    txt_operation.write_txt(番号数据_清洗['dismatch'], os.path.join(
        url, 清洗完毕_失败))  # 清洗数据后失败的txt地址

    data = txt_operation.open_txt(os.path.join(url, 清洗完毕_成功))

    def star():
        count = 0
        for id in data['content']:
            番号信息 = 下载封面.番号搜索(id.strip())
            # print(番号信息)
            if isinstance(番号信息, dict):
                下载封面.保存图片(番号信息, os.path.join(
                    url, 'Censored Cover Exclusion'), 番号数据_清洗)
                # 下载封面.保存图片(番号信息, url)
                # txt_operation.write_txt(id, os.path.join(url, '已下载.txt'))
                # txt_operation.del_txt(id, os.path.join(url, '已下载.txt'))
                # txt_operation.confirm_txt(r"C:\Users\Denny\Desktop\封面测试\清洗完毕.txt")
                count += 1
                print(f'进度{count}/{data["num"]}')
                with open(os.path.join(url, '操作日志.txt'), "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
                    a.writelines(
                        f"{time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())}  下载成功: {os.path.join(url, 'Censored Cover Exclusion')}\{番号信息['识别码']} {番号信息['标题']}.jpg\n")
                    a.close()
            else:
                with open(os.path.join(url, '下载失败.txt'), "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
                    a.writelines(f'下载失败:{番号信息}\n')
                    a.close()

                with open(os.path.join(url, '操作日志.txt'), "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
                    a.writelines(
                        f"{time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())}  下载失败: {番号信息}\n")
                    a.close()

            # time.sleep(1)
        print("======================操作完成============================")
        print(f"保存路径:{url}")

    star()


def 有码可以(有码筛选路径):
    if 写入txt.写入(有码筛选路径, '有码 可以.txt') == 0:
        return print("空列表!!!")
    txt_content = txt_operation.open_txt(
        os.path.join(url, '有码 可以.txt'))  # 打开txt
    番号数据_清洗 = 清洗数据.match_id(txt_content)
    txt_operation.write_txt(番号数据_清洗['id'], os.path.join(
        url, '有码可以_清洗完毕_成功.txt'))  # 清洗数据后成功的txt地址
    txt_operation.write_txt(番号数据_清洗['dismatch'], os.path.join(
        url, '有码可以_清洗完毕_失败.txt'))  # 清洗数据后失败的txt地址

    data = txt_operation.open_txt(os.path.join(url, '有码可以_清洗完毕_成功.txt'))

    rename.格式化本地(有码筛选路径)

    def star():
        count = 0
        for id in data['content']:
            番号信息 = 下载封面.番号搜索(id.strip())
            # print(番号信息)
            # print(番号数据_清洗)
            if isinstance(番号信息, dict):
                下载封面.保存图片(番号信息, os.path.join(url, '有码'), 番号数据_清洗)

                count += 1
                print(f'进度{count}/{data["num"]}')
                with open(os.path.join(url, '操作日志.txt'), "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
                    a.writelines(
                        f"{time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())}  下载成功: {os.path.join(url, 'Censored Cover')}\{番号信息['识别码']} {番号信息['标题']}.jpg\n")
                    a.close()
            else:
                with open(os.path.join(url, '下载失败.txt'), "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
                    a.writelines(f'下载失败:{番号信息}\n')
                    a.close()

                with open(os.path.join(url, '操作日志.txt'), "a", encoding='utf-8', errors='ignore') as a:  # 打开文件
                    a.writelines(
                        f"{time.strftime('%Y-%m-%d %H:%M:%S', time.localtime())}  下载失败: {番号信息}\n")
                    a.close()

            time.sleep(1)
        print("======================操作完成============================")
        print(f"保存路径:{url}")

    star()


# 写入txt.写入(r'D:\视频\porn\日系\有码\_筛选不行 待删除D', url)
# 写入txt.写入(r'D:\视频\porn\日系\有码\_筛选D', '有码 可以.txt')
# 写入txt.写入(r'D:\python', '有码 可以.txt')

# print(清洗数据.match_id(txt_operation.open_txt(r'C:\Users\Denny\Desktop\封面测试\有码 不行.txt'))['num'])

有码不行(有码待删除路径)
有码可以(有码筛选路径)
# 有码可以(r'I:\视频\porn\迅雷下载\_百度云上传')

