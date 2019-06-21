package com.luhanlin.algorithms.offer.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 树的遍历
 * @author: Mr.Lu
 * @create: 2019-06-21 11:14
 **/
public class BinTree {
    private char date;
    private BinTree lchild;   //左孩子
    private BinTree rchild;   //右孩子

    private BinTree(char c ){
        date = c;
    }

    //先序遍历 递归实现  节点 - 左孩子 - 右孩子
    public static void preOrder1(BinTree t){
        if(t != null){
            System.out.print(t.date);
            preOrder1(t.lchild);
            preOrder1(t.rchild);
        }
    }

    //中序遍历 递归实现 左孩子  - 根结点 - 右孩子
    public static void InOrder2(BinTree t){
        if(t != null){
            InOrder2(t.lchild);
            System.out.print(t.date);
            InOrder2(t.rchild);
        }
    }

    //后序遍历  递归实现  左孩子 - 右孩子 - 根结点
    public static void PostOrder3(BinTree t){
        if(t!=null)
        {
            PostOrder3(t.lchild);
            PostOrder3(t.rchild);
            System.out.print(t.date);
        }
    }

    /*前序非递归实现    节点 - 左孩子 - 右孩子
     1)访问结点P，并将结点P入栈;
     2)判断结点P的左孩子是否为空，若为空，则取栈顶结点并进行出栈操作，并将栈顶结点的右孩子置为当前的结点P，
              循环至1);若不为空，则将P的左孩子置为当前的结点P;
     3)直到P为NULL并且栈为空，则遍历结束。
     */

    public static void preOrder1_1(BinTree t){
        Stack<BinTree> s = new Stack<BinTree>();
        while(t != null || !s.empty()){       //只要满足节点非空或则栈为非空，就要不断遍历

            while(t !=null ){                 //压入所有左孩子节点，压入前输出
                System.out.print(t.date);
                s.push(t);
                t = t.lchild;
            }
            if(!s.empty()){        //左孩子都搞定了，从栈顶取出一个节点，指向它的右孩子，继续前面while循环
                t = s.pop();
                t = t.rchild;
            }
        }
        System.out.println();
    }
    public static void preOrder1_2(BinTree t){
        Stack<BinTree> stack = new Stack<BinTree>();
        if(t!=null)
        {
            stack.push(t);
            while(!stack.empty())
            {
                t = stack.pop();
                System.out.print(t.date);
                if(t.rchild!=null)         //先把右孩子压入栈，利用下压栈的特性
                    stack.push(t.rchild);
                if(t.lchild!=null)
                    stack.push(t.lchild);
            }
        }
    }

    /*中序非递归的实现  左孩子  - 根结点 - 右孩子
     * 访问任意一节点p，若其左孩子非空，p入栈，且p的左孩子作为当前节点，然后在对其进行同样的处理
     * 若其左孩子为空，则输出栈顶点元素并进行出栈操作，访问该栈顶的节点的右孩子
     * 直到p为null并且栈为空则遍历结束
     */
    public static void InOrder2_1(BinTree t){
        Stack<BinTree> s = new Stack<BinTree>();
        while(t != null || !s.empty()){
            while(t !=null){           //和前序的非递归有点像
                s.push(t);
                t = t.lchild;           //一路指向左孩子
            }
            if(! s.empty()){
                t = s.pop();              //取栈顶元素并输出，并指向右孩子
                System.out.print(t.date);
                t = t.rchild;
            }
        }
        System.out.println();
    }

    /*后序非递归实现  这个有难度  因为要保证左孩子和右孩子都已经被访问过了才访问根节点
     * 对于任一节点p,先入栈，然后沿着其左子树往下收索，直到没有左子树的节点，此时该节点入栈
     * 但此时不能进行出栈访问，要检查右孩子，所以接下来一相同的规则进行处理，当访问其右孩子时，
     * 该节点又出现在栈顶，此时就可以出栈访问，这样就保证了正确的访问顺序，这个过程中，
     * 每个节点都两次出现在栈顶，只有在第二次出现在栈顶的时候才能访问它， 因此有必要设置两个栈
     */
    public static void PostOrder3_1(BinTree t){
        Stack<BinTree> s = new Stack<BinTree>();
        Stack<Integer> s2 = new Stack<Integer>();
        Integer i = new Integer(1);        //第二个栈有0 1 俩元素，1表示第二次访问，0,表示第一次访问
        while(t!=null || !s.empty()){
            while(t!=null){               //压入左孩子
                s.push(t);
                s2.push(new Integer(0));
                t = t.lchild;
            }
            //peek查看堆栈顶部的对象，但不从堆栈中移除它。
            while(!s.empty() && s2.peek().equals(i)){  //有两次访问的记录了，就出栈且输出啦，俩栈是同步pop的
                s2.pop();
                System.out.print(s.pop().date);
            }
            if(!s.empty()){         //第二次访问了，栈2的元素置为1，这回要指向右孩子
                s2.pop();
                s2.push(new Integer(1));
                t = s.peek();
                t = t.rchild;
            }
        }
    }
    /*
     * 先扫描跟节点的所有左节点并入栈，接着将栈顶元素出栈，
     * 再扫描该节点的右孩子节点并入栈，扫描右孩子的所有左节点并入栈，当一个节点的左右孩子均被访问后在访问该节点，
     * 这里用一个初始值为null的节点表示右子树刚刚被访问的
     * 一直到栈为空，这里的难点是如何判断右孩子已经被访问过了
     * 个人觉得这个构造真的是太赞了！！
     */
    public static void PostOrder3_2(BinTree t){
        BinTree q = null;
        Stack<BinTree> stack = new Stack<BinTree>();
        while(t!=null)
        {
            while(t.lchild!=null)            //先左子树入栈,注意:这里最左节点（叶子）没有入栈，后面才入栈
            {
                stack.push(t);
                t = t.lchild;
            }
            while(t.rchild==null || t.rchild ==q )
            {
                System.out.print(t.date);   //当前节点无右孩子或者右孩子已经输出
                q = t;                      //用来记录上一个节点
                if(stack.empty())
                    return ;               //栈为空时，就结束程序
                t = stack.pop();           //节点出栈
            }
            stack.push(t);       //！奇葩 1、叶子节点入栈，指向的r.child是null 2、不满足while条件时，处理右孩子
            t = t.rchild;
        }
    }

