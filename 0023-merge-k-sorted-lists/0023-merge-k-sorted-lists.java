class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q=new PriorityQueue<>((a, b)->a.val-b.val);
        for (ListNode l : lists) {
            if (l!=null) q.add(l);
        }
        ListNode d=new ListNode(0),c=d;
        while (!q.isEmpty()){
            ListNode n=q.poll();
            c.next=n;
            c=c.next;
            if (n.next != null) q.add(n.next);
        }
        return d.next;
    }
}