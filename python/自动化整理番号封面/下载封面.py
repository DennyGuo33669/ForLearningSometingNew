import re
import requests
import bs4
import random

proxy = '127.0.0.1:1080'
proxies = {
    'http': 'socks5://' + proxy,
    'https': 'socks5://' + proxy
}
headers = {
    'user-agent': ''
}
user_agent_list = [
    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36",
    "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36",
    "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36",
    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)",
    "Mozilla/5.0 (Macintosh; U; PPC Mac OS X 10.5; en-US; rv:1.9.2.15) Gecko/20110303 Firefox/3.6.15"
]

headers['User-Agent'] = random.choice(user_agent_list)


def 番号搜索(番号):
    res = requests.get(f'https://www.javbus.com/{番号}',
                       headers=headers,
                       proxies=proxies)
    soup = bs4.BeautifulSoup(res.text, 'html.parser')

    temp = soup.find('div', class_='col-md-9 screencap')
    try:
        标题 = temp.img['title']  # 标题
        封面 = temp.img['src']  # 封面

        msg = soup.find('div', class_='col-md-3 info').find_all('p')
        识别码 = msg[0].text[4:].strip()
        发行日期 = msg[1].text[5:].strip()
        长度 = msg[2].text[3:-2].strip()+' 分钟'
        导演 = msg[3].text[3:].strip()
        制作商 = msg[4].text[4:].strip()
        发行商 = msg[5].text[4:].strip()
        # 类别 = msg[6].text.strip()
        类别 = msg[-3].find_all('a')
        演员 = msg[-1].text.strip()
        番号_dict = {
            '识别码': [],
            '标题': [],
            '封面': [],
            '发行日期': [],
            '长度': [],
            '导演': [],
            '制作商': [],
            '发行商': [],
            '类别': [],
            '演员': [],
        }

        番号_dict['识别码'] = 识别码
        番号_dict['标题'] = 标题
        番号_dict['封面'] = 封面
        番号_dict['发行日期'] = 发行日期
        番号_dict['长度'] = 长度
        番号_dict['导演'] = 导演
        番号_dict['制作商'] = 制作商
        番号_dict['发行商'] = 发行商
        # 番号_dict['类别'] = 类别
        番号_dict['演员'] = 演员
        for genre in 类别:
            番号_dict['类别'].append(genre.text)
        # print(f"标题:{标题}")
        # print(f"封面:{封面}")
        # print(f"识别码:{识别码}")
        # print(f"发行日期:{发行日期}")
        # print(f"长度:{长度}")
        # print(f"导演:{导演}")
        # print(f"制作商:{制作商}")
        # print(f"发行商:{发行商}")
        # # print(f"类别:{类别}")
        # print(f"演员:{演员}")
    except AttributeError:
        print(f'下载失败: {番号}!!!!!!!!!!!!!!!!!!!')
        return 番号
    return 番号_dict


def 保存图片(番号信息, 保存地址, 清洗数据):
    r = requests.get(番号信息['封面'],
                     headers=headers,
                     proxies=proxies)

    # 对文件和文件夹命名是不能使用以下9个字符: / \ : * " < > | ?
    if 番号信息['识别码'] in 清洗数据['has_chinese']:
        # print("有中文!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+番号信息['识别码'])
        识别码 = 番号信息['识别码']+'-C'
    else:
        识别码 = 番号信息['识别码']

    标题 = re.sub("[/\:*\"<>|?]+", " ", 番号信息['标题'])
    with open(保存地址+'\\'+识别码 + ' '+标题+'.jpg', 'wb') as f:
        f.write(r.content)
        f.close()
    if 标题 == 番号信息['标题']:
        print(f"下载成功: {识别码} {番号信息['标题']}.jpg")
    else:
        print(f"下载成功: {识别码} {番号信息['标题']} ========> {识别码} {标题}.jpg")
    return 番号信息['识别码']

# print(番号搜索("xvsr-543"))
