var isPalindrome = (num) => {
  var antiNum = num.toString().split('').reverse().join('');
  console.log(`本次${num}倒转后为${antiNum}`);
  if (num === antiNum) {
    console.log(`${num}为 回文数!!!!!!!!!!!!!!!!!!!!!!!!`);
  }
};

for (let i = 100; i < 102; i++) {
  isPalindrome(i);
}
