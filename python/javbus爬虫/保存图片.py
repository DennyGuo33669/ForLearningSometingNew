import requests
proxy = '127.0.0.1:1080'
proxies = {
    'http': 'socks5://' + proxy,
    'https': 'socks5://' + proxy
}
headers = {
    'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.150 Safari/537.36'
}
name = '123123123'
path = r'C:\Users\Denny\Desktop\封面测试\abcaaaaaa.jpg'  # 保存地址及名称
url = 'https://pics.javbus.com/cover/808a_b.jpg'  # 网页地址
r = requests.get(url,
                 headers=headers,
                 proxies=proxies)
with open('C:/Users/Denny/Desktop/封面测试/'+name+'.jpg', 'wb') as f:
    f.write(r.content)
    f.close()
print('文件保存成功')
