var MongoClient = require('mongodb').MongoClient;
var url = 'mongodb://localhost:27017/';

MongoClient.connect(url, { useNewUrlParser: true }, function (err, db) {
  if (err) throw err;
  var dbo = db.db('mycol');
  var myobj = [{
    学年: '2019-2020',
    学期: '1',
    课程代码: '121246',
    课程名称: 'Java程序设计',
    课程性质: '专业课',
    学分: 3.0,
    成绩: 89,
    绩点: 3.90
  }, {
    学年: '2019-2020',
    学期: '1',
    课程代码: '121247',
    课程名称: 'Java程序设计课程设计',
    课程性质: '实践教学',
    学分: 2.0,
    成绩: '及格',
    绩点: 1.50
  }, {
    学年: '2019-2020',
    学期: '1',
    课程代码: '121355',
    课程名称: '软件工程导论',
    课程性质: '专业基础课',
    学分: 2.5,
    成绩: 89,
    绩点: 3.90
  }, {
    学年: '2019-2020',
    学期: '1',
    课程代码: '121406',
    课程名称: '专业导论',
    课程性质: '专业基础课',
    学分: 0.5,
    成绩: '优秀',
    绩点: 4.50
  }, {
    学年: '2019-2020',
    学期: '1',
    课程代码: '1MT001',
    课程名称: '军事技能训练',
    课程性质: '实践教学',
    学分: 2.0,
    成绩: '良好',
    绩点: 3.50
  }];
  // var my = { 1: 2 };
  dbo.collection('三江分数_郭子文1').insertMany(myobj, function (err, res) {
    if (err) throw err;
    console.log('插入的文档数量为: ' + res.insertedCount);
    db.close();
  });
});
