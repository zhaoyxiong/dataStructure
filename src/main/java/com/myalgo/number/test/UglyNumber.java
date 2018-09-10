package com.myalgo.number.test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * �����㷨��
 * 	��ֻ����������2��3��5��������������Ugly Number����
 * 	����6��8���ǳ�������14���ǣ���Ϊ������������7�� 
 * 	ϰ�������ǰ�1�����ǵ�һ��������
 * 	�󰴴�С�����˳��ĵ�N��������
 * @author Administrator
 */
public class UglyNumber {

	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(7));
	}
	/*
	 * ���ȳ�2��ֱ����������Ϊֹ��Ȼ���5����������Ϊֹ��Ȼ���3ֱ����������Ϊֹ��
	 * �����ж�ʣ��������Ƿ�Ϊ1�������1��Ϊ�����������ǳ�����
	 */
	//��̾�����䱩��

	public static int GetUglyNumber_Solution(int index) {
		if (index < 7)
			return index;
		int [] res = new int[index];
		res[0] = 1;
		int uglyNum2 = 0;
		int uglyNum3 = 0;
		int uglyNum5 = 0;

		for(int i = 1; i < index; i ++){
			
			res[i] = min(res[uglyNum2] * 2,min(res[uglyNum3] * 3, res[uglyNum5] * 5));
			if(res[i] == res[uglyNum2] * 2)
				uglyNum2 ++;
			if(res[i] == res[uglyNum3] * 3)
				uglyNum3 ++;
			if(res[i] == res[uglyNum5] * 5)
				uglyNum5 ++;
			
		}
		return res[index - 1];
	}
	
	public static int min(int num1, int num2){
		if(num1 > num2){
			return num2;
		}else{
			return num1;
		}
	}
	//�˷������ڲ�©��
	/*public static int GetUglyNumber_Solution(int index) {
        if(index == 1){
        	return 1;
        }
        if(index == 2){
        	return 2;
        }
        if(index == 3){
        	return 3;
        }
		//ѭ����������;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		for(int i = 1; i < list.size() ; i ++){
			//�ӵ�һλ,�ڶ�λ��ʼ
			for(int j = 1; j < i + 1; j ++){
				//���Ϊ��һλ�����Լ������Լ�
				int uglyNum = list.get(j) * list.get(i);
				if(!list.contains(uglyNum)){
					list.add(uglyNum);
				}
				Collections.sort(list);
				System.out.println(list);
				//���list��size����Ϊindex�������һλ���Ƿ���ֵ
				if(list.size() == index){
					Collections.sort(list);
					return list.get(list.size() - 1);
				}
			}
		}
		return 0;
    }*/
}
//
