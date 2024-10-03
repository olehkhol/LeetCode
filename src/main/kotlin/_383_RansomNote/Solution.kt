package _383_RansomNote

fun main() {
    val solution = Solution()

    println(solution.canConstruct(ransomNote = "a", magazine = "b"))
    println(solution.canConstruct(ransomNote = "aa", magazine = "ab"))
    println(solution.canConstruct(ransomNote = "aa", magazine = "aab"))
}

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val rmLen = ransomNote.length
        val mLen = magazine.length

        if (rmLen < 1 || mLen < 1) return false
        if (rmLen > mLen) return false

        val array: IntArray = IntArray('z' - 'a')

        for (c in magazine) {
            array[c - 'a']++
        }

        for (c in ransomNote) {
            if (array[c - 'a'] == 0) return false
            array[c - 'a']--
        }

        return true
    }
}

class FastSolution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val rmLen = ransomNote.length
        val mLen = magazine.length

        if (rmLen < 1 || mLen < 1) return false
        if (rmLen > mLen) return false

        val map = hashMapOf<Char, Int>()

        for(c in magazine) {
            map.put(c, 1 + map.getOrPut(c) { 0 })
        }

        for (c in ransomNote) {
            val v = map.get(c)

            if (v == null) return false

            if (v > 1) {
                map.replace(c, v - 1)
            } else {
                map.remove(c)
            }
        }

        return true
    }
}

/**
 * Given two strings ransomNote and magazine,
 * return true if ransomNote can be constructed
 * by using the letters from magazine and false otherwise.
 *
 * Each letter in magazine can only be used once in ransomNote.
 *
 *
 *
 * Example 1:
 *
 * Input: ransomNote = "a", magazine = "b"
 * Output: false
 * Example 2:
 *
 * Input: ransomNote = "aa", magazine = "ab"
 * Output: false
 * Example 3:
 *
 * Input: ransomNote = "aa", magazine = "aab"
 * Output: true
 *
 *
 * Constraints:
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote and magazine consist of lowercase English letters
 */