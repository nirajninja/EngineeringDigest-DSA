class Solution {

    List<String> ans = new ArrayList<>();

    public void solve(int ind, String s, List<String> wordDict, HashMap<String, Integer> mp, String l) {

        if (ind == s.length()) {
            ans.add(l);
            return;
        }

        for (int i = ind; i < s.length(); i++) {
            String a = s.substring(ind, i + 1);
            if (mp.get(a) != null) {
                // l.add(a);
                if (i + 1 == s.length()) {
                    solve(i + 1, s, wordDict, mp, l + a);

                } else {
                    solve(i + 1, s, wordDict, mp, l + a + " ");
                }
            }

        }

    }

    public List<String> wordBreak(String s, List<String> wordDict) {

        // ok.
        HashMap<String, Integer> mp = new HashMap<>();
        for (int i = 0; i < wordDict.size(); i++) {
            mp.put(wordDict.get(i), 1);
        }
        String l = "";
        solve(0, s, wordDict, mp, l);
        return ans;
    }
}
