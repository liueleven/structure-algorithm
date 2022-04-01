package v4.tree;

/**
 * @description:
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 2021-06-15 22:29
 * @author: liuziqing
 */
public class Solution {

    static int r = 0;
    static int count = 0;

    public static void main(String[] args) {
//        isValidBST(null,Long.MIN_VALUE,Long.MAX_VALUE);

        int[] nums = {1,1,1}; int target=  3;


        Solution s = new Solution();
        s.dsf(nums,0,0,target);
        System.out.println(r);
        System.out.println(count);
    }

    public static boolean isValidBST(TreeNode root,long left, long right) {

        if (root == null) {
            return true;
        }
        if (root.val <= root.left.val || root.val >= root.right.val) {
            return false;
        }
        return isValidBST(root.left,left, root.val) &&
        isValidBST(root.right,root.val,right);
    }

    public class TreeNode {
      int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
  }


    public int findTargetSumWays(int[] nums, int target) {
        dsf(nums,0,0,target);
        return r;
    }

    /**
     * 力扣 494
     * @param nums      数组
     * @param i         当前树的高度
     * @param sum       走过的节点和值
     * @param target    目标值F
     */
    public void dsf(int[] nums, int i, int sum, int target) {

        if(i == nums.length) {
            if(sum == target) {
                r ++;
            }
            count++;
            return;
        }
        dsf(nums,i+1,sum+nums[i],target);
        dsf(nums,i+1,sum-nums[i],target);
    }



}
