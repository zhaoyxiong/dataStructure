package com.myalgo.tree.test;

import java.util.ArrayList;

public class FindNum {

	public static void main(String[] args) {
		TreeNode root8 = new TreeNode(8);
		TreeNode root6 = new TreeNode(6);
		TreeNode root10 = new TreeNode(10);
		TreeNode root5 = new TreeNode(5);
		TreeNode root7 = new TreeNode(7);
		TreeNode root9 = new TreeNode(9);
		TreeNode root11 = new TreeNode(11);
		root8.left = root6;
		root8.right = root10;
		root6.left = root5;
		root6.right = root7;
		root10.left  = root9;
		root10.right = root11;
		System.out.println(KthNode(root8,1));
	}
	static ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    static int key;
    //给定的为二叉搜索树
    static TreeNode KthNode(TreeNode pRoot, int k){
    	if(k <= 0 && pRoot !=null){
    		return null;
    	}else{
    		key = k;
    	}
        if(pRoot != null){
        	System.out.println(pRoot);
            KthNode(pRoot);
            if(k <= list.size()){
            	return list.get(k-1);
            }
        }
        return null;
    }
    static void KthNode(TreeNode pRoot){
        if(pRoot != null){
            KthNode(pRoot.left);
            list.add(pRoot);
            KthNode(pRoot.right);
        }
    }
}
