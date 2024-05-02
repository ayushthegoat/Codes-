//{ Driver Code Starts
import java.util.*;

class Find_Given_Element_Of_Spiral_Matrix 
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			int arr[][] = new int[1000][1000];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().findK(arr, n, m, k));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	// Your code here	
	 int[] deltaRow = {0, 1, 0, -1};
int[] deltaCol = {1, 0, -1, 0};
int row = 0, col = 0, direction = 0;
int[][] visited = new int[n][m];

for (int i = 0; i < m * n; i++) {
    k--;
    if (k == 0) return A[row][col];

    visited[row][col] = 1;
    int nextRow = row + deltaRow[direction];
    int nextCol = col + deltaCol[direction];

    if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && visited[nextRow][nextCol] != 1) {
        row = nextRow;
        col = nextCol;
    } else {
        direction = (direction + 1) % 4;
        row += deltaRow[direction];
        col += deltaCol[direction];
    }
}

return -1;
    }
}