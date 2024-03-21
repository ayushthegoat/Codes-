class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> qforR=new LinkedList<>();
        Queue<Integer> qforD=new LinkedList<>();
        
        for(int i=0; i<senate.length(); i++){
            if(senate.charAt(i)=='R'){
                qforR.offer(i);
            }else{
                qforD.offer(i);
            }
        }
        while(!qforR.isEmpty() && !qforD.isEmpty()){
            int i=qforR.poll();
            int j=qforD.poll();

            if(i<j){
                qforR.offer(i+senate.length());
            }else{
                qforD.offer(j+senate.length());
            }
          
        }
        return qforR.isEmpty()?"Dire" : "Radiant";

    }
}