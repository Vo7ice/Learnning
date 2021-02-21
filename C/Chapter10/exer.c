/* exer.c 复习题 */
#include <stdio.h>

int main(void)
{
    int ref[] = { 8, 4, 0, 2 };
    int *ptr;
    int index;
    for (index = 0, ptr = ref; index < 4; index++, ptr++)
    {
        printf("%d %d\n", ref[index],  *ptr);
    }

    int *ptr1;
    int torf[2][2] = { 12, 14, 16 };
    ptr1 = torf[0];
    printf("%d %d\n", *(ptr1 + 2),  *ptr1);

    int *ptr2;
    int fort[2][2] = { { 12 }, { 14, 16 }};
    ptr2 = fort[0];
    printf("%d %d\n", *(ptr2 + 2),  *ptr2);
    
    return 0;
}