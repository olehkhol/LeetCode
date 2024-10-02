package _58_LengthOfLastWord

fun main() {
    val solution = Solution()

    println(solution.lengthOfLastWord("Hello World"))
    println(solution.lengthOfLastWord("   fly me   to   the moon  "))
    println(solution.lengthOfLastWord("luffy is still joyboy"))
}

class Solution {
    fun lengthOfLastWord(s: String): Int {
        val length = s.length
        var lastIndex = length - 1
        var result = 0

        do {
            if (s[lastIndex] != ' ') {
                result++
            } else if (result > 0) {
                return result
            }

            lastIndex--
        } while (lastIndex >= 0)

        return result
    }
}

class FastSolution {
    fun lengthOfLastWord(s: String): Int {
        return s.trim().split(' ').last().length
    }
}