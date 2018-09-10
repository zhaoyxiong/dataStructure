package com.myalgo.linked.test;

public class RemovePointDouble {

	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		root.next = new ListNode(1);
		root.next.next = new ListNode(1);
		root.next.next.next = new ListNode(1);
		root.next.next.next.next = new ListNode(1);
		root.next.next.next.next.next = new ListNode(1);
		root.next.next.next.next.next.next = new ListNode(1);
		System.out.println( "---------> " + deleteDuplication(root));
	}
	public static ListNode deleteDuplication(ListNode pHead) {
		ListNode root = new ListNode(-1);
		root.next = pHead;
		ListNode temp = new ListNode(-1);
		temp.next = pHead;
		System.out.println(pHead);
		// 如果为null链表，直接返回头结点
		if (root.next == null) {
			return pHead;
		}
		// 如果只有一个,则直接返回头结点
		if (root.next.next == null) {
			return pHead;
		}
		// 待斟酌,可删除
		/*
		 * if(root.next.val == root.next.next.val){ root.next =
		 * root.next.next.next; }
		 */
		root = temp;
		System.out.println("root is " + root);
		while (temp.next != null) {
			// 如果，后两位不为null
			if (temp.next.next != null) {
				if (temp.next.val == temp.next.next.val) {
					System.out.println(temp);
					System.out.println("root is " + root);
					if (temp.next.next.next != null) {
						if (temp.next.next.val == temp.next.next.next.val) {
							//如果有2个以上，temp后移
							temp.next.next = temp.next.next.next;
						} else {
							//如果只有两个,temp后移两位
							temp.next = temp.next.next.next;
						}
					}
					else {
						temp.next = temp.next.next.next;
					}
					System.out.println(temp);
					System.out.println("root is " + root);
				} else {
					// 如果不相等，后移
					temp = temp.next;
					System.out.println(temp);
					System.out.println(" 2 root is " + root);
				}
			}else{
				temp = temp.next;
			}
		}
		pHead = root.next;
		return pHead;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return "ListNode [val=" + val + ", next=" + next + "]";
	}
	
}