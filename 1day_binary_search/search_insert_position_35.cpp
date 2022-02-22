#include <iostream>

int searchInsert(int* nums, int numsSize, int target){
    
    int startIdx = 0, endIdx = numsSize -1, midIdx = 0;
    
    while(startIdx < endIdx) {
        midIdx = startIdx + (endIdx - startIdx)/2;
        
        if(nums[midIdx] == target) {
            return midIdx;
        }
        else if(nums[midIdx] < target) {
            startIdx = midIdx + 1;
        } else {
            endIdx = midIdx;
        }
    }
    return target > nums[endIdx]? endIdx + 1: endIdx;
}

int main() {
    int nums[] = { 0, 2, 5 ,7, 8,10, 15};
    int insertPosIndex = searchInsert(nums, 7, 13);
    std::cout << "13 can be inserted at index: " << insertPosIndex;
}