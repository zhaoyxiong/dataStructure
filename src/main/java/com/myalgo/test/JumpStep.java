package com.myalgo.test;

/**
 * 跳台阶
 * @author Administrator
 *
 */
public class JumpStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(jumpFloor(29));
		//System.out.println(ccc(14,15));
	}
	public static int jumpFloor(int number) {
        //T为二阶台阶的最大个数
		int T = number / 2;
        
		int count = 0;
		//动态计算一阶台阶的个数
		
		for(int i = T; i >= 0; i--){
			System.out.println("T is " + i);
			int num_1 = number - 2*i;
			int num_2 = i;
			System.out.println("num_1 is " + num_1  +  "  num_2 is " + num_2);
			System.out.println("The ccc is " + ccc(num_2,num_1 + num_2));
			count += ccc(num_2,num_1 + num_2);
		}
		return count;
    }
	//c
	private static long ccc(int y, int x){
		if(x == y)
			return 1;
		if( y == 0)
			return 1;
		long temp = 1;
		long temp_x = 1;
		for(int i = x; i > (x - y); i --){
			
			if(i > 0){
				temp = temp * i;
				System.out.println("i is " + i);
			}
			System.out.println("temp is " + temp);
		}
		for(int i = y; i > 0; i --){
			System.out.println("temp_x is " + temp_x );
			temp_x = temp_x * i;
		}
		return temp/temp_x;
	}
}
