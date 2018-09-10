package com.myalgo.test;

import java.util.ArrayList;

/**
 * 测试数组：
 * 	输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 	打印能拼接出的所有数字中最小的一个。
 * 	例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author Administrator
 */
public class MinNumber {

	public static void main(String[] args) {
		int[] numbers = {3,321,323,322,32123};
		System.out.println(PrintMinNumber(numbers));
	}
	//核心解决办法，排序
	public static String PrintMinNumber(int [] numbers) {
        //如果插入数组长度为0/1，直接返回值
		if(numbers.length == 0){
        	return "";
        }
        if(numbers.length == 1){
        	return "" + numbers[0];
        }
        //返回值类型
        String result = "";
        //将
        ArrayList<Integer> list = new ArrayList<>();
        list = sort(numbers);
        
        for(Integer integer: list){
        	result = result + integer;
        }
        
		return result;
    }
	//冒泡排序
	public static ArrayList<Integer> sort(int [] numbers){
		int temp = 0;
		int min = 0;
		int max = 0;
		
		ArrayList<Integer> list = new ArrayList<>();
		int min_comp = 0;
		for(int i = 0; i < numbers.length - 1; i ++){
			for(int j = i + 1; j < numbers.length; j ++){
				min_comp = min(numbers[i],numbers[j]);
				//找出一次比较的最大值
				max = (min_comp != numbers[i] ? numbers[i]:numbers[j]);
				//如果首位大则交换
				if(min_comp != numbers[i] ? true:false){
					temp = numbers[i];
					numbers[i] = numbers[j];
					numbers[j] = temp;
				}
				//i位为最小值
				min = numbers[i];
			}
			list.add(min);
		}
		list.add(max);
		return list;
	}
	//比较算法
	public static int min(int int1, int int2){
		if(int1 == int2)
			return int1;
		
		String str1 = "" + int1;
		String str2 = "" + int2;
		if(str1.isEmpty() || str2.isEmpty())
			return -1;
		
		//找出两个的最短长度
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
		//找出较长的数组
		String str = str1.length() > str2.length()? str1:str2;
		//对较长的数组的下一位与0位进行比较，返回两者多余位较小的
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