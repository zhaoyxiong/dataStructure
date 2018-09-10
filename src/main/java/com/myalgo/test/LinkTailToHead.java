package com.myalgo.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ʹ��ArrayList��������ԣ�ʵ��link�ĵ���
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList
 * @author Administrator
 *
 */
public class LinkTailToHead {

	/*
	 * 
	 */
	public static void main(String[] args) {
		
		ListNode listNode = new ListNode(12);
		ListNode nextNode = new ListNode(13);
		
		listNode.next = nextNode;
		listNode.next.next = new ListNode(1);
		ListNode nullList = null;
		ArrayList<Integer> list =  printListFromTailToHead(nullList);
		
		System.out.println(list);
	}
	/*
	 * �����д���ListNode��������е������
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode list_Node) {
		
		ListNode listNode = inverte(list_Node);
		
		ArrayList<Integer> array_listNode = null;
		
		
		array_listNode = new ArrayList<Integer>();
		/*
		 * ��listNode������һ���ڵ㣬������ӽ���arrayList
		 */
		while(listNode!=null){
			array_listNode.add(listNode.val);
			ListNode temp_node = listNode.next;
			listNode = temp_node;
		}
		ArrayList<Integer> new_array = new ArrayList<>();
		
		return array_listNode;
    }
	
	/*
	 * ���뵹�򷽷�
	 */
	public static ListNode inverte(ListNode listNode){
		if(listNode == null){
			return null;
		}
		/*
		 * ����������
		 * ��˳���ȡÿ���ڵ㣬Ȼ��ͷ�巨����ͷ�ڵ�
		 */
		ListNode order = listNode;
		//�趨һ��ͷ�ڵ�
		ListNode first = new ListNode(-1);
		first.next = listNode;
		//��ת�ӽڵ�
		ListNode temp = null;
		while(order.next != null){
			//��ʼȡ
			temp = order.next;
			//ɾ��
			order.next = temp.next;
			
			//��temp����ͷ
			temp.next = first.next;
			first.next = temp;
			
		}
		listNode = first.next;
		return listNode;
	}
}
