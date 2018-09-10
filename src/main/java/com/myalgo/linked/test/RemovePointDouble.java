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
		// ���Ϊnull����ֱ�ӷ���ͷ���
		if (root.next == null) {
			return pHead;
		}
		// ���ֻ��һ��,��ֱ�ӷ���ͷ���
		if (root.next.next == null) {
			return pHead;
		}
		// ������,��ɾ��
		/*
		 * if(root.next.val == root.next.next.val){ root.next =
		 * root.next.next.next; }
		 */
		root = temp;
		System.out.println("root is " + root);
		while (temp.next != null) {
			// ���������λ��Ϊnull
			if (temp.next.next != null) {
				if (temp.next.val == temp.next.next.val) {
					System.out.println(temp);
					System.out.println("root is " + root);
					if (temp.next.next.next != null) {
						if (temp.next.next.val == temp.next.next.next.val) {
							//�����2�����ϣ�temp����
							temp.next.next = temp.next.next.next;
						} else {
							//���ֻ������,temp������λ
							temp.next = temp.next.next.next;
						}
					}
					else {
						temp.next = temp.next.next.next;
					}
					System.out.println(temp);
					System.out.println("root is " + root);
				} else {
					// �������ȣ�����
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
	//缺少UTF-8
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