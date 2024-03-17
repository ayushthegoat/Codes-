class Solution {
    public String reverseWords(String s) {
        
        String[] shivi=s.split("\\s+");
        
        StringBuilder res=new StringBuilder("");
        
        for(int i=shivi.length-1;i>=0;i--)
        {
            res.append(" ").append(shivi[i]);

        }

        return res.toString().trim();
     }
}