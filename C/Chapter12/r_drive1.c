/* r_drive1.c 测试rand1() 和 srand1() */
/* 与 s_and_r.c 一起编译 */

#include <stdio.h>
#include <stdlib.h>

extern void srand1(unsigned int x);

extern int rand1(void);

int main(int argc, char const *argv[])
{
    int count;
    unsigned seed;
    printf("Please enter your choice for seed.\n");
    
    while (scanf("%u", &seed))
    {
        srand1(seed); // 重置种子
        for (count = 0; count < 5; count++)
        {
            printf("%d\n", rand1());
        }
        printf("Please enter next seed(q to quit):\n");
    }
    printf("Done\n");
    return 0;
}
