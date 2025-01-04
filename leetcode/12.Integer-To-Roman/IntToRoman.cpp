#include <string>
#include <vector>
#include <cmath>

class Solution {
private:
    vector<vector<string>> roman = {
        {"I", "V"},
        {"X", "L"},
        {"C", "D"},
        {"M", ""}
    };

public:
    string intToRoman(int num) {
        string result;
        int lastIdx = 0;
        
        int numDig = (num == 0) ? 0 : floor(log10(num));
        int div = pow(10, numDig);
        
        while (num > 0) {
            int unid = num / div;
            int rep = unid % 5;
            int i = numDig - lastIdx;
            
            if (unid == 5) {
                result += roman[i][1];
            } else if (unid > 5) {
                if (rep == 4) {
                    result += roman[i][0] + roman[i + 1][0];
                } else {
                    result += roman[i][1] + string(rep, roman[i][0][0]);
                }
            } else {
                if (rep == 4) {
                    result += roman[i][0] + roman[i][1];
                } else {
                    result += string(rep, roman[i][0][0]);
                }
            }
            
            num = num - (unid * div);
            lastIdx++;
            div /= 10;
        }
        
        return result;
    }
};