#include <iostream>
#include <string.h>
#include <vector>
#include <stdio.h>
#include <stdexcept>
#include "Chapter6.h"

using namespace std;

void test317();
void test1();

void test2() {
    char a[20] = "hello\0";
    char b[40] = "I want to get off my work!\0";
    char c[100];
    strcpy(c, a);
    strcat(c, " ");
    strcat(c, b);

    cout << c << endl;
}

void test421() {
    vector<int> ivec = {1,2,3,4,5,6,7,8,9,10};
    for (auto &i : ivec)
    {
        i = (i % 2 == 1) ? i * 2 : i;
        cout << i << "  ";
    }
    cout << endl;
}

void test422() {
    int grade;
    string finalgrade;

    while (cin >> grade)
    {
        finalgrade = (grade > 90) ? "high pass" : (grade < 60) ? "faile" : (grade < 75) ? "low pass" : "pass";

        cout << "first finalgrade: " << finalgrade << " ";
        if (grade >= 90)
        {
            finalgrade = "high pass";
        }
        else if (grade < 90 && grade >= 75)
        {
            finalgrade = "pass";
        }
        else if (grade < 75 && grade >= 60)
        {
            finalgrade = "low pass";
        }
        else
        {
            finalgrade = "fail";
        }
        cout << "seconde finalgrade: " << finalgrade << " ";
    }

    cout << endl;
    
}

void test423() {
    string s = "word";
    string ppl = s + (s[s.size() - 1] == 's' ? "" : "s");
}

void test429() {
    int x[10]; int *p = x;
    int *p1;
    cout << sizeof(p1) << endl;
    cout << sizeof(x) << " " << sizeof(x) / sizeof(*x) << " " << sizeof(*x) << endl;
    cout << sizeof(p) << " " << sizeof(p) / sizeof(*p) << " " << sizeof(*p) << endl;
}

void test432() {
    constexpr int size = 5;
    int ia[size] = {1,2,3,4,5};
    for (int *ptr = ia, ix = 0; ix != size && ptr != ia + size; ++ix, ++ptr) {
        cout << "ix : " << ix << ", ptr : " << ptr << ", *ptr : " << *ptr << " ";
        cout << "ia + size :" << ia + size << endl;
    }
}

void test541() {
    auto s = "string";
    /*while (string::iterator iter != s.end())
    {
        
    }*/
}

void test505() {
    const vector<string> scores = {"F", "D", "C", "B", "A", "A++"};
    float grade;
    string letterGrade;
    while (cin >> grade)
    {
        if (grade < 60)
        {
            letterGrade = scores[0];
        }
        else
        {
            letterGrade = scores[(grade-50)/10];
        }
        cout << letterGrade << endl;
    }
    
}

void test523() {
    int ival1;
    int ival2;
    int result;
    while (cin >> ival1 >> ival2)
    {
        try
        {
            result = ival1 / ival2;
        }
        catch(runtime_error err)
        {
            std::cerr << err.what() << '\n';
        }
        
    }
    
}

int fact(int val)
{
    int ret = 1; // 局部变量，用于保存计算结果
    while (val > 1)
    {
        ret *= val--;// 把ret和val的乘积赋给ret，然后将val减1
    }
    return ret;// 返回结果
}

int test603()
{
    int val = 0;
    cout << "Please input a int number: " << endl;
    cin >> val;

    long result = fact(val);
    cout << "val`s factorial is " << result << endl;
    return result;
}

int test605()
{
    int val = 0;
    cout << "Please input a int number: " << endl;
    cin >> val;

    int result = absolute(val);
    cout << "the " <<  val << " absolute is " << result << endl;
    return result;
}

void swap(int *a, int *b)
{
    int tmp;

    tmp = *a;
    *a = *b;
    *b = tmp;
}

void test610() {
    int a = 5, b = 10;
    swap(&a, &b);
    
    cout << "a = " << a << ", b = " << b << endl;
}

void test622() {
    int n = 42;
    int &a = n;

}

void my_reset(int &val)
{
    val = 0;
}

void test611()
{
    int a = 20;
    my_reset(a);

    cout << "a = " << a << endl;
}

void swap_ref(int &a, int &b)
{
    int tmp;
    tmp = a;
    a = b;
    b = tmp;
}

void test612()
{
    int a = 4, b = 5;
    swap_ref(a, b);

    cout << "a = " << a << ", b = " << b << endl;
}

bool hasCaptical(const string&  s)
{
    for (auto &i : s)
    {
        if (isupper(i)) {
            return true;
        }
    }
    return false;
}

void to_super(string& s)
{
    for (auto &i : s)
    {
        i = toupper(i);
    }
}

void test617()
{
    string s = "Hello World";

    if (hasCaptical(s)) {
        cout << "s has upper letter." << endl;
    }

    to_super(s);
    cout << "s = " << s << endl;
}

int compare(int a, int *b)
{
    return a > *b ? a : *b;
}

