package com.myalgo.test;

/**
 * ��������ĺϲ���
 * 	���������������������������������ϳɺ������
 * 	��Ȼ������Ҫ�ϳɺ���������㵥����������
 * @author Administrator
 *
 */
public class Solution {

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);/*
		list1.next = new ListNode(3);
		list1.next.next = new ListNode(5);*/
		ListNode list2 = new ListNode(2);/*
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(5);*/
		ListNode list = Merge(list1,list2);
		System.out.println(list.val+ " " + list.next.val + "  " + list.next.next.val );
		list = list.next.next.next;
		System.out.println(list.val+ " " + list.next.val + "  " + list.next.next.val);
	}
	/*
	 * ����������������������
	 */
	public static ListNode Merge(ListNode list1,ListNode list2) {
		//�����µ��ܵ�����
		ListNode list = new ListNode(-1);
		
		ListNode temp = list;
		System.out.println(temp.val);
		System.out.println(list1.next.val);
		System.out.println(list2.next.val);
		while(list1 != null && list2 != null){
			if(list1.val > list2.val){
				temp.next = list2;
				System.out.println("list2 is small " + temp.next.val );
				list2 = list2.next;
				temp = temp.next;
			}
			else if(list1.val < list2.val){
				temp.next = list1;
				System.out.println("list1 is small  " + temp.next.val);
				list1 = list1.next;
				temp = temp.next;
			}
			else{
				temp.next = list1;
				list1 = list1.next;
				temp = temp.next;
				temp.next = list2;
				list2 = list2.next;
			}
		}
		if(list2 != null){
			temp.next = list2;
		}
		if(list1 != null){
			temp.next = list1;
		}
		list = list.next;
		return list;
    }
}
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}