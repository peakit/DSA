#include <iostream>

// nice thread: https://leetcode.com/problems/search-insert-position/discuss/249092/Come-on-forget-the-binary-search-patterntemplate!-Try-understand-it!
bool isBadVersion(int version)
{
    if (version >= 5)
    {
        return true;
    }
    return false;
}

int binary_search_iterative(int versions, int start_idx, int end_idx)
{
    while (start_idx < end_idx)
    {
        int mid_idx = start_idx + (end_idx - start_idx) / 2;

        if (isBadVersion(mid_idx))
        {
            end_idx = mid_idx;
        }
        else
        {
            start_idx = mid_idx + 1;
        }
    }
    return end_idx;
}

int firstBadVersion(int versions)
{
    return binary_search_iterative(versions, 1, versions);
}

int main()
{
    int versions = 5;

    int badVersion = firstBadVersion(versions);

    std::cout << "Bad version is: " << badVersion;
}