# Data Structures

## Min Heap

Main property: Minimum value on top.
Get the min element in constant time.

Main methods inside:
- getParent(pos) - pos / 2
- getLeftChild(pos) - 2 * pos
- getRightChild(pos) - 2 * pos + 1
- isLeaf(pos) - is pos b/w [size/2, size]
- minHeapify(pos): If the node is a non-leaf node and greater than either child
    - Find which child is smaller
    - Swap pos with that child
    - Repeat minHeapify until node is not a leaf or is less than both children
- insert(element): Increment pointer and store the element at that index
    - As long as value at current index < value at parent index
    - Swap current index and parent
    - Set current to be the parent index
- minHeap(): Call minHeapify from pos = size/2 to 1
- remove():
    - Get the value at FRONT
    - Set the value at FRONT to be the last element
    - minHeapify(FRONT)
    
    