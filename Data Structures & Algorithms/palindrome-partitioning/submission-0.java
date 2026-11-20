class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> current = new ArrayList<>();
    
        dfs(s, 0, ans, current);
        return ans;
    }
    public void dfs(String s, int start, List<List<String>> ans, List<String> current){
        if(start == s.length()){
            ans.add(new ArrayList<>(current));
            return;
        }

        for(int i=start;i<s.length();i++){
            String substring = s.substring(start, i+1);

            if(ispalindrome(substring)){
                current.add(substring);
                dfs(s, i+1, ans, current);
                current.remove(current.size()-1);
            } 
        }
    }
    public boolean ispalindrome(String str){
        int left = 0;
        int right = str.length() -1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}