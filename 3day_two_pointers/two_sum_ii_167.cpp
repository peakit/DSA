#include <iostream>

int *twoSumOpt(int *numbers, int numbersSize, int target, int *returnSize)
{
    int left = 0, right = numbersSize - 1;

    while (left < right)
    {
        if (numbers[left] + numbers[right] == target)
        {
            *returnSize = 2;
            int *returnedArray = (int *)malloc(*returnSize * sizeof(int));
            *(returnedArray) = left + 1;
            *(returnedArray + 1) = right + 1;
            
            return returnedArray;
        }
        else if (numbers[left] + numbers[right] > target)
        {
            right--;
        }
        else
        {
            left++;
        }
    }
    *returnSize = 0;
    return NULL;
}

int *twoSum(int *numbers, int numbersSize, int target, int *returnSize)
{
    int firstNumber, secondNumber = 0;

    for (int i = 0; i < numbersSize; i++)
    {
        firstNumber = numbers[i];
        for (int j = i; j < numbersSize && (target - firstNumber) >= numbers[j]; j++)
        {
            if (firstNumber + numbers[j] == target)
            {
                secondNumber = target - firstNumber;

                int *targetArray = new int[*returnSize];
                targetArray[0] = i + 1;
                targetArray[1] = j + 1;

                return targetArray;
            }
        }
    }
    return NULL;
}

int main()
{
    int numbers[] = {1, 3, 5, 7, 11, 15};
    int numbersSize = 6;
    int target = 0;
    std::cout << "\nEnter target: ";
    std::cin >> target;

    int returnSize = 2;
    int *targetArray = twoSumOpt(numbers, numbersSize, target, &returnSize);

    if (targetArray != NULL)
    {
        std::cout << "\nThere exists two numbers at index: " << targetArray[0] << ", " << targetArray[1];
    }
}