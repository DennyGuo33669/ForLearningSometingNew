# prince = 1000000
# has_good_credit = True

# if has_good_credit:
#     down_payment = 0.1 * prince
# else:
#     down_payment = 0.2 * prince

# print(f" Down payment:{down_payment}")


# *****************************************************

# temperature = 30
# print(temperature)


# name ='j'
# print(len(name))
# weight = int(input("weight: "))
# unit = input("(L)bs or (K)g:")
# if unit.upper() == "L":
#     converted = weight * 0.45
#     print(f"You are {converted} kilos")
# else:
#     converted = weight / 0.45
#     print(f"You are {converted} pounds")

# i = 1
# while i <= 5:
#     print(i)
#     i = i+1
# print("Done")
# name = 'Denny'

# print(name.upper())

# for item in 'python':
#     print(item)

# for x in range(4):
#     for y in range(3):
#         print(f'({x},{y})')


# number = [5, 2, 5, 2, 2]

# # for x in number:
# #     print(x * 'x')

# for x_count in number:
#     output = ''
#     for count in range(x_count):
#         output += 'x'
#     print(output)

# matrix = [
#     [1, 2, 3],
#     [4, 5, 6],
#     [7, 8, 9]
# ]

# for row in matrix:
#     for item in row:
#         print(item)

# coordinates = [1,2,3]
# x,y,z = coordinates
# print(x,y,z)

# customer = {
#     "name":"John",
#     "age":30,
#     "is_verified":True
# }
# # print(customer["name"])

# print(customer.get("birthday","Jan 1 1980"))


phone = input("Phone:")
digits_mapping = {
    "1": "One",
    "2": "Two",
    "3": "Three",
    "4": "Four"
}

output = ''
for ch in phone:
    output += digits_mapping.get(ch, '!') + ' '
print(output)

NAME = 'DENNY'
