class Solution {

    class Node {
        char leftChar;
        char rightChar;
        int length;
        int prefix;
        int suffix;
        int best;

        Node(char leftChar, char rightChar,
             int length, int prefix, int suffix, int best) {
            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.length = length;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
        }
    }

    Node[] tree;
    String s;

    public int[] longestRepeating(
            String s,
            String queryCharacters,
            int[] queryIndices
    ) {
        this.s = s;

        int n = s.length();
        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int k = queryIndices.length;
        int[] answer = new int[k];

        for (int i = 0; i < k; i++) {
            int index = queryIndices[i];
            char newChar = queryCharacters.charAt(i);

            update(1, 0, n - 1, index, newChar);

            answer[i] = tree[1].best;
        }

        return answer;
    }

    private void build(int node, int left, int right) {
        if (left == right) {
            char c = s.charAt(left);

            tree[node] = new Node(
                    c, c,
                    1, 1, 1, 1
            );

            return;
        }

        int mid = (left + right) / 2;

        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
    private void update(int node,int left,int right,int index,char newChar) {
        if (left == right) {
            tree[node] = new Node( newChar, newChar, 1, 1, 1, 1);
            return;
        }
        int mid = (left + right) / 2;
        if (index <= mid) update(node * 2, left, mid, index, newChar);
        else update(node * 2 + 1, mid + 1, right, index, newChar);
        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }
    private Node merge(Node left, Node right) {
        int length = left.length + right.length, prefix = left.prefix, suffix = right.suffix, best = Math.max(left.best, right.best);
        if (left.rightChar == right.leftChar) {
            if (left.prefix == left.length) prefix = left.length + right.prefix;
            if (right.suffix == right.length) suffix = right.length + left.suffix;
            best = Math.max( best, left.suffix + right.prefix);
        }
        return new Node(left.leftChar, right.rightChar, length, prefix, suffix, best);
    }
}