package com.myalgo.tree.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ���Զ�����
 * 	�������´�ӡ����������ÿ���ڵ㣬
 * 	ͬ��ڵ�������Ҵ�ӡ
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
