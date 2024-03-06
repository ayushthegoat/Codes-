#User function Template for python3

def isSubset( a1, a2, n, m):
    
    countA1 = {}

    for i in a1:
        countA1[i] = countA1.get(i, 0) + 1

    for i in a2:
        if i not in countA1 or countA1[i] <= 0:
            return "No"
        countA1[i] -= 1

    return "Yes"
    



#{ 
 # Driver Code Starts
#Initial Template for Python 3


def main():

    T = int(input())

    while(T > 0):
        sz = [int(x) for x in input().strip().split()]
        n, m = sz[0], sz[1]
        a1 = [int(x) for x in input().strip().split()]
        a2 = [int(x) for x in input().strip().split()]
        
        print(isSubset( a1, a2, n, m))

        T -= 1


if __name__ == "__main__":
    main()

# } Driver Code Ends