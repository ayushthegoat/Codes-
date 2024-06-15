public class Solution {
    public int MinMovesToSeat(int[] seats, int[] students) {
         Array.Sort(seats);
         Array.Sort(students);

         int moves = 0;

         int n = seats.Length;
         for(int i=0;i<n;i++){
            moves+= Math.Abs(seats[i] - students[i]);

         }

         return moves;
    }
}