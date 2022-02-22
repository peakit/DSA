#include <iostream>
#include <string.h>
#include <stdlib.h>

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

char *reverseWords(char *s)
{
    char *token = strtok(s, " ");
    char *final = (char *)malloc(strlen(s) * sizeof(char));
    int i = 0;
    while (token != NULL)
    {
        reverseString(token, strlen(token));
        if (i > 0)
        {
            final = strcat(final, " ");
        }
        i++;
        final = strcat(final, token);
        token = strtok(NULL, " ");
    }
    return final;
}

int main()
{
    char s[] = "God Ding";
    std::cout << reverseWords(s);
}