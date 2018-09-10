package com.myalgo.test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 使用ArrayList链表的特性，实现link的倒序
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList
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
	 * 向其中传入ListNode，对其进行倒序输出
	 */
	public static ArrayList<Integer> printListFromTailToHead(ListNode list_Node) {
		
		ListNode listNode = inverte(list_Node);
		
		ArrayList<Integer> array_listNode = null;
		
		
		array_listNode = new ArrayList<Integer>();
		/*
		 * 若listNode还有下一个节点，则将其添加进入arrayList
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
	 * 插入倒序方法
	 */
	public static ListNode inverte(ListNode listNode){
		if(listNode == null){
			return null;
		}
		/*
		 * 方法分析：
		 * 先顺序获取每个节点，然后头插法插入头节点
		 */
		ListNode order = listNode;
		//设定一个头节点
		ListNode first = new ListNode(-1);
		first.next = listNode;
		//中转子节点
		ListNode temp = null;
		while(order.next != null){
			//开始取
			temp = order.next;
			//删除
			order.next = temp.next;
			
			//将temp插入头
			temp.next = first.next;
			first.next = temp;
			
		}
		listNode = first.next;
		return listNode;
	}
}
