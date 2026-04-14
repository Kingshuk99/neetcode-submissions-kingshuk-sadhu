class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str : strs) {
            int[] chars = new int[26];
            for(char ch : str.toCharArray()) {
                chars[ch - 'a']++;
            }
            String s = Arrays.toString(chars);
            if(!anagrams.containsKey(s)) {
                anagrams.put(s, new ArrayList<>());
            }
            anagrams.get(s).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}
