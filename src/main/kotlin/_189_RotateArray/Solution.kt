package _189_RotateArray

fun main() {
    val nums: IntArray = intArrayOf(-1,-100,3,99)
    val k = 2

    Solution().rotate(nums, k)

    println(nums.joinToString(","))
}

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val size = nums.size
        val k = k % size
        if (size == 1 || k == 0) return

        val center = size - k

        nums.reverse(0, center)
        nums.reverse(center, size)
        nums.reverse()
    }
}

class SolutionOld {
    fun rotate(nums: IntArray, k: Int): Unit {
        val size = nums.size
        if (size == 1 || k == 0) return

        repeat(k) {
            val last = nums.last()

            for (i in size - 1 downTo 1) {
                nums[i] = nums[i - 1]
            }
            nums[0] = last
        }
    }
}

/**
 * Given an integer array nums, rotate the array to the right by k steps,
 * where k is non-negative.
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 *
 *
 * Follow up:
 *
 * Try to come up with as many solutions as you can.
 * There are at least three different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */