/* addaword.c 使用fprintf(), fscanf() 和 rewind() */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX 41
int main(void)
{
    FILE *fp;
    char words[MAX];
    if ((fp = fopen("D:/Github/Learnning/Test/test1.log", "a+")) == NULL)
    {
        fprintf(stdout, "Can`t open \"wordy\" file.\n");
        exit(EXIT_FAILURE);
    }

    puts("Enter words to add to the file; presss the #");
    puts("key at the beginning of a line to terminate.");
    while ((fscanf(stdin, "%40s", words) == 1) && (words[0] != '#'))
    {
        fprintf(fp, "%s\n", words);
    }
    puts("File contents:");
    rewind(fp);
    while (fscanf(fp, "%s", words) == 1)
    {
        puts(words);
    }
    puts("Done!");
    if (fclose(fp) != 0)
    {
        fprintf(stderr, "Error closing file\n");
    }

    return 0;    
}