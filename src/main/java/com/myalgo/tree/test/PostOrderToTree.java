package com.myalgo.tree.test;
/**
 * ��������ת��Ϊ��
 * 	����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * 	����������Yes,�������No��
 * 	�������������������������ֶ�������ͬ��
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
		//����㿪ʼ���յ㣬
		for(int i = startSeq; i <= endSeq; i ++){ //����ȥ�����λ��root
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