public class GenericStack {

    static class CustomStack<T> {

        int capacity, top = -1;
        T[] nums;

        CustomStack(int capacity) {
            this.capacity = capacity;
            nums = (T[]) new Object[this.capacity];
        }

        boolean isEmpty() {
            return top == -1;
        }

        boolean isFull() {
            return top == capacity - 1;
        }

        T peek() throws Exception {
            if (isEmpty()) throw new Exception("Stack is empty!");
            return nums[top];
        }

        void push(T data) throws Exception {
            if (isFull()) throw new Exception("Stack overflow!");
            nums[++top] = data;
        }

        T pop() throws Exception {
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
        CustomStack<Integer> stack = new CustomStack<>(10);
        System.out.println(stack.isEmpty() ? "Stack is empty!" : "Stack is non-empty.");
        System.out.println(stack.isFull() ? "Stack is full!" : "Stack is not full.");
        stack.push(5);
        stack.push(1);
        stack.push(9);
        stack.push(0);
        stack.print();
        stack.push(4);
        System.out.println("Peek element: " + stack.peek());
        stack.push(7);
        stack.push(3);
        stack.push(2);
        stack.push(6);
        stack.push(8);
        System.out.println("Current stack size: " + stack.size());
        System.out.println(stack.isFull() ? "Stack is full!" : "Stack is not full.");
        System.out.println(stack.isEmpty() ? "Stack is empty!" : "Stack is non-empty.");
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
        System.out.println();
        System.out.println(stack.isEmpty() ? "Stack is empty!" : "Stack is non-empty.");
    }
}
