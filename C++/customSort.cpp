#include <iostream>
#include <map>
#include <set>
#include <vector>
// #include <ctime>

using namespace std;

void customSort(vector<int> &nums) {
    // clock_t begin = clock();
    map<int, int> hm;
    for (int i : nums) {
        if (hm.find(i) != hm.end())
            hm[i]++;
        else
            hm[i] = 1;
    }
    map<int, set<int>> res;
    for (auto it : hm) {
        if (res.find(it.second) != res.end()) {
            res[it.second].insert(it.first);
        } else {
            set<int> temp;
            temp.insert(it.first);
            res[it.second] = temp;
        }
    }
    for (auto it : res) {
        for (int n : it.second) {
            cout << n << endl;
        }
    }
    // clock_t end = clock();
    // double elapsed_secs = double(end - begin) / CLOCKS_PER_SEC;
    // cout << elapsed_secs;
}

int main()
{
    int arr[] = {2, 6, 7, 2, 3, 7, 1, 6, 0, 8};
    vector<int> vec (arr, arr + sizeof(arr) / sizeof(arr[0]) );
    customSort(vec);
}