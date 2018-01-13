public class QueueWithStacks<T> {
	Stack<T> stackNewest, stackOldest;
	public QueueWithStacks() {
		this.stackNewest = new Stack<>();
		this.stackOldest = new Stack<>();
	}

	public void offer(T val) {
		stackNewest.push(val);
	}

	public T poll() {
		shiftStacks();
		return stackOldest.pop();
	}

	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}

	public boolean isEmpty() {
		return stackNewest.isEmpty() && stackOldest.isEmpty();
	}

	public T size() {
		return stackNewest.size() + stackOldest.size();
	}

	private void shiftStacks() {
		if (stackOldest.isEmpty()) {
			while (!stackNewest.isEmpty())
				stackOldest.push(stackNewest.pop());
		}
	}
}
