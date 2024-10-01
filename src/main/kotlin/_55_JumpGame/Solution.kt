package _55_JumpGame

fun main() {
    val solution = Solution()

    println(solution.canJump(intArrayOf(1, 2))) // true
    println(solution.canJump(intArrayOf(0, 1))) // false
    println(solution.canJump(intArrayOf(2, 0))) // true
    println(solution.canJump(intArrayOf(2, 3, 1, 1, 4))) // true
    println(solution.canJump(intArrayOf(3, 2, 1, 0, 4))) // false
}

class Solution {

    fun canJump(nums: IntArray): Boolean {
        var reachable = 0

        for (i in nums.indices) {
            if (i > reachable) return false
            reachable = maxOf(reachable, i + nums[i])
            if (reachable >= nums.size - 1) return true
        }

        return false
    }
}

class MySolution {

    fun canJump(nums: IntArray): Boolean {
        val size = nums.size
        if (size < 2) return true

        val last = size - 1
        var pos = 1
        var step = nums[pos]

        pos += step
        if (pos == last) return true
        while (pos < size) {

            step = nums[pos]
            if (step == 0) return false

            pos += step
            if (pos == last) return true
        }

        return false
    }
}

/**
 * You are given an integer array nums. You are initially positioned
 * at the array's first index, and each element in the array represents
 * your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what.
 * Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */


class LcSolution {

    fun canJump(nums: IntArray): Boolean {
        val size = nums.size
        if (size < 2) return true

        var last = size - 1

        for (i in size - 2 downTo 0) {
            if (i + nums[i] >= last) {
                last = i
            }
        }

        return last == 0
    }
}