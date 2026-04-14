class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        List<Integer> len = new ArrayList<>();
        for(String str : strs) {
            len.add(str.length());
        }
        for(int n : len) {
            sb.append(n).append(',');
        }
        sb.append('#');
        for(String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(str.charAt(i) != '#') {
            sb.append(str.charAt(i++));
        }
        i++;
        String lenStr = sb.toString();
        String undecoded = str.substring(i, str.length());
        List<Integer> len = new ArrayList<>();
        i = 0;
        int j = 0;
        while(i < lenStr.length()) {
            j = i;
            while(lenStr.charAt(j) != ',') {
                j++;
            }
            len.add(Integer.parseInt(lenStr.substring(i, j)));
            i = j+1;
        }
        List<String> ans = new ArrayList<>();
        i = 0;
        for(int n : len) {
            ans.add(undecoded.substring(i, i+n));
            i += n;
        }
        return ans;
    }
}
