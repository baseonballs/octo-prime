package io.octoprime.algo.ds.queue;

public class Stack {

    private static int STACK_EMPTY = -1;

    private int _size;
    private int[] _arr;
    private int _top;

    /**
     * constructor to create stack with size
     *
     * @param size
     */
    public Stack(int size) {
        this._size = size;
        this._arr = new int[_size];
        this._top = STACK_EMPTY;
    }

    /**
     * This method adds new entry to the _top
     * of the stack
     *
     * @param entry
     * @throws Exception
     */
    public void push(int entry) throws Exception {
        if (this.isStackFull()) {
            throw new Exception("Stack is already full. Can not add element.");
        }
        System.out.println("Adding: " + entry);
        this._arr[++_top] = entry;
    }

    /**
     * This method removes an entry from the
     * _top of the stack.
     *
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if (this.isStackEmpty()) {
            throw new Exception("Stack is empty. Can not remove element.");
        }
        int entry = this._arr[_top--];
        System.out.println("Removed entry: " + entry);
        return entry;
    }

    /**
     * This method returns _top of the stack
     * without removing it.
     *
     * @return
     */
    public int peek() {
        return _arr[_top];
    }

    /**
     * This method returns true if the stack is
     * empty
     *
     * @return
     */
    public boolean isStackEmpty() {
        return (_top == STACK_EMPTY);
    }

    /**
     * This method returns true if the stack is full
     *
     * @return
     */
    public boolean isStackFull() {
        return (_top == _size - 1);
    }

    public static void main(String[] args) {
        Stack stack = new Stack(5);
        try {
            stack.push(4);
            stack.push(8);
            stack.push(3);
            stack.push(89);
            stack.pop();
            stack.push(34);
            stack.push(45);
            stack.push(78);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
            stack.pop();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