void test621()
{
    int a = 5;
    int b = 9;
    
    int max = compare(a, &b);

    cout << a << " , " << b << " max is " << max << endl; 
}

int test627(initializer_list<int> il)
{
    int sum = 0;
    for (auto &i : il)
    {
        sum += i;
    }
    cout << "sum = " << sum << endl;
    return sum;
}

bool str_subrange(const string &str1, const string &str2)
{
    if (str1.size() == str2.size())
    {
        return str1 == str2;
    }

    auto size = (str1.size() < str2.size()) 
                ? str1.size() : str2.size();
    
    for(decltype(size) i = 0; i != size; ++i) {
        return str1[i] != str2[i];
    }
}

void print_vector(vector<int>::const_iterator beg, vector<int>::const_iterator end) {
#if defined NDEBUG



#endif // NDEBUG

    if (beg != end) {
        cout << *beg << " ";
        print_vector(++ beg, end);
    }
}

void test633() {
    vector<int> ivec = {1,2,3,4,5,6,7,8,9,10};
    print_vector(ivec.begin(), ivec.end());
}

int add(int a, int b) {
    return a + b;
}

int sub(int a, int b) {
    return a - b;
}

int multiply(int a, int b) {
    return a * b;
}

int divide(int a, int b) {
    return b != 0 ? a / b : 0;
}

void test656() {
    typedef int(*p) (int, int);
    vector<p> vec{add, sub, multiply, divide};
    for (auto f : vec)
    {
        cout<< f(2, 4) << endl;
    }
    
}

struct Sales_data

{

    std::string bookNo; // 对象的ISBN编号

    unsigned units_sold = 0; // 售出的册数

    double revenue = 0.0; // 总价格

    std::string isbn () const { return bookNo; } // 返回ISBN编号

    Sales_data& combine (const Sales_data&); // 将一个Sales_data对象加到另一个上面

    Sales_data& trans(const Sales_data&);// 交易记录
};

Sales_data& Sales_data:: combine(const Sales_data& rhs) {
    this->units_sold += rhs.units_sold;
    this->revenue += rhs.revenue;
    return *this;
}

Sales_data& Sales_data:: trans(const  Sales_data& rhs) {
    if (this->isbn() == rhs.isbn()) {
        this-> combine(rhs);
    } else {
        
    }
}

struct Person
{
    std::string name;
    std::string address;
    std::string getName() const { return name; }
    std::string getAddress() const {return address; }
    istream &read(istream &is, Person &person); 
    ostream &print(ostream &os, const Person &person);
};

istream &read(istream &is, Person &person) {
    is >> person.name >> person.address ;
    return is;
}

ostream &print(ostream &os, Person &person) {
    os << person.name << " : " << person.address << endl;
    return os;
}


int main()
{
    // cout << "Hello World!" << endl;
    // const string hexdigits = "0123456789ABCDEF";
    // cout << "Enter a series of numbers between 0 and 15"
    //      << " separeated by spaces. hit ENTER when finished: ";
    // string result;
    // string n;
    // vector<int> ivec(5);
    // int count = 0;
    // while (cin >> n && count < ivec.size())
    // {
    //     // if (n < hexdigits.size())
    //     // {
    //     //     result += hexdigits[n];
    //     // }
    //     // cout << "Your hex number is: " << result << endl;
    //     for (auto &c : n)
    //     {
    //         if (isdigit(c))
    //         {
    //             cout << "You input a digit: " << c << endl;
    //             int temp = c - '0';
    //             ivec[count] = temp;
    //             count++;
    //         }
    //     }
    // }
    // test1();
    // test317();
    // test2();
    // test421();
    // test422();
    // test429();
    // test432();
    // int j = fact(5);
    // cout << "5! is " << j << endl;
    // test603();
    // test605();
    // test610();
    // test611();
    // test612();
    // test617();
    // test621();
    // if (argc != 3) {
    //     cout << "Usage should have two arguments" << endl;
    // }
    // string str;
    // for(int i = 1; i < argc; i++) {
    //     str += string(argv[i]) + " ";
    // }

    // cout << str << endl;
    // test627({1,2,3,4,5,6,7,8});
    // test633();
    test656();
    return 0;
}

void test317()
{
    string word;
    vector<string> svec;
    while (cin >> word)
    {
        svec.push_back(word);
    }

    for (auto &str : svec)
    {
        for (auto &c : str)
        {
            c = toupper(c);
        }
    }

    for (auto i : svec)
    {
        cout << i << endl;
    }
}

void test1()
{
    unsigned scores[11] = {};
    unsigned grade;
    while (cin >> grade)
    {
        if (grade <= 100)
        {
            ++scores[grade / 10];
        }
    }

    for (auto i : scores)
    {
        cout << i << " ";
    }
    cout << endl;
}

int absolute(int val)
{
    return (val > 0) ? val : (-val);
}