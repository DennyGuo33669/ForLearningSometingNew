var MongoClient = require('mongodb').MongoClient;

var url = 'mongodb://localhost:27017/';
const av = {
  番号: '番号',
  发行日期: '发行日期',
  长度: '长度',
  导演: '导演',
  制作商: '制作商',
  发行商: '发行商',
  系列: '系列',
  类别: '类别',
  女优: '女优'
};
const data = [];
for (let i = 0; i < 3; i++) {
  data.push(av);
}

MongoClient.connect(url, { useNewUrlParser: true }, function (err, db) {
  if (err) throw err;
  var dbo = db.db('mycol');
  // var my = { 1: 2 };
  dbo.collection('av').insertMany(data, function (err, res) {
    if (err) throw err;
    console.log('插入的文档数量为: ' + res.insertedCount);
    db.close();
  });
});
