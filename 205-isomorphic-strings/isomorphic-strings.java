class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character , Character> map=new LinkedHashMap();
         
        for(int i=0;i<s.length();i++){
            char S=s.charAt(i);
            char T=t.charAt(i);

            if((map.containsKey(S) && map.get(S)!=T) ||
            map.containsValue(T) && !map.containsKey(S)){
            return false;
        }
         map.put(S,T);
        }
        return true;

    }
}