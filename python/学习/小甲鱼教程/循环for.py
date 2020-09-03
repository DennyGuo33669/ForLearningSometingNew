for each in "DennyGuo":
    print(each, end=" ")

print()

sum = 0
for i in range(11):
    print(i, end=" ")
    sum += i
print("\n", sum)


# for n in range(2, 10):
#     for x in range(2, n):
#         if n % x == 0:
#             print(n, "=", x, "*", n // x)
#             break
#     else:
#         print(n, "是一个质数")


for n in range(2, 10):
    for x in range(2, n):
        if n % x != 0:
            print(n, "是一个质数")
        break
