class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] aux=new int[1000000];
        for(int i=0;i<nums1.length;i++){
            aux[nums1[i]]++;
        }
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0;i<nums2.length;i++){
            if(aux[nums2[i]]>=1){
               list.add(nums2[i]);
               aux[nums2[i]]=0;
            }
        }
        Integer[] r=list.toArray(new Integer[0]);
        int[] result=new int[r.length];
        for(int i=0;i<r.length;i++){
            result[i]=r[i];
        }
        return result;
    }
}