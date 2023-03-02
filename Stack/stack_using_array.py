class Stack:
    def __init__(self):
        self.items = []

    def push(self, item): # o(1)
        self.items.append(item)

    def pop(self): # o(1)
        return self.items.pop()

    def peek(self): # o(1)
        return self.items[-1]

    def isEmpty(self): # o[(1)]
        return len(self.items) == 0

    def size(self): # o(1)
        return len(self.items)
    
def main():
    s = Stack()
    s.push(1)
    s.push(2)
    s.push(3)
    print(s.peek())  # Output: 3
    print(s.pop())   # Output: 3
    print(s.pop())   # Output: 2
    print(s.size())  # Output: 1
    print(s.isEmpty()) # Output: False


if __name__ == "__main__":
    main()


