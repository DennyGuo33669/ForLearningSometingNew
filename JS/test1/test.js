var MongoClient = require('mongodb').MongoClient;
var url = 'mongodb://localhost:27017/';
MongoClient.connect(url, { useNewUrlParser: true }, function (err, db) {
  if (err) throw err;
  var dbo = db.db('mycol');
  var whereStr = { }; // 查询条件
  var colName = 'av';

  dbo.collection(colName).find(whereStr).toArray(function (err, result) {
    if (err) throw err;

    for (const key in result) {
      console.log(result[key].番号);
      console.log(new Set(result[key].tags).has('中文字幕'));
      console.log(result);
    }
    db.close();
  });
});