    public static void PostOrder3_3(BinTree t){
        BinTree node = t, prev = t;
        Stack<BinTree> stack = new Stack<BinTree>();
        while(node != null || stack.size()>0)
        {
            while(node!=null)               //压入左孩子
            {
                stack.push(node);
                node = node.lchild;
            }
            if(!stack.empty())
            {
                BinTree temp = stack.peek().rchild;  //记录当前节点的右孩子
                if((temp == null)||temp == prev)
                {
                    node = stack.pop();           //满足俩条件就出栈输出
                    System.out.print(node.date);
                    prev = node;               //标记已经被访问
                    node = null;               //把这个没用的节点置为null.，防止执行上面的while循环
                }
                else{
                    node = temp;
                }
            }
        }
    }
    //栈是用数组实现的后序非递归算法，数组里含有所有的元素
    public static void  PostOrder3_4(BinTree t)
    {
        BinTree st[] = new BinTree[1000];        //用数组实现顺序栈
        int flag,top=-1;                         //栈指针初始化
        BinTree p =t,q;
        do
        {
            while(p!=null)                  //将p的所有左节点入栈
            {
                top++;
                st[top] = p;
                p = p.lchild;
            }
            q = null;                       //q指向栈顶节点的前一个已经访问的节点
            flag = 1;                       //设置flag = 1表示处理栈顶节点
            while(top !=-1 && flag ==1)
            {
                p = st[top];                //取出栈顶的元素
                if(p.rchild==q)             //右孩子不存在或者右孩子已经被访问，访问之
                {
                    System.out.print(p.date);
                    top--;
                    q=p;                    //q指向刚刚被访问的节点
                }
                else
                {
                    p = p.rchild;           //p指向右孩子节点
                    flag =0;                //flag=0表示栈顶节点处理完毕
                }
            }
        }while(top!=-1);                       //栈不为空时循环
        System.out.println();
    }

    /*广度优先遍历树,又叫层次遍历
     * 1.首先将根节点放入队列中。
       2.当队列为非空时，循环执行步骤3到步骤5，否则执行6；
       3.出队列取得一个结点，访问该结点；
       4.若该结点的左子树为非空，则将该结点的左子树入队列；
       5.若该结点的右子树为非空，则将该结点的右子树入队列；
       6.结束。
     */
    /*
     * 补充：队列是什么，提到队列，就要想到先进先进先出，即为先进先出队列，先进来的人先服务，我们日常生活
     * 排队时不是先到的人先接受服务么？
     */
    public static void BFSOrder(BinTree t)
    {
        if(t==null) return ;
        Queue<BinTree> queue = new ArrayDeque<BinTree>();
        //队列小知识：使用offer和poll优于add和remove之处在于它们返回值可以判断成功与否，而不抛出异常
        queue.offer(t);              //进入队列
        while(!queue.isEmpty())
        {
            t=queue.poll();           //当前节点出队列
            System.out.print(t.date);
            if(t.lchild!=null)              //当前节点左孩子去排队，在前面哦
                queue.offer(t.lchild);
            if(t.rchild!=null)            //右孩子排第二
                queue.offer(t.rchild);
        }
    }
    public static void main(String[] args) {
        BinTree b1 = new BinTree('a');
        BinTree b2 = new BinTree('b');
        BinTree b3 = new BinTree('c');
        BinTree b4 = new BinTree('d');
        BinTree b5 = new BinTree('e');
        BinTree b6 = new BinTree('f');
        BinTree b7 = new BinTree('g');

        /**
         *      a
         *    /   \
         *   b     c
         *  / \   / \
         * d   e f   g
         */
        b1.lchild = b2;
        b1.rchild = b3;
        b2.lchild = b4;
        b2.rchild = b5;
        b3.lchild = b6;
        b3.rchild = b7;

        BinTree.preOrder1(b1);
        System.out.println();

        BinTree.preOrder1_1(b1);
        System.out.println();

        BinTree.InOrder2(b1);
        System.out.println();
        BinTree.InOrder2_1(b1);
        System.out.println();

        BinTree.PostOrder3(b1);
        System.out.println();

        BinTree.PostOrder3_1(b1);
        System.out.println();
        BinTree.PostOrder3_2(b1);
        System.out.println();
        BinTree.PostOrder3_3(b1);
        System.out.println();
        BinTree.PostOrder3_4(b1);
        System.out.println();

        BinTree.BFSOrder(b1);
        System.out.println();
    }
}
