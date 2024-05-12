package com.murari.striverheet.stackandqueue;

public class StackImpl {

    private final int size= 1000;
    private final int[] arr= new int[size];
    private int top=-1;

    void push(int num){
        top++;
        arr[top]=num;
    }

    int pop(){
        int result= arr[top];
        top--;
        return result;
    }

    int top(){
        return arr[top];
    }

    int size(){
        return top+1;
    }

    public static void main(String[] args) {
        StackImpl stack= new StackImpl();
        stack.push(1);
        stack.push(5);
        stack.pop();
        stack.push(3);
        System.out.println("top :"+ stack.top());
        System.out.println("size :"+ stack.size());
    }
}
