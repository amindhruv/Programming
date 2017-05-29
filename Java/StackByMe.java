public class StackByMe {

    static class IntStack {

        int capacity, top = -1;
        int[] nums;

        IntStack(int capacity) {
            this.capacity = capacity;
            nums = new int[this.capacity];
        }

        boolean isEmpty() {
            return top == -1;
        }

        boolean isFull() {
            return top == capacity - 1;
        }

        int peek() throws Exception {
            if (isEmpty()) throw new Exception("Stack is empty!");
            return nums[top];
        }

        void push(int data) throws Exception {
            if (isFull()) throw new Exception("Stack overflow!");
            nums[++top] = data;
        }

        int pop() throws Exception {
            if (isEmpty()) throw new Exception("Stack is empty!");
            return nums[top--];
        }

        void print() {
            System.out.print("Current stack content: ");
            int current = top;
            while (current >= 0)
                System.out.print(nums[current--] + " ");
            System.out.println();
        }

        int size() {
            return top + 1;
        }
    }

    public static void main(String[] args) throws Exception {
        IntStack intStack = new IntStack(10);
        System.out.println(intStack.isEmpty() ? "Stack is empty!" : "Stack is non-empty.");
        System.out.println(intStack.isFull() ? "Stack is full!" : "Stack is not full.");
        intStack.push(5);
        intStack.push(1);
        intStack.push(9);
        intStack.push(0);
        intStack.print();
        intStack.push(4);
        System.out.println("Peek element: " + intStack.peek());
        intStack.push(7);
        intStack.push(3);
        intStack.push(2);
        intStack.push(6);
        intStack.push(8);
        System.out.println("Current stack size: " + intStack.size());
        System.out.println(intStack.isFull() ? "Stack is full!" : "Stack is not full.");
        System.out.println(intStack.isEmpty() ? "Stack is empty!" : "Stack is non-empty.");
        while (!intStack.isEmpty())
            System.out.print(intStack.pop() + " ");
        System.out.println();
        System.out.println(intStack.isEmpty() ? "Stack is empty!" : "Stack is non-empty.");
    }
}