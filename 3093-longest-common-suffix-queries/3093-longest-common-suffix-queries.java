class Solution {

    class Node {

        Node[] next = new Node[26];

        int idx;

        Node() {
            idx = -1;
        }
    }

    class Trie {

        Node root = new Node();

        String[] words;

        Trie(String[] words) {
            this.words = words;
        }
        private void update(Node node, int idx) {
            if(node.idx == -1 ||
               words[idx].length() < words[node.idx].length() ||
               (words[idx].length() == words[node.idx].length()
                && idx < node.idx)) {

                node.idx = idx;
            }
        }

        public void insert(String word, int idx) {

            Node temp = root;

            update(temp, idx);

            for(int i = word.length() - 1; i >= 0; i--) {

                int pos = word.charAt(i) - 'a';

                if(temp.next[pos] == null) {
                    temp.next[pos] = new Node();
                }

                temp = temp.next[pos];

                update(temp, idx);
            }
        }

        public int search(String word) {

            Node temp = root;

            for(int i = word.length() - 1; i >= 0; i--) {

                int pos = word.charAt(i) - 'a';

                if(temp.next[pos] == null) {
                    break;
                }

                temp = temp.next[pos];
            }

            return temp.idx;
        }
    }
    public int[] stringIndices(String[] wordsContainer,
                               String[] wordsQuery) {

        Trie trie = new Trie(wordsContainer);
        for(int i = 0; i < wordsContainer.length; i++) {
            trie.insert(wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for(int i = 0; i < wordsQuery.length; i++) {
            ans[i] = trie.search(wordsQuery[i]);
        }
        return ans;
    }
}