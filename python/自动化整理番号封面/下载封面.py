import re
import requests
import bs4
import random
import time
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
    "Mozilla/5.0 (Macintosh; U; PPC Mac OS X 10.5; en-US; rv:1.9.2.15) Gecko/20110303 Firefox/3.6.15",
    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; AcooBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
    "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)",
    "Mozilla/4.0 (compatible; MSIE 7.0; AOL 9.5; AOLBuild 4337.35; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
    "Mozilla/5.0 (Windows; U; MSIE 9.0; Windows NT 9.0; en-US)",
    # "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)",
    "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 1.0.3705; .NET CLR 1.1.4322)",
    "Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 3.0.04506.30)",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/523.15 (KHTML, like Gecko, Safari/419.3) Arora/0.3 (Change: 287 c9dfb30)",
    "Mozilla/5.0 (X11; U; Linux; en-US) AppleWebKit/527+ (KHTML, like Gecko, Safari/419.3) Arora/0.6",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070215 K-Ninja/2.1.1",
    "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9) Gecko/20080705 Firefox/3.0 Kapiko/3.0",
    "Mozilla/5.0 (X11; Linux i686; U;) Gecko/20070322 Kazehakase/0.4.5",
    "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.8) Gecko Fedora/1.9.0.8-1.fc10 Kazehakase/0.5.6",
    "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
    # "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.20 (KHTML, like Gecko) Chrome/19.0.1036.7 Safari/535.20",
    # "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52",
]
# user_agent_list = [
#     # "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36",
#     # "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36",
#     # "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36",
#     # "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/64.0.3282.186 Safari/537.36",
#     "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36",
#     # "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36",
#     # "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)",
#     # "Mozilla/5.0 (Macintosh; U; PPC Mac OS X 10.5; en-US; rv:1.9.2.15) Gecko/20110303 Firefox/3.6.15",
#     # "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; AcooBrowser; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
#     # "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0; Acoo Browser; SLCC1; .NET CLR 2.0.50727; Media Center PC 5.0; .NET CLR 3.0.04506)",
#     # "Mozilla/4.0 (compatible; MSIE 7.0; AOL 9.5; AOLBuild 4337.35; Windows NT 5.1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)",
#     # "Mozilla/5.0 (Windows; U; MSIE 9.0; Windows NT 9.0; en-US)",
#     # "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Win64; x64; Trident/5.0; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 2.0.50727; Media Center PC 6.0)",
#     # "Mozilla/5.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0; WOW64; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; .NET CLR 1.0.3705; .NET CLR 1.1.4322)",
#     # "Mozilla/4.0 (compatible; MSIE 7.0b; Windows NT 5.2; .NET CLR 1.1.4322; .NET CLR 2.0.50727; InfoPath.2; .NET CLR 3.0.04506.30)",
#     # "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN) AppleWebKit/523.15 (KHTML, like Gecko, Safari/419.3) Arora/0.3 (Change: 287 c9dfb30)",
#     # "Mozilla/5.0 (X11; U; Linux; en-US) AppleWebKit/527+ (KHTML, like Gecko, Safari/419.3) Arora/0.6",
#     # "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.2pre) Gecko/20070215 K-Ninja/2.1.1",
#     # "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9) Gecko/20080705 Firefox/3.0 Kapiko/3.0",
#     # "Mozilla/5.0 (X11; Linux i686; U;) Gecko/20070322 Kazehakase/0.4.5",
#     # "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.8) Gecko Fedora/1.9.0.8-1.fc10 Kazehakase/0.5.6",
#     # "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.11 (KHTML, like Gecko) Chrome/17.0.963.56 Safari/535.11",
#     # "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_3) AppleWebKit/535.20 (KHTML, like Gecko) Chrome/19.0.1036.7 Safari/535.20",
#     # "Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; fr) Presto/2.9.168 Version/11.52",
# ]
headers['User-Agent'] = random.choice(user_agent_list)

# requests.adapters.DEFAULT_RETRIES = 15
# s = requests.session()
# s.keep_alive = False


def 番号搜索(番号):
    try:
        res = requests.get(f'https://www.javbus.com/{番号}',
                           headers=headers,
                           proxies=proxies, timeout=3)
    except:
        print(headers)
        print(time.strftime('%Y-%m-%d %H:%M:%S', time.localtime()))
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
    try:
        r = requests.get(番号信息['封面'],
                         headers=headers,
                         proxies=proxies, timeout=5)
    except:
        print(headers)
        print(time.strftime('%Y-%m-%d %H:%M:%S', time.localtime()))
    if 番号信息['识别码'] in 清洗数据['has_chinese']:
        # print("有中文!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+番号信息['识别码'])
        识别码 = 番号信息['识别码']+'-C'
    else:
        识别码 = 番号信息['识别码']
        
    # 对文件和文件夹命名是不能使用以下9个字符: / \ : * " < > | ?
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
