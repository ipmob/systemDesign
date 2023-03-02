class Node:
    def __init__(self, data=None):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    def append(self,data):
        new_node = Node(data)
        if self.head is None:
            self.head = new_node
            return
        current_node = self.head 
        while current_node.next:
            current_node = current_node.next
        current_node.next = new_node

    def prepend(self, data):
        new_node = Node(data)
        new_node.next= self.head
        self.head = new_node 

    def delete_node(self, key):
        current_node = self.head 
        if current_node and current_node.data == key :
            self.head = current_node.next
            current_node = None 
            return 
        prev_node = None 
        while current_node  and current_node.data!= key:
            prev_node = current_node
            current_node = current_node.next
        if current_node is None:
            prev_node.next = current_node.next
            current_node = None


    def print_list(self):
        current_node = self.head
        while current_node:
            print(current_node.data)
            current_node = current_node.next

def main():
    linked_list = LinkedList()
    linked_list.append(1)
    linked_list.append(2)
    linked_list.append(3)
    linked_list.prepend(0)
    linked_list.delete_node(1)
    linked_list.print_list()

if __name__ == '__main__':
    main()