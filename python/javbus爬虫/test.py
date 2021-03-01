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

res  = requests.get('http://movie.douban.com/top250/',
                        headers=headers, proxies=proxies)
soup = bs4.BeautifulSoup(res.text, 'html.parser')
targets = soup.find_all('div', class_='hd')
for i in targets:
    print(i.a.span.text)
