package com.myalgo.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ����ջ�����ݽṹ��
 * 	���ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min����
 * 	��ʱ�临�Ӷ�ӦΪO��1������
 * @author Administrator
 */
public class StackMinMethod {

	Stack<Integer> stack = new Stack<Integer>();
	List<Integer> list = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		StackMinMethod s = new StackMinMethod();
		s.push(3);
		s.push(4);
		s.push(2);
		s.push(1);
		s.pop();
		System.out.println(s.top());
		System.out.println(s.min());
	}
	
	public void push(int node) {
		int point = 0;
		for(int i = 0; i < list.size(); i ++){
			if(node < list.get(i)){
				point = i;
				break;
			}
			else{
				point = list.size();
			}
		}
		list.add(point, node);
		stack.push(node);
    }
    
    public void pop() {
        int node = stack.pop();
        list.remove(list.indexOf(node));
    }
    
    public int top() {
    	return stack.get(stack.size()-1);
    }
    
    public int min() {
    	return list.get(0);
    }
    
}