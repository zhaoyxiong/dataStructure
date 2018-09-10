package com.myalgo.number.test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 数据算法：
 * 	把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 	例如6、8都是丑数，但14不是，因为它包含质因子7。 
 * 	习惯上我们把1当做是第一个丑数。
 * 	求按从小到大的顺序的第N个丑数。
 * @author Administrator
 */
public class UglyNumber {

	public static void main(String[] args) {
		System.out.println(GetUglyNumber_Solution(7));
	}
	/*
	 * 首先除2，直到不能整除为止，然后除5到不能整除为止，然后除3直到不能整除为止。
	 * 最终判断剩余的数字是否为1，如果是1则为丑数，否则不是丑数。
	 */
	//惊叹：极其暴力

	public static int GetUglyNumber_Solution(int index) {
		if (index < 7)
			return index;
		int [] res = new int[index];
		res[0] = 1;
		int uglyNum2 = 0;
		int uglyNum3 = 0;
		int uglyNum5 = 0;

		for(int i = 1; i < index; i ++){
			
			res[i] = min(res[uglyNum2] * 2,min(res[uglyNum3] * 3, res[uglyNum5] * 5));
			if(res[i] == res[uglyNum2] * 2)
				uglyNum2 ++;
			if(res[i] == res[uglyNum3] * 3)
				uglyNum3 ++;
			if(res[i] == res[uglyNum5] * 5)
				uglyNum5 ++;
			
		}
		return res[index - 1];
	}
	
	public static int min(int num1, int num2){
		if(num1 > num2){
			return num2;
		}else{
			return num1;
		}
	}
	//此方法存在差漏，
	/*public static int GetUglyNumber_Solution(int index) {
        if(index == 1){
        	return 1;
        }
        if(index == 2){
        	return 2;
        }
        if(index == 3){
        	return 3;
        }
		//循环增加数据;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(5);
		for(int i = 1; i < list.size() ; i ++){
			//从第一位,第二位开始
			for(int j = 1; j < i + 1; j ++){
				//如果为第一位，则自己乘以自己
				int uglyNum = list.get(j) * list.get(i);
				if(!list.contains(uglyNum)){
					list.add(uglyNum);
				}
				Collections.sort(list);
				System.out.println(list);
				//如果list的size长度为index，则最后一位就是返回值
				if(list.size() == index){
					Collections.sort(list);
					return list.get(list.size() - 1);
				}
			}
		}
		return 0;
    }*/
}
//
