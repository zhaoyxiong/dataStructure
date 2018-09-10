package com.myalgo.test;
/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * @author Administrator
 */
public class RectCover {

	public static void main(String[] args) {
		System.out.println(rectCover(29));
	}
	/*
	 * 分析：当小矩形以叠加排放覆盖时，必须两个同时出现，类似于跳盒子，
	 * 盒子必须以一个或者多个个出现
	 */
	public static int rectCover(int target) {
		//如果输入为0个盒子
		if(target == 0){
			return 0;
		}
		//如果输入为1个盒子
		if(target == 1){
			return 1;
		}
		//如果输入为2个盒子
		if(target == 2){
			return 2;
		}
		int first = 1;
		int second = 2;
		int count = 0;
		//如果输入为大于等于3个盒子
		for(int i = 3; i <= target; i ++){
			count = first + second;
			first = second;
			second = count;
		}
		return count;
    }
}