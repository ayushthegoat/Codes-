class Solution {
    public int compress(char[] chars) {
            
           StringBuilder sb=new StringBuilder();
           
           int freq=1;

            for(int i=0;i<chars.length;i++){
             char c=chars[i];
                while(i<chars.length-1 && chars[i]==chars[i+1]){
                    freq++;
                    i++;
                }
                sb.append(c);
                if(freq>1){
                    sb.append(freq);
                }
                freq=1;
           }
           char[] resultant=sb.toString().toCharArray();
           for(int k=0;k<resultant.length;k++){
            chars[k]=resultant[k];
           }
           return resultant.length;
    }
}