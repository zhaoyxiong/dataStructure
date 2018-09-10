package com.myalgo.test;

/**
 * ���Դ���ʹ�ã�
 * 	��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�����string����������Ҫ��ʱ����0)��
 * 	Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
 * 	��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
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
