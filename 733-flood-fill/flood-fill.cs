public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {

        int n = image.Length;
        int m = image[0].Length;
        
        var directions = new List<(int, int)> {
            (0,1),(1,0),(-1,0),(0,-1)
        };
          var q = new Queue<(int, int)>();
          q.Enqueue((sr, sc));
          int toFind = image[sr][sc];
          image[sr][sc] = color;
          if (toFind == color) return image;
        
          while(q.Count > 0) {
            var auto = q.Dequeue();
            int row = auto.Item1;
            int col = auto.Item2;
            
            foreach(var (r, c) in directions) {
                int nrow = r + row;
                int ncol = c + col;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == toFind) {
                    image[nrow][ncol] = color;
                    q.Enqueue((nrow, ncol));
                }
            }
        }
        return image;

    }
}