def is_palindrome(string):
    length = len(string)
    for i in range(length // 2):
        if string[i] != string[length - i - 1]:
            return False
    return True


if __name__ == '__main__':
    print(is_palindrome(input('Enter a string to check for palindrome: ')))
