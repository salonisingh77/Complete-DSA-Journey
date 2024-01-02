/**
# Approach

Start with the second node (a) since the first node is guaranteed to be 0.
Iterate through the linked list using a while loop.
For each section between consecutive 0's, calculate the sum of values.
Create a new node with the sum value and connect it to the modified list.
Move the pointers accordingly to continue the iteration.
Return the head of the modified linked list (skipping the dummy node).
This approach effectively merges nodes between consecutive 0's into a single node with the sum of their values.

# Complexity
**- Time complexity:**
- The code iterates through each node in the linked list exactly once.
- The inner while loop, which sums up the values between consecutive 0's, also runs in linear time.
- Therefore, the overall time complexity is O(n), where n is the number of nodes in the linked list.

**- Space complexity:**
- The space complexity is O(1) since the extra space used is constant regardless of the size of the input.
- The code uses a constant amount of space to store variables such as a, temp, sum, and newNode.
- It does not use any additional data structures that scale with the input size.

**In summary:**

Time Complexity: O(n)
Space Complexity: O(1)

# Code
```
**/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        // Initialize a pointer 'a' to the second node in the list
        ListNode a = head.next;
        // Initialize a temporary pointer 'temp' to the head of the list
        ListNode temp = head;

        // Iterate while 'a' is not null
        while (a != null) {
            // Initialize a variable 'sum' to store the sum of values between consecutive 0's
            int sum = 0;

            // Iterate while the value of 'a' is not 0
            while (a.val != 0) {
                // Add the value of 'a' to the sum
                sum += a.val;
                // Move 'a' to the next node
                a = a.next;
            }

            // Create a new node with the sum value
            ListNode newNode = new ListNode(sum);
            
            // Connect the new node to the current node in the modified list
            temp.next = newNode;

            // Move 'temp' to the newly added node
            temp = temp.next;

            // Move 'a' to the next node after the 0
            a = a.next;
        }

        // Return the head of the modified linked list (skipping the dummy node)
        return head.next;
    }
}
```
