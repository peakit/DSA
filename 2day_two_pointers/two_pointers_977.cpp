#include <iostream>
#include <math.h>

int *sortedSquares(int *nums, int numsSize, int *returnSize)
{
    int *ret = new int(*returnSize);

    int left = 0, right = numsSize - 1, retIdx = *returnSize - 1;
    while (retIdx >= 0)
    {
        if (abs(*(nums + left)) > abs(*(nums + right)))
        {
            *(ret + retIdx) = *(nums + left) * (*(nums + left));
            retIdx--;
            left++;
        }
        else
        {
            *(ret + retIdx) = *(nums + right) * (*(nums + right));
            retIdx--;
            right--;
        }
    }
    return ret;
}

int main()
{
    int nums[] = {-4, 0, 1, 2, 3};
    int squares = 5;

    int *sortedSq = sortedSquares(nums, 5, &squares);

    for (int i = 0; i < squares; i++)
    {
        std::cout << "\nSorted square[" << i << "]: " << *(sortedSq + i);
    }
}