class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode p=head,c=head.next;
        int i=1,f=-1,l=-1,mn=Integer.MAX_VALUE,mx=-1;

        while (c.next != null) {
            if ((c.val > p.val && c.val > c.next.val) ||
                (c.val < p.val && c.val < c.next.val)) {
                if (f == -1) f = i;
                else {
                    mn = Math.min(mn,i-l);
                    mx =i-f;
                }
                l=i;
            }
            p=c;
            c=c.next;
            i++;
        }

        return mn == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[]{mn, mx};
    }
}