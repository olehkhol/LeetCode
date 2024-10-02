package _28_FindTheIndexOfTheFirstOccurrenceInAString

fun main() {
    val solution = Solution()

    println(solution.strStr(haystack = "a", needle = "a"))
    println(solution.strStr(haystack = "sadbutsad", needle = "sad"))
    println(solution.strStr(haystack = "leetcode", needle = "leeto"))
}

class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val hLen = haystack.length
        val nLen = needle.length

        if (nLen > hLen) return -1

        for (i in 0 .. hLen - nLen) {
            if (haystack[i] == needle[0]) {
                var j = 1

                while (j < nLen) {
                    if (haystack[i+j] != needle[j]) break
                    j++
                }

                if (j == nLen) return i
            }
        }

        return -1
    }
}

class FastSolution {
    fun strStr(haystack: String, needle: String): Int {
        return haystack.indexOf(needle)
    }
}