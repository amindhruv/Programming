def get_products_of_all_ints_except_at_index(int_list):
  # Make a list of the products
  
  # Greedy approach with O(n) time and O(1) space complexity
  size, product = len(int_list), 1
  result = [None] * size
  for index in xrange(size):
    result[index] = product
    product *= int_list[index]
  product = 1
  for index in xrange(size - 1, -1, -1):
    result[index] *= product
    product *= int_list[index]
  return result


if __name__ == '__main__':
  int_list = [2, 6, 7, 9, 4, 8]
  print get_products_of_all_ints_except_at_index(int_list)
