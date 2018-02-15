def ways_to_make_coin_change(denominations, amount):
    # Dynamic programming bottom up approach with O(m*n) time and O(n) space complexity
    # where m = number of denominations and n = amount
    if len(denominations) == 0 or amount < 0:
        return 0
    cache = [0 for i in xrange(amount + 1)]
    cache[0] = 1  # Edge case when amount is zero
    for coin in denominations:
        for next_amount in xrange(coin, amount + 1):
            remainder = next_amount - coin
            cache[next_amount] += cache[remainder]
    return cache[amount]


if __name__ == '__main__':
    print ways_to_make_coin_change([1, 6, 10], 12)
