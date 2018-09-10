package com.myalgo.stack.test;

/**
 * ����ջ�Ĳ�����
 * 	���������������У�
 * 	��һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * 	����ѹ��ջ���������־�����ȡ�
 * 	��������1,2,3,4,5��ĳջ��ѹ��˳������4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * 	��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С�
 * 	��ע�⣺���������еĳ�������ȵģ�
 * @author Administrator
 */
public class StackOutInout {

	public static void main(String[] args) {
		int[] pushA = {1,2,3};
		int[] popA = {3,1,2};
		System.out.println(IsPopOrder(pushA,popA));
	}
	/*
	 * ���˼�룺
	 * 	1.ÿ������ĺ�λ���ʱ��ǰ��λ���뵹����������߷ֿ����
	 * 	2.��Ҫ�Ա��������飬��ģ�鲻��Ӧʱ������ 1 ���ж�
	 */
	
	public static boolean IsPopOrderCycle(int [] pushA,int [] popA,int endPopA){
		//����Ѱ�ң�����ջ�����һλ��ʼ
		for(int z = pushA.length - 1; z > 0; z --){
			int startPopA = -1;
			//ѭ���������ҵ����һλ
			for(int x = 0; x < popA.length ; x ++){
				if(popA[x] == pushA[z]){
					startPopA = x;
					break;
				}
			}
			//����Ҳ������򷵻�false��˵�����߲�ƥ�䣬���ڲ�ͬ��ֵ
			if(startPopA == -1){
				return false;
			}
			//���ñ��������¼
			int popAIndex = -1;
			//ѭ���ƶ��������Ӧƥ��
			for(int i = pushA.length - 1, j = startPopA + 1; i >= 0 && j <= endPopA;){
				//������ƽ�
				if(popA[j] != pushA[i]){
					i --;
				}else{
					j ++;
					i --;
				}
				popAIndex = j;
			}
			//���ƥ����ɺ�popAIndexû���ƶ��������˵�����ڵ��򣬼���ƥ��
			if(popAIndex < endPopA - 1){
				return false;
			}
		}
		//���û�г����򷵻�true
		return true;
	}
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		//�ж��Ƿ��ǵ����ģ�����ͬ��
		if(pushA.length == popA.length && pushA.length == 1 && pushA[0] != popA[0]){
			return false;
		}
		int endPopA = popA.length - 1;
		return IsPopOrderCycle(pushA,popA,endPopA);
    }
}