package org.example.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {


    /// example inputs:"{[()]}", "()[]{}"
    /// Valid Parentheses
    public static boolean validParentheses(String s){
        if(s==null||s.length()==0 || s.length()%2!=0) return false;

        Deque<Character> stack = new ArrayDeque<>();
        char arr[] = s.toCharArray();

        for(int i=0;i<arr.length;i++){
            if(arr[i]=='(' || arr[i]=='{' || arr[i]=='['){
                stack.push(arr[i]);
            }
            else{
                if(stack.isEmpty()){return false;}

                    if(arr[i]==')' && stack.peek()=='(' ||
                            arr[i]=='}' && stack.peek()=='{' ||
                            arr[i]==']' && stack.peek()=='[')
                    {
                        stack.pop();
                    }
                    else return false;
            }
        }
        return stack.isEmpty();
    }
}
