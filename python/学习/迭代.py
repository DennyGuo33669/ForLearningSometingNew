from collections import Iterable

print(isinstance(123, Iterable))


for x, y in [(1, 1), (2, 4), (3, 9)]:
    print(x, y)
