/* lethead1.c */
#include <stdio.h>
#define NAME "Longcheer"
#define ADDRESS "401 CaoBao ROAD"
#define PLACE "XuHui Distric SH 200000"
#define WIDTH 40

void starbar(void); /* function type */

int main(void)
{
    starbar();

    printf("%s\n", NAME);
    printf("%s\n", ADDRESS);
    printf("%s\n", PLACE);

    starbar();
    
    return 0;
}

void starbar(void)
{
    for (int i = 0; i < WIDTH; i++)
    {
        putchar('*');
    }
    putchar('\n');
}