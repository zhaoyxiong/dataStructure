package com.myalgo.test;

import java.util.ArrayList;

/**
 * �������е��ַ�
 * 	����һ���ַ��� , ���ֵ����ӡ�����ַ������ַ����������С�
 * 	���������ַ���abc , ���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * @author Administrator
 */
public class SortAllString {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println(Permutation(str));
	}
	
	//��������Ϊ�������⣺����
	public static ArrayList<String> Permutation(String str) {
		ArrayList<String> str_list = 
				new ArrayList<String>();
		char[] str_char = str.toCharArray();
		char first;
		char temp;
		str_list.add(str);
		
		for(int i = 0; i < str_char.length; i ++){
			for(int j = i + 1; j < str_char.length; j ++){
				System.out.println(str_char[i]);
				temp = str_char[i];
				str_char[i] = str_char[j];
				str_char[j] = temp;
				str = "";
				for(int z = 0; z < str_char.length; z ++){
					str = str + str_char[i];
				}
				
				
				str_list.add(str);
			}
		}
		return str_list;
    }
}