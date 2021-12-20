/* lethead1.c */
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define NAME "Longcheer"
#define ADDRESS "401 CaoBao ROAD"
#define PLACE "XuHui Distric SH 200000"
#define WIDTH 40
#define max(x, y) ((x) < (y) ? (y) : (x))
void starbar(void); /* function type */
void swap(int *p1, int *p2);
struct name1
{
    char str;
    short x;
    int num;
} name1; 

struct name2
{
    char str;
    int num;
    short x;
} name2;

int main(void)
{
    starbar();

    printf("%s\n", NAME);
    printf("%s\n", ADDRESS);
    printf("%s\n", PLACE);
    max(4, 5);
    starbar();
    
    char str[] = "hello";
    int a = sizeof(str);
    char *p = str;
    int int_a = 10;
    char str_str[100];
    char *q = malloc(100);
    printf("%d\n", sizeof(str));
    printf("%ld\n", sizeof(p));
    printf("%ld\n", sizeof(int_a));
    printf("%ld\n", sizeof(str_str));
    printf("%ld\n", sizeof(q));
    // printf("%d", a);

    char* s = "AAA";
    printf("%s\n\n", s);
    // s[0] = 'B';
    // printf("%s\n\n", s);

    int x = 4;
    int y = 5;
    printf("x = %d, &x = %p, y = %d,  &y = %p\n", x, &x, y, &y);
    swap(&x, &y);
    printf("x = %d, &x = %p, y = %d,  &y = %p\n", x, &x, y, &y);

    char abc;
    char *str_abc = &abc;
    // strcpy(str_abc, "hello");
    // printf(str_abc);



    printf("name1 = %d, name2 = %d\n", sizeof(name1), sizeof(name2));

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

void swap(int *p1, int *p2)
{
    int temp;
    temp = *p1;
    *p1 = *p2;
    *p2 = temp;
}