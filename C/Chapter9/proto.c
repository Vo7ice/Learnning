/*proto.c 使用函数原型*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int imax(int, int); /*函数原型*/

void getmemory(char *p)
{
    printf("---%p\n",p);
	p = (char *)malloc(100);
    printf("%p\n",p);
	strcpy(p,"hello world");
    printf("%s\n",p);
}

int main()
{
	char *str = NULL;
    printf("%p\n", str);
	getmemory(str);
    printf("%p", str);
	printf("--%s\n",str);
	free(str);
	return 0;
}
