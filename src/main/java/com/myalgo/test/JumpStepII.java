package com.myalgo.test;

/**
 * ��̬��̨��:
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
 * @author Administrator
 */
public class JumpStepII {

	public static void main(String[] args) {
		System.out.println(jumpFloorII(10));
	}
	public static int jumpFloorII(int target) {
        //���target<=0����ֱ�ӷ���0
		if(target <= 0){
        	return 0;
        }
		//���target==1,��ֱ�ӷ���1
		if(target == 1){
			return 1;
		}
		//���target == 2����ֱ�ӷ���2
		if(target == 2){
			return 2;
		}
		//���target >= 3,�����쳲��������еĵ���
		int first = 1;
		int second = 2;
		int count = first + second;
		//���ó�ʼֵΪ��һ + �ڶ�
		int all = first + second;
		//Сѭ������ǰ��n-1���ĺͣ������ǰcount
		for(int i = 3; i < target; i ++){
			count = count * 2;
		}
		return count;
    }
}