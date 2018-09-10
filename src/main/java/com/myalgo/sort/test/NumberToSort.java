package com.myalgo.sort.test;

import java.util.ArrayList;

/**
 * 	
 * 	小明很喜欢数学,有一天他在做数学作业时,要求计算出     c的和,他马上就写出了正确答案是100。
 * 	但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 	没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 	现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列?
 * @author Administrator
 */
public class NumberToSort {

	public static void main(String[] args) {
		System.out.println(FindContinuousSequence(100));
	}
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        //找到根号（2*sum）， 
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            //如果存在平均值，则可以直接取到这个值
        	if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }
}