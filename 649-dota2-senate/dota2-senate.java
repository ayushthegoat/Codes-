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
                qforR.offer(i+10000);
            }else{
                qforD.offer(j+10000);
            }
          
        }
        return qforR.isEmpty()?"Dire" : "Radiant";

    }
}