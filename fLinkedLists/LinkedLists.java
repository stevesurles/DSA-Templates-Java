package fLinkedLists;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

class ListNode {
  int val;
  ListNode next;

  ListNode() {
    val = 0;
    next = new ListNode();
  }

  ListNode(int x) {
    val = x;
    next = null;
  }
}

class Node {
  int val;
  Node next;
  Node random;

  public Node(int val) {
    this.val = val;
    this.next = null;
    this.random = null;
  }
}

public class LinkedLists {
  public ListNode reverseList(ListNode head) {
    ListNode prev = null;
    var cur = head;

    while (cur != null) {
      var next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    var dummy = new ListNode();
    var tail = dummy;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }
      tail = tail.next;
    }

    if (list1 != null) {
      tail.next = list1;
    }

    if (list2 != null) {
      tail.next = list2;
    }

    return dummy.next;
  }

  public boolean hasCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
      if (fast == slow)
        return true;
      slow = slow.next;
      fast = fast.next.next;
    }
    return false;
  }

  public void reorderList(ListNode head) {
    // 1. find middle
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    // 2. reverse second half
    // disconnect second half
    ListNode second = slow.next;
    slow.next = null; // disconnect second half
    ListNode prev = null;
    while (second != null) {
      ListNode next = second.next;
      second.next = prev;
      prev = second;
      second = next;
    }
    // 3. merge lists
    second = prev;
    ListNode first = head;
    while (second != null) {
      ListNode firstNext = first.next, secondNext = second.next;
      first.next = second;
      second.next = firstNext;
      first = firstNext;
      second = secondNext;
    }
  }

  public ListNode removeNthFromEnd(ListNode head, int n) {
    var dummy = new ListNode(0);
    // start from head previous
    dummy.next = head;
    var l = dummy;
    var r = dummy;
    // 1. advance r n spaces
    while (n-- > 0) {
      r = r.next;
    }
    // 2. advance l and r until r reaches end
    while (r.next != null) {
      l = l.next;
      r = r.next;
    }
    // 3. remove l.next
    l.next = l.next.next;
    return dummy.next;
  }

  public Node copyRandomList(Node head) {
    HashMap<Node, Node> oldToNew = new HashMap<>();
    oldToNew.put(null, null);
    var cur = head;
    while (cur != null) {
      oldToNew.put(cur, new Node(cur.val));
      cur = cur.next;
    }
    cur = head;
    while (cur != null) {
      Node newNode = oldToNew.get(cur);
      newNode.next = oldToNew.get(cur.next);
      newNode.random = oldToNew.get(cur.random);
      cur = cur.next;
    }
    return oldToNew.get(head);
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode tail = dummyHead;
    int carry = 0;

    while (l1 != null || l2 != null || carry != 0) {
      int digit1 = (l1 != null) ? l1.val : 0;
      int digit2 = (l2 != null) ? l2.val : 0;

      int sum = digit1 + digit2 + carry;
      int digit = sum % 10;
      carry = sum / 10;

      ListNode newNode = new ListNode(digit);
      tail.next = newNode;
      tail = tail.next;

      l1 = (l1 != null) ? l1.next : null;
      l2 = (l2 != null) ? l2.next : null;
    }

    ListNode result = dummyHead.next;
    dummyHead.next = null;
    return result;
  }
  
  public int findDuplicate(int[] nums) {
    var slow = nums[0];
    var fast = nums[0];
    do {
      slow = nums[slow];
      fast = nums[nums[fast]];
    } while (slow != fast);

    slow = nums[0];

    while (slow != fast) {
      slow = nums[slow];
      fast = nums[fast];
    }
    return slow;
  }

  class ListNode {
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int capacity;
    Map<Integer, ListNode> dic;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new HashMap<>();
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!dic.containsKey(key)) {
            return -1;
        }

        ListNode node = dic.get(key);
        remove(node);
        add(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (dic.containsKey(key)) {
            ListNode oldNode = dic.get(key);
            remove(oldNode);
        }

        ListNode node = new ListNode(key, value);
        dic.put(key, node);
        add(node);

        if (dic.size() > capacity) {
            ListNode nodeToDelete = head.next;
            remove(nodeToDelete);
            dic.remove(nodeToDelete.key);
        }
    }

    public void add(ListNode node) {
        ListNode previousEnd = tail.prev;
        previousEnd.next = node;
        node.prev = previousEnd;
        node.next = tail;
        tail.prev = node;
    }

    public void remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
