package com.myalgo.tree.test;

public class NodeNextNode {

	public static void main(String[] args) {
		TreeLinkNode root1 = new TreeLinkNode(1);
		TreeLinkNode root2 = new TreeLinkNode(2);
		TreeLinkNode root3 = new TreeLinkNode(3);
		TreeLinkNode root4 = new TreeLinkNode(4);
		TreeLinkNode root5 = new TreeLinkNode(5);
		TreeLinkNode root6 = new TreeLinkNode(6);
		root1.left = root2;root2.next = root1;
		root1.right = root3;root3.next = root1;
		
		root2.left = root4;root4.next = root2;
		root2.right = root5;root5.next = root2;
		
		root3.right = root6;root6.next = root3;
		System.out.println(GetNext(root3));
		
	}
	public static TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null){
            return null;
        }
        if(pNode.right!=null){
            return GetFirst(pNode.right);
        }
        else if(pNode.next != null){
            //如果当前节点为左节点，返回父节点
            if(pNode.next.left == pNode){
                return pNode.next;
            }else{
                return null;
            }
        }
        return null;
    }
    //循环中序遍历的最后一个节点
    public static TreeLinkNode GetFirst(TreeLinkNode pNode){
        if(pNode.left != null){
            while(pNode.left!=null){
                pNode = pNode.left;
                System.out.println(pNode);
            }
        }else{
            return pNode;
        }
        return pNode;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }

	@Override
	public String toString() {
		return "TreeLinkNode [val=" + val +"]";
	}
}
