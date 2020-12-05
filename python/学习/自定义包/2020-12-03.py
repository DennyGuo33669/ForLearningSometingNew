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


# phone = input("Phone:")
# digits_mapping = {
#     "1": "One",
#     "2": "Two",
#     "3": "Three",
#     "4": "Four"
# }

# output = ''
# for ch in phone:
#     output += digits_mapping.get(ch, '!') + ' '
# print(output)
# try:
#     age = int(input("age:"))
#     income = 20000
#     risk = income / age
#     print(age)
# except ZeroDivisionError:
#     print("年龄不能为0")

# except ValueError:
#     print("输入的类型有误 请输入数字!")


# class Point:
#     def __init__(self, x, y) -> None:
#         super().__init__()
#         self.x = x
#         self.y = y

#     def draw(self):
#         print('draw')

#     def move(self):
#         print('move')


# point1 = Point(10, 20)

# point1.draw()
# # point1.x = 10
# print(point1.x)

# class Person:
#     def __init__(self, name) -> None:
#         super().__init__()
#         self.name = name

#     def talk(self):
#         print("talk")
#         print(f"Hi! I'm{self.name}!")


# person1 = Person("Denny")
# person1.talk()

# class mammal:
#     def walk(self):
#         print("walk")


# class dog(mammal):
#     pass


# class cat(mammal):
#     def be_annoying(self):
#         print("annoying")


# cat1 = cat()
# cat1.be_annoying()
# cat1.walk()
# import converters

# print(converters.lbs_to_kg(70))


# # from utils import find_max
# import utils
# numbers = [10, 3, 6, 2]
# print(utils.find_max(numbers))

# # 这里是一条更新 来自笔记本电脑

# # 这是另一条更新

# from ecommerce import shipping
# shipping.calc_shipping()

# import random
# # for i in range(3):
# #     print(random.randint(10, 20))

# members = ['John', 'Mary', 'Bob', 'Mosh']
# leader = random.choice(members)
# print(leader)

# import random


# class Dice:
#     def roll(self):
#         first = random.randint(1, 6)
#         second = random.randint(1, 6)
#         return first, second


# dice = Dice()
# print(dice.roll())


# from pathlib import Path

# path = Path()

# for i in path.glob(r'数据结构/*'):
#     print(i.name)

# x = Path(r'E:\临时porn\H265\Censored').iterdir()
# for p in x:
#     print(p.name)

# import openpyxl as xl
# from openpyxl.chart import BarChart, Reference


# def process_workbook(filename):
#     wb = xl.load_workbook(filename)
#     sheet = wb['Sheet1']
#     # cell = sheet['a1']
#     # cell = sheet.cell(1, 1)
#     # # print(sheet.max_row)

#     for row in range(2, sheet.max_row + 1):
#         cell = sheet.cell(row, 3)
#         corrected_price = cell.value * 0.9
#         corrected_price_cell = sheet.cell(row, 4)
#         corrected_price_cell.value = corrected_price

#     values = Reference(sheet,
#                        min_row=2,
#                        max_row=sheet.max_row,
#                        min_col=4,
#                        max_col=4)

#     chart = BarChart()
#     chart.add_data(values)
#     sheet.add_chart(chart, 'e2')
#     wb.save(filename)


# process_workbook(r"python\学习\自定义包\transactions.xlsx")
