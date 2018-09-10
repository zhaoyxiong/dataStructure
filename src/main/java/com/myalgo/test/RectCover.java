package com.myalgo.test;
/**
 * ���θ���
 * ���ǿ�����2*1��С���κ��Ż�������ȥ���Ǹ���ľ��Ρ�
 * ������n��2*1��С�������ص��ظ���һ��2*n�Ĵ���Σ��ܹ��ж����ַ�����
 * @author Administrator
 */
public class RectCover {

	public static void main(String[] args) {
		System.out.println(rectCover(29));
	}
	/*
	 * ��������С�����Ե����ŷŸ���ʱ����������ͬʱ���֣������������ӣ�
	 * ���ӱ�����һ�����߶��������
	 */
	public static int rectCover(int target) {
		//�������Ϊ0������
		if(target == 0){
			return 0;
		}
		//�������Ϊ1������
		if(target == 1){
			return 1;
		}
		//�������Ϊ2������
		if(target == 2){
			return 2;
		}
		int first = 1;
		int second = 2;
		int count = 0;
		//�������Ϊ���ڵ���3������
		for(int i = 3; i <= target; i ++){
			count = first + second;
			first = second;
			second = count;
		}
		return count;
    }
}