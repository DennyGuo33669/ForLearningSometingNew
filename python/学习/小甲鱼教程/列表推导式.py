oho = [1, 2, 3, 4, 5]
# for each in range(len(oho)):
#     oho[each] = oho[each] * 2

# print(oho)

oho = [i * 2 for i in oho]
print(oho)

x = [i for i in range(10)]
print(x)

y = [c * 2 for c in "FishC"]
print(y)

code = [ord(c) for c in "FishC"]
print(code)

matrix = [
    [1, 2, 3],
    [4, 5, 6],
    [7, 8, 9]]
col2 = [row[1] for row in matrix]
print(col2)


diag = [matrix[i][i] for i in range(len(matrix))]
print(diag)

diag = [matrix[i][len(matrix)-1-i] for i in range(len(matrix))]
print(diag)
