def get_products_of_all_ints_except_at_index(int_list):
  # Make a list of the products
  result, product = [None] * len(int_list), 1
  for i in xrange(len(int_list)):
    result[i] = product
    product *= int_list[i]
  product = 1
  for i in xrange(len(int_list) - 1, -1, -1):
    result[i] *= product
    product *= int_list[i]
  return result


if __name__ == '__main__':
  int_list = [2, 6, 7, 9, 4, 8]
  print get_products_of_all_ints_except_at_index(int_list)
