class Solution {
    public int compress(char[] chars) {
            
            int n=chars.length;
            int i=0;
            int j=0;
            while(i<n){
                int count=1;
                while(i+1<n && chars[i]==chars[i+1]){
                    i++;
                    count++;
                }
                chars[j]=chars[i];
                j++;
                if(count>1){
                    String ctr=String.valueOf(count);
                    for(int k=0;k<ctr.length();k++){
                        chars[j++]=ctr.charAt(k);
                    }
                }
                i++;
            }
           return j;
    }
}