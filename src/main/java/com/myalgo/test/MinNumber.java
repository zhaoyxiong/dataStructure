package com.myalgo.test;

import java.util.ArrayList;

/**
 * �������飺
 * 	����һ�����������飬����������������ƴ�������ų�һ������
 * 	��ӡ��ƴ�ӳ���������������С��һ����
 * 	������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 * @author Administrator
 */
public class MinNumber {

	public static void main(String[] args) {
		int[] numbers = {3,321,323,322,32123};
		System.out.println(PrintMinNumber(numbers));
	}
	//���Ľ���취������
	public static String PrintMinNumber(int [] numbers) {
        //����������鳤��Ϊ0/1��ֱ�ӷ���ֵ
		if(numbers.length == 0){
        	return "";
        }
        if(numbers.length == 1){
        	return "" + numbers[0];
        }
        //����ֵ����
        String result = "";
        //��
        ArrayList<Integer> list = new ArrayList<>();
        list = sort(numbers);
        
        for(Integer integer: list){
        	result = result + integer;
        }
        
		return result;
    }
	//ð������
	public static ArrayList<Integer> sort(int [] numbers){
		int temp = 0;
		int min = 0;
		int max = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		int min_comp = 0;
		for(int i = 0; i < numbers.length - 1; i ++){
			for(int j = i + 1; j < numbers.length; j ++){
				min_comp = min(numbers[i],numbers[j]);
				//�ҳ�һ�αȽϵ����ֵ
				max = (min_comp != numbers[i] ? numbers[i]:numbers[j]);
				//�����λ���򽻻�
				if(min_comp != numbers[i] ? true:false){
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
				//iλΪ��Сֵ
				min = numbers[i];
			}
			list.add(min);
		}
		list.add(max);
		return list;
	}
	//�Ƚ��㷨
	public static int min(int int1, int int2){
		if(int1 == int2)
			return int1;
		
		String str1 = "" + int1;
		String str2 = "" + int2;
		if(str1.isEmpty() || str2.isEmpty())
			return -1;
		
		//�ҳ���������̳���
		int min_len = (str1.length() > str2.length()?str2.length() : str1.length()); 
		//
		for(int i = 0; i < min_len; i ++){
			if(str1.charAt(i) < str2.charAt(i)){
				return int1;
			}
			else if(str1.charAt(i) == str2.charAt(i)){
				continue;
			}
			else{
				return int2;
			}
		}
		//�ҳ��ϳ�������
		String str = str1.length() > str2.length()? str1:str2;
		//�Խϳ����������һλ��0λ���бȽϣ��������߶���λ��С��
		if(str.charAt(min_len) < str.charAt(0)){
			if(str1.length() > str2.length()){
				return int1;
			}
			else{
				return int2;
			}
		}
		return -1;
	}
}