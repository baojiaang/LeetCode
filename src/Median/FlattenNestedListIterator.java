package Median;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation


interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}

public class FlattenNestedListIterator  {

}
class NestedIterator implements Iterator<Integer> {


   // private List<NestedInteger> nestedList;
    private int size;
    private int curIndex;
  //  private Stack<List<NestedInteger>> s;
    private List<Integer> res;
    public NestedIterator(List<NestedInteger> nestedList) {
     //   this.nestedList = nestedList;
        this.res = new ArrayList<>();
        dfs(nestedList);
        this.size = res.size();
        this.curIndex = -1;
//        this.s = new Stack<>();
//        s.add(nestedList);

    }
    public void dfs(List<NestedInteger> list){
        for(int i = 0; i < list.size(); i++){
            NestedInteger n = list.get(i);
            if(n.isInteger()){
                res.add(n.getInteger());
            }
            else{
                List<NestedInteger> l = n.getList();
                dfs(l);
            }
        }
    }

    @Override
    public Integer next() {
        curIndex++;
     //   NestedInteger n = nestedList.get(curIndex);
//        if(n.isInteger()){
//            return n.getInteger();
//        }
//        else{
//            List<NestedInteger> l = n.getList();
//
//        }
        return res.get(curIndex);
    }

    @Override
    public boolean hasNext() {
        return curIndex+1 < size;
    }
}




