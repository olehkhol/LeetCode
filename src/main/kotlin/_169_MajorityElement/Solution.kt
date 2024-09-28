package _169_MajorityElement

fun main() {
    val nums: IntArray = intArrayOf(3, 3, 4)

    val k = Solution().majorityElement(nums)

    println(k)
}

class Solution {
    fun majorityElement(nums: IntArray): Int {
        if (nums.size == 1) return nums[0]

        var map = HashMap<Int, Int>()
        var k = 0
        var maj = 0

        for (i in nums) {
            val v = map.get(i)

            if (v != null) {
                val w = v + 1
                map.put(i, w)

                if (w > maj) {
                    maj = w
                    k = i
                }
            } else {
                map.put(i, 1)
            }
        }

        return k
    }
}

class SolutionOld {
    fun majorityElement(nums: IntArray): Int {
        var map = HashMap<Int, Int>()
        var j = 0

        for (i in nums) {
            val v = map.get(i)

            if (v != null) {
                map.put(i, v + 1)
            } else {
                map.put(i, 1)
            }
        }

        val k = map.entries.sortedByDescending { it.value }.firstOrNull()?.key

        return k ?: -1
    }
}

/**
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */