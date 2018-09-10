package com.myalgo.test;

/**
 * 变态跳台阶:
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * @author Administrator
 */
public class JumpStepII {

	public static void main(String[] args) {
		System.out.println(jumpFloorII(10));
	}
	public static int jumpFloorII(int target) {
        //如果target<=0，则直接返回0
		if(target <= 0){
        	return 0;
        }
		//如果target==1,则直接返回1
		if(target == 1){
			return 1;
		}
		//如果target == 2，则直接返回2
		if(target == 2){
			return 2;
		}
		//如果target >= 3,则进行斐波那契数列的迭代
		int first = 1;
		int second = 2;
		int count = first + second;
		//设置初始值为第一 + 第二
		int all = first + second;
		//小循环计算前（n-1）的和，算出当前count
		for(int i = 3; i < target; i ++){
			count = count * 2;
		}
		return count;
    }
}