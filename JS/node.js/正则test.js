var test1 = 'miaa203 チ○ポがクスクス笑っちゃう！ 射精後ビンカン亀頭責め2度出しピンサロ 深田えいみ';

// const genId = (str) => {
//   const n = str.search(/[0-9]/);
//   const n1 = str.search(/ /);
//   const ID = str.slice(0, n).toUpperCase() + '-' + str.slice(n, n1);
//   return ID;
// };

// 生成id
const genId = (str) => {
  const idA = str.match(/[A-z]+/);
  const idB = str.match(/[0-9]+/);
  const id = idA + '-' + idB;
  return id.toUpperCase();
};

console.log(`${test1} ===> ${genId(test1)}`);

// 生成名称
var test2 = 'HD-mane-039 [M男] [前列腺] [CBT]';

const genName = (str) => {
  const getId = str.match(/[A-z]+-[0-9]+/);
  const getTags = str.match(/\[(.+?)\]/g);
  const getTitle = '葉月レイラと七人のM男';
  const tags = [];
  for (const key in getTags) {
    tags.push(getTags[key].slice(1, getTags[key].length - 1));
  }
  const name = getId + ' ' + getTitle + ' tags=' + tags;
  return name.toUpperCase();
};

console.log(`${test2} ===> ${genName(test2)}`);

// const getInfo = (av) => {
//     const 番号 = av.id;
//     const 发行日期 = null;
//     const 长度 = null;
//     const 导演 = null;
//     const 制作商 = null;
//     const 发行商 = null;
//     const 系列 = null;
//     const 类别 = null;
//     const 女优 = null;
//   console.log('yes');
// };

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

console.log(data);

module.exports = { av };
