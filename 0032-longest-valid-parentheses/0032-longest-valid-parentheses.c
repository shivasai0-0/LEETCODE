#include <string.h>
#define MAX 30000

int stack[MAX];
int top = -1;

void push(int x) {
    if (top + 1 < MAX) stack[++top] = x;
}

int pop() {
    return (top != -1) ? stack[top--] : -1;
}

int peek() {
    return (top != -1) ? stack[top] : -1;
}

int longestValidParentheses(char* s) {
    int max_len = 0;
    top = -1;
    push(-1);

    for (int i = 0; s[i]; i++) {
        if (s[i] == '(') {
            push(i);
        } else {
            pop();
            if (top == -1) {
                push(i);
            } else {
                int len = i - peek();
                if (len > max_len) max_len = len;
            }
        }
    }
    return max_len;
}
