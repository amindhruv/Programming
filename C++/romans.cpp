#include <iostream>
#include <unordered_map>

using namespace std;

string roman(int n) {
  string th[] = {"", "M", "MM", "MMM"};
  string hu[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
  string te[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
  string on[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
  return th[n / 1000] + hu[(n % 1000) / 100] + te[(n % 100) / 10] + on[n % 10];
}

int arabic(string roman) {
  unordered_map<char, int> hm = {{'I', 1}, {'V', 5}, {'X', 10}, {'L', 50}, {'C', 100}, {'D', 500}, {'M', 1000}};
  int res = 0, n = roman.size();
  for (int i = 0; i < n; i++) {
    char curr = roman[i], next = roman[i + 1];
    int cv = hm[curr], nv = hm[next];
    if (i < (n - 1) && cv < nv) res -= cv;
    else res += cv;
  }
  return res;
}

int main()
{
  int n;
  string str;
  cout << "Enter a roman number: ";
  cin >> str;
  cout << "Its arabic number: " << arabic(str) << endl;
  cout << "Enter an arabic number: ";
  cin >> n;
  cout << "Its roman number: " << roman(n) << endl;
  return 0;
}