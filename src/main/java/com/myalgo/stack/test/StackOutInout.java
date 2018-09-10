package com.myalgo.stack.test;

/**
 * 测试栈的操作：
 * 	输入两个整数序列，
 * 	第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 	假设压入栈的所有数字均不相等。
 * 	例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 	但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * 	（注意：这两个序列的长度是相等的）
 * @author Administrator
 */
public class StackOutInout {

	public static void main(String[] args) {
		int[] pushA = {1,2,3};
		int[] popA = {3,1,2};
		System.out.println(IsPopOrder(pushA,popA));
	}
	/*
	 * 解决思想：
	 * 	1.每个数组的后位输出时，前几位必须倒叙输出，或者分块输出
	 * 	2.需要对比两个数组，当模块不对应时，采用 1 来判断
	 */
	
	public static boolean IsPopOrderCycle(int [] pushA,int [] popA,int endPopA){
		//倒叙寻找，从入栈的最后一位开始
		for(int z = pushA.length - 1; z > 0; z --){
			int startPopA = -1;
			//循环遍历，找到最后一位
			for(int x = 0; x < popA.length ; x ++){
				if(popA[x] == pushA[z]){
					startPopA = x;
					break;
				}
			}
			//如果找不到，则返回false，说明两者不匹配，存在不同的值
			if(startPopA == -1){
				return false;
			}
			//设置标记量，记录
			int popAIndex = -1;
			//循环移动，倒序对应匹配
			for(int i = pushA.length - 1, j = startPopA + 1; i >= 0 && j <= endPopA;){
				//先向后推进
				if(popA[j] != pushA[i]){
					i --;
				}else{
					j ++;
					i --;
				}
				popAIndex = j;
			}
			//如果匹配完成后popAIndex没有移动到最后，则说明存在倒序，及不匹配
			if(popAIndex < endPopA - 1){
				return false;
			}
		}
		//如果没有出错，则返回true
		return true;
	}
	public static boolean IsPopOrder(int [] pushA,int [] popA) {
		//判断是否是单个的，不相同的
		if(pushA.length == popA.length && pushA.length == 1 && pushA[0] != popA[0]){
			return false;
		}
		int endPopA = popA.length - 1;
		return IsPopOrderCycle(pushA,popA,endPopA);
    }
}