package com.myalgo.test;

/**
 * ���Դ���ʹ�ã�
 * 	�����������һ����λָ�����ѭ�����ƣ�ROL����
 * 	�����и��򵥵����񣬾������ַ���ģ�����ָ�����������
 * 	����һ���������ַ�����S���������ѭ������Kλ������������
 * 	���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 * 	����XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
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
