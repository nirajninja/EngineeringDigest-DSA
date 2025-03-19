class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord)) {
            return 0;
        }
        // visited
        HashMap<String, Integer> vis = new HashMap<>();

        HashMap<String, Integer> mp = new HashMap<>();
        for (String words : wordList) {
            mp.put(words, 1);
            vis.put(words, 0);
        }

        // solve(beginWord, endWord, mp, vis);
        // queue se kru . BFS.
        // how.

        Queue<String> q = new LinkedList<>();
        vis.put(beginWord, 1);
        q.add(beginWord);
        int cnt = 1;
        while (q.size() > 0) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                String str = q.peek();
                q.poll();
                if (str.equals(endWord)) {
                    return cnt;
                }
                char[] chs = str.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    chs = str.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chs[j] = ch;
                        String temp = String.valueOf(chs);
                        if (mp.get(temp) != null && vis.get(temp) == 0) {
                            vis.put(temp, 1);
                            q.add(temp);
                        }
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
}
