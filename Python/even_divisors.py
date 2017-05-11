import math

if __name__ == '__main__':
    number = int(input('Enter a number: '))
    if number % 2 != 0:
        print('No even divisors!')
    else:
        count = 0
        result = []
        for i in range(1, int(math.sqrt(number)) + 1):
            if number % i == 0:
                if i % 2 == 0:
                    result.append(i)
                    count += 1
                other = number // i
                if number % other == 0 and other != i:
                    result.append(other)
                    count += 1
        print('count:', count)
        print('Even divisors: ', sorted(result))
