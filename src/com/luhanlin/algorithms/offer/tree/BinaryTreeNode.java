//package com.luhanlin.algorithms.offer.tree;
//
///**
// * @description: 二叉树构建
// * @author: Mr.Lu
// * @create: 2019-06-21 13:17
// **/
//public class BinaryTreeNode {
//
//    private int data;
//    private BinaryTreeNode leftNode;
//    private BinaryTreeNode rightNode;
//
//    public BinaryTreeNode(int data) {
//        this.data = data;
//    }
//
//    public static BinaryTreeNode construct(int[] pre, int[] inr, int length){
//        if (pre == null || inr == null || length <= 0) {
//            return null;
//        }
//
//        return constructCore(pre, 0, length - 1, inr, 0, length - 1);
//    }
//
//    private static BinaryTreeNode constructCore(int[] pre, int preStart, int preEnd, int[] inr, int inrStart, int inrEnd) {
//        // 前序的第一个节点为root节点
//        BinaryTreeNode root = new BinaryTreeNode(pre[preStart]);
//
//        // 在中序数组中找到root节点下标
//        int rootIndex = inrStart;
//        while (rootIndex < inrEnd && inr[rootIndex] != root.data) {
//            ++rootIndex;
//        }
//
//        // 利用递归循环调用创建子节点
////        if (rootIndex == preEnd && inr[rootIndex] != root.data) {
////            throw new RuntimeException("input invalid");
////        }
//
//        int leftLength = rootIndex - inrStart;
//        if (leftLength > 0) {
//            // 构建左子树
//            root.leftNode = constructCore(pre,preStart + 1, preStart + leftLength, inr, inrStart, inrStart + leftLength -1);
//        }
//
//        if (leftLength < preEnd - preStart) {
//            root.rightNode =  constructCore(pre,preEnd - leftLength, preEnd, inr, rootIndex + 1, inrEnd);
//        }
//
//        return root;
//    }
//
//    public static void main(String[] args) {
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] inr = {4,7,2,1,5,3,8,6};
//
//        BinaryTreeNode node = construct(pre, inr, pre.length);
//
//        preOrder1(node);
//        System.out.println();
//        inOrder2(node);
//        System.out.println();
//        postOrder3(node);
//    }
//
//    //先序遍历 递归实现  节点 - 左孩子 - 右孩子
//    public static void preOrder1(BinaryTreeNode t){
//        if(t != null){
//            System.out.print(t.data);
//            preOrder1(t.leftNode);
//            preOrder1(t.leftNode);
//        }
//    }
//
//    //中序遍历 递归实现 左孩子  - 根结点 - 右孩子
//    public static void inOrder2(BinaryTreeNode t){
//        if(t != null){
//            preOrder1(t.leftNode);
//            System.out.print(t.data);
//            preOrder1(t.leftNode);
//        }
//    }
//
//    //后序遍历  递归实现  左孩子 - 右孩子 - 根结点
//    public static void postOrder3(BinaryTreeNode t){
//        if(t!=null)
//        {
//            preOrder1(t.leftNode);
//            preOrder1(t.leftNode);
//            System.out.print(t.data);
//        }
//    }
//
//}
