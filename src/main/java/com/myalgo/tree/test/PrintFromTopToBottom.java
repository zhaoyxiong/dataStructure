package com.myalgo.tree.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试二叉树
 * 	从上往下打印出二叉树的每个节点，
 * 	同层节点从左至右打印
 * @author Administrator
 */
public class PrintFromTopToBottom {

	public static void main(String[] args) {
		
	}
	
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>(); 
        if(root != null){
        	queue.offer(root);
        }
        while(!queue.isEmpty()){
        	TreeNode node = queue.poll();
        	if(node.left!=null){
        		queue.offer(node.left);
        	}
        	if(node.right != null){
        		queue.offer(node.right);
        	}
        	list.add(node.val);
        }
		
		return list;
    }
}
