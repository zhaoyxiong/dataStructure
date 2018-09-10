package com.myalgo.test;

/**
 * 测试String字符串是否为Number
 * 	请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 	例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 	但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * @author Administrator
 */
public class StringIsNumber {

	public static void main(String[] args) {
		char[] str = {'+','.','3','0','3'};
		System.out.println(isNumeric(str));
	}
	//函数实现字符串的
	public static boolean isNumeric(char[] str) {
		
		String char_str = "";
		for(int i = 0; i < str.length; i ++)
			char_str = char_str + str[i];
		System.out.println(char_str);
		
		//先判断符号
		char str_head = str[0];
		if(str_head == '-' || str_head == '+'){
			char_str = char_str.substring(1);
		}
		System.out.println(char_str);
		//再判断首位数字是否为数字
		char str_second = char_str.charAt(0);
		if(str_second != '.'){
			if(str_second > '9' || str_second < '0'){
				return false;
			}
		}
		System.out.println(char_str);
		//如果为指数级
		boolean flag_E = false;
		int index_e = char_str.indexOf("e");
		int index_E = char_str.indexOf("E");
		int index = -1;
		//如果两者同时大于0，则返回false
		if(index_e > 0 && index_E > 0){
			return false;
		}
		if(index_e > 0 || index_E > 0){
			flag_E = true;
			index = index_e > 0 ? index_e : index_E;
			System.out.println(index);
			//如果有两个以上的E/e，则直接返回false
			if(char_str.indexOf("E",index+1)>0||char_str.indexOf("e",index+1)>0){
				return false;
			}
			//如果在e/E之后已经没有其他值，则不成数值
			if(char_str.length() == index + 1){
				return false;
			}
		}
		
		//至此时，判断字符串为符合大致规范，之后继续判断是否都属于数字
		if(flag_E){
			String char_left = char_str.substring(0, index);
			String char_right = char_str.substring(index + 1);
			if(char_right.contains("."))
				return false;
			boolean left = isNumber(char_left);
			boolean right = isNumber(char_right);
			
			if(!left || !right){
				return false;
			}
		}
		else{
			if(!isNumber(char_str)){
				return false;
			}
		}
		return true;
    }
	//定义方法判断字符串是否为全数字
	public static boolean isNumber(String str){
		
		if(str.charAt(0) == '-' || str.charAt(0) == '+' || str.charAt(0) == '.'){
			str = str.substring(1);
		}
		if(str.contains(".")){
			String str_left = str.substring(0, str.indexOf("."));
			if(str_left.contains("."))
				return false;
			boolean left = isNumber(str_left);
			String str_right = str.substring(str.indexOf(".") + 1);
			if(str_right.contains("."))
				return false;
			boolean right = isNumber(str_right);
			System.out.println(str.substring(0, str.indexOf(".")));
			System.out.println(str.substring(str.indexOf(".") + 1));
			if(left && right){
				return true;
			}
			else{
				return false;
			}
		}
		char[] str_char = str.toCharArray();
		
		for(int i = 0; i < str_char.length; i ++){
			if(str_char[i] > '9' || str_char[i] < '0'){
				return false;
			}
		}
		return true;
	}
}