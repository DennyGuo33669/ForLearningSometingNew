const MongoClient = require('mongodb').MongoClient;
const url = 'mongodb://localhost:27017/';
let 分母 = 0;
let 分子 = 0;
MongoClient.connect(url, { useNewUrlParser: true }, function (err, db) {
  if (err) throw err;
  const dbo = db.db('mycol');
  const whereStr = { }; // 查询条件
  const colName = ['三江分数_郭子文', ''];
  const who = colName[1];
  dbo.collection(who).find(whereStr).toArray(function (err, result) {
    if (err) throw err;

    const 计算平均绩点 = (result) => {
      for (const key in result) {
        分母 += result[key].学分 * result[key].绩点;
        分子 += result[key].学分;
      }
      const 平均绩点 = 分母 / 分子;
      return 平均绩点.toFixed(1);
    };
    console.log(`${who.slice(5)}的平均绩点为${计算平均绩点(result)}`);
    db.close();
  });
});
