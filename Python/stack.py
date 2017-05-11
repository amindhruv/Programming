class Stack:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return len(self.items) == 0

    def push(self, x):
        self.items.append(x)

    def pop(self):
        return self.items.pop()

    def peek(self):
        return self.items[-1]

    def size(self):
        return len(self.items)


if __name__ == '__main__':
    st = Stack()
    st.push(2)
    st.push(4)
    print(st.peek())
    print(st.size())
    print(st.pop())
    print(st.is_empty())
    print(st.pop())
    print(st.is_empty())
