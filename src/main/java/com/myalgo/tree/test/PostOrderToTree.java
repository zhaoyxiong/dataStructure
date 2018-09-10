package com.myalgo.tree.test;
/**
 * 后续遍历转换为树
 * 	输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 	如果是则输出Yes,否则输出No。
 * 	假设输入的数组的任意两个数字都互不相同。
 * @author Administrator
 */
public class PostOrderToTree {

	public static void main(String[] args) {
		int[] seq = {};
		System.out.println(VerifySquenceOfBST(seq));
	}
	
	public static boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0){
			return true;
		}
		boolean isTree = VerifySquenceOfBST(sequence,0,sequence.length-1);
		return isTree;
    }

	public static boolean VerifySquenceOfBST(int [] seq,int startSeq,int endSeq){
		if(endSeq - startSeq == 1  || endSeq - startSeq == 0){
			return true;
		}
		int post = seq[endSeq];
		int newLeftStartSeq = startSeq,newLeftEndSeq = -1;
		int newRightStartSeq = -1,newRightEndSeq = -1;
		boolean flag = false;
		//从起点开始到终点，
		for(int i = startSeq; i <= endSeq; i ++){ //正好去除最后位的root
			if(flag == false){
				if(seq[i] >= post){
					newLeftEndSeq = i - 1;
					flag = true;
				}
			}
			if(flag == true){
				if(seq[i] < post){
					return false;
				}
			}
		}
		if(newLeftEndSeq < newLeftStartSeq){
			newLeftEndSeq = newLeftStartSeq;
		}
		System.out.println(newLeftStartSeq+ "  " + newLeftEndSeq);
		newRightStartSeq = newLeftEndSeq + 1;
		if(newRightStartSeq >= endSeq){
			newRightEndSeq = newRightStartSeq;
		}else{
			newRightEndSeq = endSeq-1;
		}
		return VerifySquenceOfBST(seq,newLeftStartSeq,newLeftEndSeq) && VerifySquenceOfBST(seq,newRightStartSeq,newRightEndSeq);
	}
}