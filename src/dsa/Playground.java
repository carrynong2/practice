package dsa;

import java.util.List;

public class Playground {
    static void main() {
//        stackExample();
//        queueExample();
        BinarySearchExample();
    }

    private static class OwnQueue {
        Node head;
        Node tail;
        OwnQueue() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }
        // enqueue
        void enqueue(int data) {
            Node newNode = new Node(data);
            Node nextHead = head.next;
            newNode.next = head.next;
            nextHead.prev = newNode;
            head.next = newNode;
            newNode.prev = head;
        }
        // dequeue
        int dequeue() {
            if (this.tail.prev.data == 0) {
                throw new RuntimeException("Queue is empty");
            }
            var prevTail = this.tail.prev;
            this.tail.prev = prevTail.prev;
            prevTail.prev.next = this.tail;
            prevTail.next = null;
            prevTail.prev = null;
            return prevTail.data;
        }
        // peek
        int peek() {
            if (this.tail.prev.data == 0) {
                throw new RuntimeException("Queue is empty");
            }
            return this.tail.prev.data;
        }
    }
    private static void BinarySearchExample() {
        int[] nums = {1, 4, 5, 8, 6};
        int target = 5;
        System.out.println(BinarySearch.iterative(nums, target));
    }
    private static void queueExample() {
        var queue = new OwnQueue();
        var nums = List.of(1, 4, 5, 8, 6);
        for (int num : nums) {
            queue.enqueue(num);
        }
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.dequeue()); // Exception thrown
    }
    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }
    private static void stackExample() {
        OwnStack stack = new OwnStack(5);
        var nums = List.of(1, 4, 5, 8, 6);
        for (int num : nums) {
            stack.push(num);
        }
        System.out.println(stack.peek());
        var targetPop = 2;
        while (targetPop-- > 0) {
            System.out.println(stack.pop());
        }
        System.out.println(stack.peek());
    }
    private static class OwnStack {
        private int[] stack;
        private int top;
        private int maxSize;
        public OwnStack(int size) {
            this.maxSize = size;
            this.stack = new int[maxSize];
            this.top = -1;
        }
        // push
        void push(int value) {
            if (top == maxSize - 1) {
                throw new StackOverflowError("Stack is full");
            }
            this.stack[++top] = value;
        }
        // pop
        int pop() {
            if (top == -1) {
                throw new StackUnderFlowError("Stack is empty");
            }
            return this.stack[top--];
        }
        // peek
        int peek() {
            if (top == -1) {
                throw new StackUnderFlowError("Stack is empty");
            }
            return this.stack[top];
        }
    }
}
