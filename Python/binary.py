def decimal_to_binary(decimal):
    if decimal != 0:
        decimal_to_binary(decimal // 2)
        print(decimal % 2, end='')


def binary_to_decimal(binary):
    result = 0
    for ch in binary:
        result = result * 2 + int(ch)
    print('Equivalent decimal:', result)


if __name__ == '__main__':
    arabic = int(input('Enter decimal(arabic) number: '))
    print('Equivalent binary: ', end='')
    decimal_to_binary(arabic)
    print()
    binary_string = input('Enter binary number string: ')
    binary_to_decimal(binary_string)
