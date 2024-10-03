package _125_ValidPalindrome

fun main() {
    val solution = Solution()

    println(solution.isPalindrome("0P"))
    println(solution.isPalindrome("A man, a plan, a canal: Panama"))
    println(solution.isPalindrome("race a car"))
    println(solution.isPalindrome(" "))
}

private const val DIFF = 'a' - 'A'

class Solution {
    fun isPalindrome(s: String): Boolean {
        var headIndex = 0
        var tailIndex = s.length - 1

        while (headIndex < tailIndex) {
            var head = s[headIndex]
            if (head in 'A'..'Z' ) head = head + DIFF
            if (head !in 'a'..'z' && head !in '0'..'9') {
                headIndex++
                continue
            }
            var tail = s[tailIndex]
            if (tail in 'A'..'Z' ) tail = tail + DIFF
            if (tail !in 'a'..'z' && tail !in '0'..'9') {
                tailIndex--
                continue
            }

            if (head != tail) {
                return false
            }
            headIndex++
            tailIndex--
        }

        return true
    }
}