# Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
#
# An input string is valid if:
#
# Open brackets must be closed by the same type of brackets.
# Open brackets must be closed in the correct order.
# Note that an empty string is also considered valid.
#
# 来源：力扣（LeetCode）
# 链接：https://leetcode-cn.com/problems/valid-parentheses
# 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        if len(s) == 0:
            return True
        index = 0
        for index in range(len(s)):
            c = s[index]
            if self.isLeft(c):
                stack.append(c)
            else:
                if len(stack)>0:
                    temp = stack.pop()
                    if  self.isLeft(temp):
                        if not self.vaild(temp,c):
                            return False
                else:
                    return False
        if len(stack) != 0:
            return False
        else:
            return True

    @staticmethod
    def isLeft(c):
        if c == '{' or c == '[' or c == '(':
            return True
        else:
            return False

    @staticmethod
    def vaild(left, right):
        if right == '}':
            if left == '{':
                return True
        if right == ']':
            if left == '[':
                return True
        if right == ')':
            if left == '(':
                return True
        else:
            return False


if __name__ == "__main__":
    s = Solution()
    print(s.isValid("(]"))