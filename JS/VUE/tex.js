
var isPalindrome = (num) => {
  var antiNum = num.toString().split('').reverse().join('');
  // console.log(`本次${num}倒转后为${antiNum}`);
  if (num === antiNum) {
    return true;
  }
};

for (let i = 10; i < 1000; i++) {
  if (isPalindrome(i) && isPalindrome(i * i) && isPalindrome(i * i * i)) {
    console.log(`${i}为回文数`);
  }
}

// for(let i=100;i<1000;i++){
// if(isPalindrome(i)&&isPalindrome(i*i)&&isPalindrome(i*i*i)){
// console.log(`i值为${i}是回文数`);
// }
// }

// var isPalindrome=(num)=>{
// var antiNum=num.split('').reverse().join('');

// console.log(antiNum);
/// /for(let i=0;i<(num.length/2);i++){
/// /if(num[i]!==num[num.length-i-1]){
/// /return false;
/// /}else{
/// /console.log(`i值为${num}是回文数`);
/// /return true;
/// /}
/// /}
// };

/// /for(leti=100;i<1000;i++){
/// /if(isPalindrome(i)&&isPalindrome(i*i)&&isPalindrome(i*i*i)){
/// /console.log(`i值为${i}是回文数`);
/// /}
/// /}
