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

    /// example inputs:["5","2","C","D","+"], ["-2", "5", "0", "D", "+"],  ["5", "2", "C", "D", "+", "9", "+", "+"]
    /// Rules:Integer-->Add this score to stack, "C" (Cancel)-->Remove last valid score, "D" (Double) 👉 Add double of last score,
    /// "+" (Sum)-->Add sum of last two scores
    public static int baseballGame(String[] operations){
        if (operations == null || operations.length == 0) return 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(String o : operations){

            switch (o){
                case "D"->{
                    if (!stack.isEmpty()) stack.push(stack.peek() * 2);
                }
                case "C"->{
                    if (!stack.isEmpty()) stack.pop();
                }
                case "+"->{
                    if (stack.size() >= 2) {
                        int last = stack.pop();
                        int newValue = stack.peek() + last;
                        stack.push(last);
                        stack.push(newValue);
                    }
                }
                default -> stack.push(Integer.parseInt(o));
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
