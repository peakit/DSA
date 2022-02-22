#include <iostream>

int binary_search(int nums[], int total_elements, int start_idx, int end_idx, int target) {
    if (start_idx < 0 || end_idx > (total_elements - 1) || start_idx > end_idx) {
        return -1;
    }

    int mid_idx = (start_idx + end_idx)/2;
    if (target == nums[mid_idx]) {
        return mid_idx;
    }

    if (target < nums[mid_idx]) {
        return binary_search(nums, total_elements, start_idx, mid_idx-1, target);
    }

    if (target > nums[mid_idx]) {
        return binary_search(nums, total_elements, mid_idx+1, end_idx, target);
    }
}

int find(int nums[], int target) {
    if (nums == NULL) {
        return -1;
    }
    int total_elements = 11;
    return binary_search(nums, total_elements, 0, total_elements -1, target);
}

int main()
{
    int nums[11] = {-1, 2, 3, 4, 5, 6, 7, 8, 17, 45, 52};
    int target = 0;
    std::cout << "Please enter the target to be found: ";
    std::cin >> target;
   
    int target_index = find(nums, target);
    std::cout << "Found the target at index: " << target_index;
    return 0;
}


