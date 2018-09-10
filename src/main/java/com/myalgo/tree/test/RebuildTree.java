package com.myalgo.tree.test;

/**
 * �������Ĳ�����
 * 	����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * 	���������ǰ���������������Ľ���ж������ظ������֡�
 * 	��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}��
 * 	���ؽ������������ء�
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
	 * �ؽ��������ķ���
	 */
	public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
		return root;
    }
	//����pre��in��������
	private static TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
		//���ж�
		if(startPre > endPre || startIn > endIn){
			return null;
		}
		//ÿ�ν���pre��startNode��Ϊ��
		TreeNode root = new TreeNode(pre[startPre]);
		for(int i = startIn; i<= endIn; i++){
			if(in[i] == pre[startPre]){
				//Ѱ��startPre��startIn�Ĺؼ����ڣ��ҵ�startIn��head�Ĳ���ݲ���Ѱ��λ��
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