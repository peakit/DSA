#include <iostream>

void moveZeroes(int *nums, int numsSize)
{
    int slow = 0, fast = 0;
    while (fast < numsSize)
    {
        if (nums[fast] != 0)
        {
            nums[slow++] = nums[fast];
        }
        fast++;
    }
    while (slow < numsSize)
    {
        nums[slow++] = 0;
    }
}

int main()
{
    int nums[] = {1, 0, -2, 3, 0, 7};
    moveZeroes(nums, 6);

    for (int i = 0; i < 6; i++)
    {
        std::cout << nums[i] << "\n";
    }
}