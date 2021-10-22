/**
 * @param dest   输出字符串
 * @param src    源字符串
 * @param before 替换前字符
 * @param after  替换后字符
 *
 * @return dest  输出结果
 *
 */
static char* strrpc(char* dest, char* src, char* before, char* after) {
    size_t src_size = strlen(src);
    size_t before_str_size = strlen(before);
    size_t after_str_size = strlen(after);

    size_t dest_offset = 0;
    for (size_t src_offset = 0; src_offset < src_size; ) {
        if (!strncmp(src + src_offset, before, before_str_size)) {
            memcpy(dest + dest_offset, after, after_str_size);
            src_offset += before_str_size;
            dest_offset += after_str_size;
        }
        else {
            memmove(dest + dest_offset, src + src_offset, 1);
            dest_offset++;
            src_offset++;
        }
    }

    return dest;
}