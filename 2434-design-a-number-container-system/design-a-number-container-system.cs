public class NumberContainers {
    private Dictionary<int, int> indexToNum;
    private Dictionary<int, SortedSet<int>> numToIndex;
    public NumberContainers() {
        indexToNum = new Dictionary<int, int>();
        numToIndex = new Dictionary<int, SortedSet<int>>();
    }
    
    public void Change(int index, int number) {
        if(indexToNum.ContainsKey(index)) {
            int oldNum = indexToNum[index];
            if(numToIndex.ContainsKey(oldNum)) {
                  numToIndex[oldNum].Remove(index);
                if (numToIndex[oldNum].Count == 0) {
                    numToIndex.Remove(oldNum);
                }
            }
        }
         indexToNum[index] = number;
        if (!numToIndex.ContainsKey(number)) {
            numToIndex[number] = new SortedSet<int>();
        }
        numToIndex[number].Add(index);
    }
    
    public int Find(int number) {
         return numToIndex.ContainsKey(number) && numToIndex[number].Count > 0 
               ? numToIndex[number].Min 
               : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.Change(index,number);
 * int param_2 = obj.Find(number);
 */