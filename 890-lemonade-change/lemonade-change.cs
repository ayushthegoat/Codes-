public class Solution {
    public bool LemonadeChange(int[] bills) {
      int fiveCount = 0, tenCount = 0;

    foreach (int bill in bills)
    {
        if (bill == 5)
        {
            fiveCount++;
        }
        else if (bill == 10)
        {
            if (fiveCount == 0) return false;
            fiveCount--;
            tenCount++;
        }
        else // bill == 20
        {
            if (tenCount >= 1 && fiveCount >= 1)
            {
                tenCount--;
                fiveCount--;
            }
            else if (fiveCount >= 3)
            {
                fiveCount -= 3;
            }
            else
            {
                return false;
            }
        }
    }

    return true;
    }
}


// 5 5 

// 10 10