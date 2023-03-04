#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    cin>>s;
    for (int i=0; i<s.length();i++) {
        putchar(toupper(s[i]));
    }
    return 0;
}
