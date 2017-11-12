# CCI Chapter 2 Problem 1
# Remove duplicates from an unsorted linked list. 

# Node class to use for exampes
class node:

    def __init__(self, left, right, value):
        self.left = left
        self.right = right
        self.value = value
    

def removeDuplicates(head):

    temp = head

    while(head.right != None):
        if(temp.value == temp.right.value):
            temp.right = temp.right.right