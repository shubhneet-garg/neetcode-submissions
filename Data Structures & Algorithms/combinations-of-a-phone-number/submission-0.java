class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0){
            return ans;
        }

        String[] mapping = {"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(digits, 0, new StringBuilder(), mapping, ans);
        return ans;
    }
    public void backtrack(String digits, int index, StringBuilder current, String[] mapping, List<String> ans){
        if(index == digits.length()){
            ans.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) -'0';
        String letter = mapping[digit];

        for(int i=0;i<letter.length();i++){
            current.append(letter.charAt(i));
            backtrack(digits, index+1, current, mapping, ans);
            current.deleteCharAt(current.length() - 1);
        }
    }
}