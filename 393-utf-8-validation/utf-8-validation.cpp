class Solution {
public:
    bool validUtf8(vector<int>& data) {
        ios::sync_with_stdio(0);
        cin.tie(0);
        cout.tie(0);

         int rbytes = 0;

    for (const auto& it : data) {
        if (rbytes == 0) {
            if ((it >> 7) == 0) {
                rbytes = 0;
            } else if ((it >> 5) == 0b110) {
                rbytes = 1;
            } else if ((it >> 4) == 0b1110) {
                rbytes = 2;
            } else if ((it >> 3) == 0b11110) {
                rbytes = 3;
            } else {
                return false; // Invalid UTF-8 start byte
            }
        } else {
            if ((it >> 6) == 0b10) {
                rbytes--;
            } else {
                return false; // Invalid UTF-8 continuation byte
            }
        }
    }

    // If all bytes are properly terminated
    return rbytes == 0;
    }
};