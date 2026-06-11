class Solution {

    public String encode(List<String> strs) {
        List<Integer> lens = new ArrayList<>();
        for(String str : strs) {
            lens.add(str.length());
        }

        StringBuilder sb = new StringBuilder();
        for(int len : lens) {
            sb.append(len).append(',');
        }

        sb.append('#');
        for(String str : strs) {
            sb.append(str);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        int i = 0;
        while(str.charAt(i) != '#') {
            i++;
        }
        String strLens = str.substring(0, i);
        i++;
        String undecoded = str.substring(i, str.length());

        List<String> strs = new ArrayList<>();
        List<Integer> lenStrs = new ArrayList<>();
        
        i = 0;
        while(i < strLens.length()) {
            String lenStr = "";
            while(strLens.charAt(i) != ',') {
                lenStr += strLens.charAt(i);
                i++;
            }
            lenStrs.add(Integer.parseInt(lenStr));
            i++;
        }

        i = 0;

        for(int len : lenStrs) {
            strs.add(undecoded.substring(i, i + len));
            i += len;
        }

        return strs;
    }
}
