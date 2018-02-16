def get_max_profit(stock_prices):
    # Greedy approach with O(n) time and O(1) space complexity
    if len(stock_prices) < 2:
        raise ValueError('At least 2 prices required to calculate profit!')
    min_price, max_profit = stock_prices[0], stock_prices[1] - stock_prices[0]
    for current_time in xrange(1, len(stock_prices)):
        current_price = stock_prices[current_time]
        current_profit = current_price - min_price
        max_profit = max(max_profit, current_profit)
        min_price = min(min_price, current_price)
    return max_profit


if __name__ == '__main__':
    stock_prices = [10, 7, 5, 11, 9]
    print get_max_profit(stock_prices)
