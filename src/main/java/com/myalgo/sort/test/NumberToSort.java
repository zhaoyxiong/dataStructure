package com.myalgo.sort.test;

import java.util.ArrayList;

/**
 * 	
 * 	С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������     c�ĺ�,�����Ͼ�д������ȷ����100��
 * 	���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * 	û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * 	���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������?
 * @author Administrator
 */
public class NumberToSort {

	public static void main(String[] args) {
		System.out.println(FindContinuousSequence(100));
	}
    public static ArrayList<ArrayList<Integer> > FindContinuousSequence(int sum) {
    	
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        //�ҵ����ţ�2*sum���� 
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            //�������ƽ��ֵ�������ֱ��ȡ�����ֵ
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