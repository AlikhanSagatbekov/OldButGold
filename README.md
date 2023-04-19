## Assignment 2
Create a file and implement all mothods ftom MyList to MyArrayList and MyLinkedList.

Create a constructor.

private int size = 0; private T[] arr;

public MyArrayList() {
    this.arr = (T[]) new Comparable[10];
    this.size = 0;
}
start adding methods.

added the function contains. This func check if an object is in array.

added a new func increaseBuffer to increase the size of an array.

added a func add item. Adds a new element to the end of the array.

added a func add index. Add new element att a specific index, moving the rest.

added the func "remove". This func need to delete item in arr.

added the new func validIndex. this function need to check if the index is valid.

added the func remove index. this method shifts all the elements by one and the element to delete is overwritten.

added the func cleare. this func completely clears the array.

added the func get. This func retrieves any specified element from the array.

added the func indexOf. This func finds the index of an element in the array.

added the func LastindexOf. This func if an element in the array is under two elements, it outputs the one that stands last.

added the func sort. Its a simple bubble sort. need to sort elements in array.

lets go to class MyLinkedList

Create a constructor

Create a inner class. keeps the elements in itself

add method contains. finding the certain element in the linked list

adding the element in the end of the linked list with method "add"

adding method add to index. This method need to add the element by index.

added method remove. This method removing the first appearance of the object.

added method clear. This method deleting the linked list

added method get. This metgod getting the element by index

added method indexOF. This method returns the index of the first appearance of the object.

added method LastindexOf. This metgod returning the last instance of the object in the List.

added method sort. This method sorting the linked list using the bubble sort and changing the data itself. double-checking the size of the array.

Create new function printList. Printing the Linked list in order. the temporary node to access all the nodes. looping through all the values.

chec methods in main# OldButGold
