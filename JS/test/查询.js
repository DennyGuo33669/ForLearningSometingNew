var MongoClient = require('mongodb').MongoClient;
var url = 'mongodb://localhost:27017/';

MongoClient.connect(url, { useNewUrlParser: true }, function (err, db) {
  if (err) throw err;
  var dbo = db.db('mycol');
  var whereStr = { 成绩: 1 }; // 查询条件
  dbo.collection('三江分数_郭子文1').find({}, { 成绩: 1, _id: 0 }).toArray(function (err, result) {
    if (err) throw err;
    console.log(result);
    db.close();
  });
});
