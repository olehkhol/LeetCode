package _121_BestTimeToBuyAndSellStock

import kotlin.math.max

fun main() {
    val prices: IntArray = intArrayOf(2, 4, 1)

    val profit = Solution().maxProfit(prices)

    println(profit)
}

class Solution {
    fun maxProfit(prices: IntArray): Int {
        val size = prices.size
        if (size < 2) return 0

        var min = prices[0]
        var profit = 0

        for (i in 1 until size) {
            if (min > prices[i]) {
                min = prices[i]
            }

            profit = max(profit, prices[i] - min)
        }

        return profit
    }
}

class SolutionOld {
    fun maxProfit(prices: IntArray): Int {
        val size = prices.size
        if (size < 2) return 0

        var minPos = 0
        var maxPos = size - 1
        var min = prices[minPos]
        var max = prices[maxPos]

        while (minPos < maxPos) {
            if (min > prices[maxPos]) {
                minPos++
                min = prices[minPos]
            } else {
                maxPos--
                if (max < prices[maxPos]) {
                    max = prices[maxPos]
                }
            }
        }

        return max - min
    }
}

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing
 * a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */