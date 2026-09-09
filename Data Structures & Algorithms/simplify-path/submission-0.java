class Solution {
    public String simplifyPath(String path) {
        Stack<String> files = new Stack<>();
        
        int i = 1;
        while(i < path.length()) {
            int j = i;

            while(j < path.length() && path.charAt(j) != '/') {
                j++;
            }

            String file = path.substring(i, j);
            i = j + 1;
            // System.out.println(file);
            if(file.equals("..")) {
                if(!files.isEmpty()) {
                    files.pop();
                }
                continue;
            }
            if(!file.equals(".") && !file.equals("")) {
                files.push(file);
            }
        }
        
        String absPath = "";
        while(!files.isEmpty()) {
            absPath = "/" + files.pop() + absPath;
        }

        return absPath.isEmpty() ? "/" : absPath;
    }
}