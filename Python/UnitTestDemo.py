import unittest

def add(x, y):
    return y + x

def multiply(x, y):
    return x * y

def power(x, y):
    """Calculate x raised to the power y without using math.pow."""
    result = 1
    for _ in range(int(y)):
        result *= x
    return result

# print(add(5,4))       # --> 9
# print(multiply(3,4))  # --> 12
# print(power(2,8))     # --> 256

class CalculationTesting(unittest.TestCase):

    def test_sum(self):
        x = 10
        y = 20
        expected = x + y
        self.assertEqual(expected, add(x, y))

    def test_sum2(self):
        x = -10
        y = -20
        expected = x + y
        self.assertEqual(expected, add(x, y))

    def test_sum3(self):
        x = -99999
        y = 0
        expected = x + y
        self.assertEqual(expected, add(x, y))


# if __name__ == '__main__':
unittest.main()
