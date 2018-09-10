package com.myalgo.string.test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * �ַ��������У�
 * 	����һ���ַ���,
 * 	���ֵ����ӡ�����ַ������ַ����������С�
 * 	���������ַ���abc,���ӡ�����ַ�a,b,c�������г���
 * 	�������ַ���abc,acb,bac,bca,cab��cba��
 * @author Administrator
 *
 */
public class StringOrder {

	public static void main(String[] args) {
		String str = "aab";
		System.out.println(Permutation(str));
	}
	/*
	 * ����������
	 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ��
	 */
	public static ArrayList<String> Permutation(String str) {
		char[] strChar = str.toCharArray();
		return Permutation(strChar);
    }
	public static ArrayList<String> Permutation(char[] strChar) {
		ArrayList<String> list = new ArrayList<String>();
		if(strChar.length == 1){
			list.add(Arrays.toString(strChar).replaceAll("[\\[\\]\\s,]", ""));
			return list;
		}
		if(strChar.length == 0){
			return list;
		}
		char[] charString = strChar;
		char temp;
		int blag = -1;
		for(int i = 1; i < strChar.length;i++){
			if(strChar[0] == strChar[i]){
				blag = i;
			}
		}
		if(blag == strChar.length - 1){
			list.add(Arrays.toString(strChar).replaceAll("[\\[\\]\\s,]", ""));
			return list;
		}
		String s = "";
		s = Arrays.toString(strChar).replaceAll("[\\[\\]\\s,]", "");
		if(!list.contains(s)){
			list.add(Arrays.toString(strChar).replaceAll("[\\[\\]\\s,]", ""));
		}
		System.out.println(list);
		for(int i = strChar.length - 1; i > 0; i --){
			for(int j = i; j < strChar.length; j ++ ){
				temp = charString[i];
				charString[i] = charString[j];
				charString[j] = temp;
				s = Arrays.toString(charString).replaceAll("[\\[\\]\\s,]", "");
				System.out.println(s);
				if(!list.contains(s)){
					list.add(s);
				}
			}
			for(int z = 0; z < strChar.length; z ++){
				charString[z] = strChar[z];
			}
		}
		return list;
	}
}