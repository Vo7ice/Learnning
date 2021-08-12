/* lethead2.c */
#include <stdio.h>
#include <string.h>

#define NAME "Home"
#define ADDRESS "328 HeYun ROAD"
#define PLACE "Pudong New Distric SH 200000"
#define WIDTH 40
#define SPACE ' '

void show_n_char(char ch, int num);

int main(void)
{
    int spaces;
    show_n_char('*', WIDTH);
    putchar('\n');
    show_n_char(SPACE, 12);
    printf("%s\n", NAME);
}