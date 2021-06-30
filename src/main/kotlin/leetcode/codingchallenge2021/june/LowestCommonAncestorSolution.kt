package leetcode.codingchallenge2021.june

import leetcode.util.TreeNode
import java.util.*

object LowestCommonAncestorSolution {
    fun lowestCommonAncestor(root: TreeNode, p: TreeNode?, q: TreeNode?): TreeNode {
        val pathP = pathOf(root, 0, p!!.`val`, LinkedList<Pair<Int, Int>>().apply { add(root.`val` to 0) })
        val pathQ = pathOf(root, 0, q!!.`val`, LinkedList<Pair<Int, Int>>().apply { add(root.`val` to 0) })
        val ans: Int

        loop@ while (true) {
            when {
                pathP.last.second < pathQ.last.second -> pathQ.removeLast()
                pathP.last.second > pathQ.last.second -> pathP.removeLast()
                pathP.last.first == pathQ.last.first -> {
                    ans = pathP.last.first
                    break@loop
                }
                else -> {
                    pathP.removeLast()
                    pathQ.removeLast()
                }
            }
        }

        return TreeNode(ans)
    }

    fun pathOf(current: TreeNode, rank: Int, target: Int, acc: LinkedList<Pair<Int, Int>>): LinkedList<Pair<Int, Int>> {
        if (current.`val` == target) return acc

        if (current.left != null) {
            acc.addLast(current.left!!.`val` to rank + 1)
            pathOf(current.left!!, rank + 1, target, acc)
            if (acc.last.first == target) return acc
            acc.removeLast()
        }

        if (current.right != null) {
            acc.addLast(current.right!!.`val` to rank + 1)
            pathOf(current.right!!, rank + 1, target, acc)
            if (acc.last.first == target) return acc
            acc.removeLast()
        }

        return acc
    }
}