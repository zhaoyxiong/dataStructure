package com.myalgo.tree.test;

/**
 * 测试树的操作：
 * 	输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 	假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 	例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 	则重建二叉树并返回。
 * @author Administrator
 *
 */
public class RebuildTree {

	public static void main(String[] args) {
		int[] pre = {1,2,4,7,3,6,5,8};
		int[] in = {4,7,2,1,5,3,8,6};
		System.out.println(reConstructBinaryTree(pre,in));
	}
	/*
	 * 重建二叉树的方法
	 */
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
		return root;
    }
	//传入pre和in两个数组
	private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		//先判断
		if(startPre > endPre || startIn > endIn){
			return null;
		}
		//每次进入pre的startNode都为根
		TreeNode root = new TreeNode(pre[startPre]);
		for(int i = startIn; i<= endIn; i++){
			if(in[i] == pre[startPre]){
				//寻找startPre和startIn的关键在于，找到startIn到head的差，根据差老寻找位置
				root.left = reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
				root.right = reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
			}
		}
		return root;
	}
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ 
    	this.val = x;
    }
	@Override
	public String toString() {
		return "TreeNode [val=" + val + ",\n left=" + left + ", right=" + right + "]";
	}
    
}