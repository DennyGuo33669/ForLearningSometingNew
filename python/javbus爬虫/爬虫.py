import requests
import bs4

proxy = '127.0.0.1:1080'
proxies = {
    'http': 'socks5://' + proxy,
    'https': 'socks5://' + proxy
}
headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36'
}


def 番号搜索(番号):
    res = requests.get(f'https://www.javbus.com/{番号}',
                       headers=headers,
                       proxies=proxies)
    soup = bs4.BeautifulSoup(res.text, 'html.parser')

    标题 = soup.find('div', class_='col-md-9 screencap').img['title']  # 标题
    封面 = soup.find('div', class_='col-md-9 screencap').img['src']  # 封面

    msg = soup.find('div', class_='col-md-3 info').find_all('p')
    识别码 = msg[0].text[4:].strip()
    发行日期 = msg[1].text[5:].strip()
    长度 = msg[2].text[3:-2].strip()+'分钟'
    导演 = msg[3].text[3:].strip()
    制作商 = msg[4].text[4:].strip()
    发行商 = msg[5].text[4:].strip()
    类别 = msg[6].text.strip()
    演员 = msg[9].text.strip()
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
    番号_dict['类别'] = 类别
    番号_dict['演员'] = 演员

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
    return 番号_dict


def 保存图片(番号信息, 保存地址):
    r = requests.get(番号信息['封面'],
                     headers=headers,
                     proxies=proxies)
    with open(保存地址+番号信息['识别码']+'.jpg', 'wb') as f:
        f.write(r.content)
        f.close()
    print('文件保存成功')


番号信息 = 番号搜索('DNJR-030')
保存地址 = 'C:/Users/Denny/Desktop/封面测试/'
保存图片(番号信息, 保存地址)
