/* swap3.c -- 使用指针解决交换函数的问题 */
#include <stdio.h>
void interchange (int * u, int * v);
int sum(int, int);
void alter(int *, int *);

int main(void)
{
    int x = 5, y = 10;
    printf("Originally x = %d and y = %d.\n", x, y);
    interchange(&x, &y);
    printf("Now x = %d, y = %d.\n", x, y);
    printf("sum = %d.\n", sum(x, y));
    alter(&x, &y);
    printf("After alter x = %d, y = %d.\n", x, y);
    return 0;
}

void interchange(int * u, int *v)
{
    int tmp;
    tmp = *u;
    *u = *v;
    *v = tmp;
}

int sum(int x, int y)
{
    return x + y;
}

void alter(int * x, int * y)
{
    int sum = *x + *y;
    int minus = *x - *y;
    *x = sum;
    *y = minus;
}