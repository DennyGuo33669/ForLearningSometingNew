# print(list(range(1, 101)))


print([x * x for x in range(1, 11)])
# [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]

print([x * x for x in range(1, 11) if x % 2 == 0])
# [4, 16, 36, 64, 100]

print([m + n for m in 'ABC' for n in 'XYZ'])
# ['AX', 'AY', 'AZ', 'BX', 'BY', 'BZ', 'CX', 'CY', 'CZ']
