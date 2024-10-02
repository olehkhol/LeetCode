package _14_LongestCommonPrefix

fun main() {
    val solution = Solution()

    println(solution.longestCommonPrefix(arrayOf("flower","flow","flight")))
    println(solution.longestCommonPrefix(arrayOf("dog","racecar","car")))
}

class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var i = 0
        var l = 0

        while(true) {
            var c = ' '
            strs.forEach { word ->
                val length = word.length
                if (i >= length) return word.substring(0, length)
                if (c == ' ') c = word[i]
                if (c != word[i]) return word.substring(0, i)
            }

            i++
        }
    }
}

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */