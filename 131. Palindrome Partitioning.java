class Solution {
    List<List<String>> ans = new ArrayList<>();

    Boolean isPalin(String str) {
        int left = 0;
        int right = str.length() - 1;

        // Check characters from both ends of the string
        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false; // Not a palindrome

            }
            left++;
            right--;
        }
        return true;

    }

    void solve(int ind, String s, List<String> l) {
        if (ind == s.length()) {
            // ans.add( nel);
            ans.add(new ArrayList<String>(l));
            return;
        }

        for (int i = ind ; i < s.length(); i++) {
            if (isPalin(s.substring(ind, i+1))) {
                l.add(s.substring(ind, i+1));
                
                System.out.println(l);
                solve(i+1, s, l);
               l.remove(l.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        // palindrome partionining.
        List<String> l = new ArrayList<>();
        solve(0, s, l);
        return ans;
    }
}
