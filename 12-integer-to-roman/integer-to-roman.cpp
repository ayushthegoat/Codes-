class Solution {
public:
    string intToRoman(int num) {
         vector<int> arr ={1000,900,500,400,100,90,50,40,10,9,5,4,1};
         vector<string> ch = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

         string res="";

         int i=0;
         while(num>0){
            int times=num/arr[i];
              while(times-->0){
                  res+=ch[i];
              }
              num=num%arr[i];
              i++;
         }
         return res;
    }
};