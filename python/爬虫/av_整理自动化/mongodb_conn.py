import pymongo

client = pymongo.MongoClient("mongodb://localhost:27017/")
db = client["porn"]

db_list = client.list_database_names()
db_name = 'porn'

if db_name in db_list:
    print(f'数据库 {db_name} 已存在!')
else:
    print(f'数据库 {db_name} 不存在!')


col = db['av_data']

for i in col.find():
    print(i)
