package com.myalgo.test;

/**
 * 测试串的使用：
 * 	汇编语言中有一种移位指令叫做循环左移（ROL），
 * 	现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 	对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 	例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 	即“XYZdefabc”。是不是很简单？OK，搞定它！
 * @author Administrator
 *
 */
public class CycleLeftMove {

	public static void main(String[] args) {
		System.out.println(LeftRotateString("abcdefg",2));
	}
	public static String LeftRotateString(String str,int n) {
        if(str==null){
        	return "";
        }
		String temp = str;
		String temp_str = "";
        for(int i = 0; i < n ; i ++){
        	temp_str = temp.substring(0,1);
        	temp = temp.substring(1);
        	System.out.println(temp_str);
        	temp = temp + temp_str;
        }
		return temp;
    }
}
