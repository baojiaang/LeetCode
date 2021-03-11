package Easy;

import java.util.Stack;

public class ImplementQueueusingStacks {

}
class MyQueue{
    /** Initialize your data structure here. */
    private Stack<Integer> in;
    private Stack<Integer> out;
    public MyQueue() {
        in = new Stack<>();
        out = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(!out.empty()){
            return out.pop();
        }
        else{
            while(!in.empty()){
                int x = in.pop();
                out.push(x);
            }
            return out.pop();
        }
    }

    /** Get the front element. */
    public int peek() {
        if(!out.empty()){
            return out.peek();
        }
        else{
            while(!in.empty()){
                int x = in.pop();
                out.push(x);
            }
            return out.peek();
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.empty() && out.empty()){
            return true;
        }
        else{
            return false;
        }
    }
}
