// 寻找最长的单词算法挑战

// 返回提供的句子中最长的单词的长度。

// 返回值应该是一个数字。

// 当你完成不了挑战的时候，可以点击'求助'。



// 你可能需要用到以下链接:

// String.prototype.split()
// String.length

// ********************************

// findLongestWord("The quick brown fox jumped over the lazy dog") 应该返回一个数字
// findLongestWord("The quick brown fox jumped over the lazy dog") 应该返回 6.
// findLongestWord("May the force be with you") 应该返回 5.
// findLongestWord("Google do a barrel roll") 应该返回 6.
// findLongestWord("What is the average airspeed velocity of an unladen swallow") 应该返回 8.
// findLongestWord("What if we try a super-long word such as otorhinolaryngology") 应该返回 19.

function findLongestWord(str) {
    var a = str.split(' ');
    var max = 0;
    for (var i = 0; i < a.length; i++) {

        if (max < a[i].length) {
            max = a[i].length
        }
    }

    return max;
}

findLongestWord("The quick brown fox jumped over the lazy dog");