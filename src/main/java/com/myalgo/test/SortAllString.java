package com.myalgo.test;

import java.util.ArrayList;

/**
 * 排序所有的字符
 * 	输入一个字符串 , 按字典序打印出该字符串中字符的所有排列。
 * 	例如输入字符串abc , 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * @author Administrator
 */
public class SortAllString {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println(Permutation(str));
	}
	
	//核心问题为排序问题：排序
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