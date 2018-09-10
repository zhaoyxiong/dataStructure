package com.myalgo.test;

/**
 * 测试串的使用：
 * 	将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，
 * 	要求不能使用字符串转换整数的库函数。 
 * 	数值为0或者字符串不是一个合法的数值则返回0。
 * @author Administrator
 */
public class ChangeStringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = 1 << 31;
		System.out.println(StrToInt("-2147483648"));
	}
	
	
	public static int StrToInt(String str) {
        if(str.isEmpty()){
        	return 0;
        }
        
        char index;
        char str_head = str.charAt(0);
        int count = 0;
        if(str_head == '+' || str_head == '-'){
        	str = str.substring(1);
        }
    	for(int i = 0; i < str.length(); i ++){
        	index = str.charAt(i);
        	if(!(index > '0' && index < '9')){
        		return 0;
        	}
        }
    	
    	for(int i = 0,j = str.length()-1; i < str.length(); i++, j--){
    		index = str.charAt(i);
    		index -= 48;
        	count = count + (int)(Math.pow(10, j) * index);
        }
        
    	if(str_head == '-'){
        	count = count * -1;
        }
		return count;
    }
}
