package io.octoprime.algo.ds.queue;

public class DynamicStack {


    private int _size;
    private int[] _arr;
    private int _top;

    /**
     * constructor to create stack with size
     * @param size
     */
    public DynamicStack(int size) {
        this._size = size;
        this._arr = new int[_size];
        this._top = -1;
    }

    /**
     * This method adds new entry to the _top
     * of the stack
     * @param entry
     * @throws Exception
     */
    public void push(int entry){
        if(this.isStackFull()){
            System.out.println(("Stack is full. Increasing the capacity."));
            this.increaseStackCapacity();
        }
        System.out.println("Adding: "+entry);
        this._arr[++_top] = entry;
    }

    /**
     * This method removes an entry from the
     * _top of the stack.
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if(this.isStackEmpty()){
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this._arr[_top--];
        System.out.println("Removed entry: "+entry);
        return entry;
    }

    /**
     * This method returns _top of the stack
     * without removing it.
     * @return
     */
    public long peek() {
        return _arr[_top];
    }

    private void increaseStackCapacity(){

        int[] newStack = new int[this._size *2];
        for(int i = 0; i< _size; i++){
            newStack[i] = this._arr[i];
        }
        this._arr = newStack;
        this._size = this._size *2;
    }

    /**
     * This method returns true if the stack is
     * empty
     * @return
     */
    public boolean isStackEmpty() {
        return (_top == -1);
    }

    /**
     * This method returns true if the stack is full
     * @return
     */
    public boolean isStackFull() {
        return (_top == _size - 1);
    }

    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack(2);
        for(int i=1;i<10;i++){
            stack.push(i);
        }
        for(int i=1;i<4;i++){
            try {
                stack.pop();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
