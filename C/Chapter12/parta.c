// parta.c 不同的存储类别
// 与partb.c 一起编译
#include <stdio.h>
void report_count();

void accumulate(int k);

int count = 0;

int main(int argc, char const *argv[])
{
    int value;
    register int i;
    printf("Enter a positive integer (0 to quit): ");
    while (scanf("%d", &value) == 1 && value > 0)
    {
        ++count;
        for (i = value; i >= 0; i--)
        {
            accumulate(i);
        }

        printf("Enter a positive integer (0 to quit): ");
        
    }
    report_count();
    
    return 0;
}

void report_count()
{
    printf("Loop executed %d times\n", count);
}
