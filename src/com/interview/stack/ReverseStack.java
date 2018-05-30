package com.interview.stack;

import java.nio.file.StandardWatchEventKinds;
import java.util.Stack;

/**
 * Reverse a Stack only with recursion
 * 题目:
 * 一个栈依次压入1,2,3,4,5, 那么从栈顶到栈底分别为5,4,3,2,1.
 * 将这个栈转置之后,从栈顶到栈底为为1,2,3,4,5,也就是实现栈中
 * 元素的逆序,只能用函数来实现,不能用其他数据结构.
 * Created by Bob on 15/12/9.
 */
public class ReverseStack {
    /**
     * 移除并返回栈底元素
     *
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        //result为栈顶元素,存放在每一层递归中的一个临时变量(递归过程中执行的逻辑)
        int result = stack.pop();

        //递归终止条件,即回调条件
        if (stack.isEmpty()) {
            //开始回调
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            //回调过程中执行的逻辑
            stack.push(result);
            return last;//
        }
    }

    /**
     * 将栈中的元素在递归的过程中是使用getAndRemoveLastElement在每一层中都
     * 临时存入栈低元素,然后在回调的过程中再push压栈,起到一个转置的作用
     *
     * @param stack
     */
    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    /**
     * 使用for循环来遍历stack
     */
    public static <T> void traverseFor(Stack<T> stack) {
        int sum = stack.size();
        for (int i = 0; i < sum; i++) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 使用递归来实现对栈的遍历
     * 这里实现了栈的正序和逆序的遍历
     *
     * @param stack
     * @param <T>
     */
    public static <T> void traverseRecursion(Stack<T> stack) {
        T i = stack.pop();
        System.out.println(i);
        if (stack.isEmpty()) {
            return;
        }
        traverseRecursion(stack);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        System.out.println(stack.toString());
//        traverseFor(stack);
        traverseRecursion(stack);
    }
}

/**
 * 分析:这里主要讲述了递归的基本使用;
 * 递归一般分为两大步骤:
 * 1.递归 : 这部分代码逻辑会在递归调用语句前边出现,表示在递归自己之前应该执行的逻辑
 * 2.回调 : 它一般会出现在递归调用语句之后,表示递归终止条件被触发之后,在回调的过程中被执行的逻辑.
 * * 至于复杂的递归以及递归更好的应用,需要好好探索
 */