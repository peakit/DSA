#include <iostream>

// Space complexity = O(1)
void printNums(int *nums, int numsSize)
{
    for (int i = 0; i < numsSize; i++)
    {
        std::cout << "\nnums[" << i << "]: " << *(nums + i);
    }
}

void reverse(int *nums, int startIdx, int endIdx)
{
    for (int i = 0; i < (endIdx - startIdx) / 2; i++)
    {
        int save = *(nums + startIdx + i);
        *(nums + startIdx + i) = *(nums + endIdx - i);
        *(nums + endIdx - i) = save;
    }
}

void rotate(int *nums, int numsSize, int k)
{
    int save = 0;
    int actualRotationsNeeded = k % numsSize;

    // reverse entire array
    // reverse upto k
    // reverse from k to end
    reverse(nums, 0, numsSize - 1);
    printNums(nums, numsSize);

    reverse(nums, 0, actualRotationsNeeded - 1);
    printNums(nums, numsSize);

    reverse(nums, actualRotationsNeeded, numsSize - 1);
    printNums(nums, numsSize);
}

int main()
{
    int nums[] = {-1, 2, 4, 5, 7, 8};
    int numsSize = 6, k = 0;

    std::cout << "\nEnter the number of rotations: ";
    std::cin >> k;

    rotate(nums, numsSize, k);
}