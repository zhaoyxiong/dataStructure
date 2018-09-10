package com.myalgo.test;

public class JumpStepBest {

	public static void main(String[] args) {
		System.out.println(jump(29));
	}
	
	//利用斐波那契数列解决问题
	public static int jump(int number){
		if(number == 0)
			return 0;
		if(number == 1)
			return 1;
		
		int first = 0;
		int second = 1;
		int count = 0;
		
		for(int i = 0; i < number ; i ++){
			count = first + second;
			first = second;
			second = count;
		}
		return count;
	}
}