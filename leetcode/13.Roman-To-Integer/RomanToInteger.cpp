#include <iostream>
#include <unordered_map>
#include <string>

using namespace std;

class RomanToInteger
{
public:
    int romanToInt(string s)
    {
        unordered_map<char, int> romanMap = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
        int total = romanMap[s[s.size() - 1]];
        for (int i = s.size() - 2; i >= 0; i--)
        {
            int value = romanMap[s[i]];
            if (value < romanMap[s[i + 1]])
            {
                total -= value;
            }
            else
            {
                total += value;
            }
        }
        return total;
    }
};

