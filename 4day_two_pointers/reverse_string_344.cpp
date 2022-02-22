#include <iostream>

void reverseString(char *s, int sSize)
{
    int left = 0, right = sSize - 1;
    while (left < right)
    {
        char save = s[left];
        s[left++] = s[right];
        s[right--] = save;
    }
}

int main()
{
    char s[] = "hello";
    int sSize = 5;

    reverseString(s, sSize);
    std::cout << s;
}