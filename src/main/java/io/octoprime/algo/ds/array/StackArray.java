package io.octoprime.algo.ds.array;

/**
 * A stack implementation using an arr.
 */
public class StackArray {

    private static int STACK_EMPTY = -1;

    private int _capacity;
    private int[] _arr;
    private int _top;

    /**
     * constructor to create stack with size
     *
     * @param size size of arr
     */
    public StackArray(int size) {
        this._capacity = size;
        this._arr = new int[_capacity];
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
        if (this.isFull()) {
            throw new Exception("StackArray is already full. Can not add element.");
        }
        System.out.println("Adding: " + entry);
        this._arr[++_top] = entry;
    }

    /**
     * This method removes an entry from the
     * _top of the stack.
     *
     * @return int element at top of stack.
     * @throws Exception
     */
    public int pop() throws Exception {
        if (this.isEmpty()) {
            throw new Exception("StackArray is empty. Can not remove element.");
        }
        int entry = this._arr[_top--];
        System.out.println("Removed entry: " + entry);

        return entry;
    }

    /**
     * This method returns _top of the stack
     * without removing it.
     *
     * @return int element at top of stack without removing item from stack.
     */
    public int peek() {
        return _arr[_top];
    }

    /**
     * This method returns true if the stack is
     * empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return (_top == STACK_EMPTY);
    }

    /**
     * This method returns true if the stack is full
     *
     * @return boolean
     */
    public boolean isFull() {
        return (_top == _capacity - 1);
    }

    /**
     * @param args standard arguments for CLI
     */
    public static void main(String[] args) {
        StackArray stack = new StackArray(5);
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
