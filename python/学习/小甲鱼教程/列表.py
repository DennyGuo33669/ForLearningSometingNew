rhyme = [1, 2, 3, 4, 5, "上山打老虎"]
# print(rhyme)

# for each in rhyme:
#     print(each)


# print(rhyme[-1])

# 列表切片
# print(rhyme[0:3])
# print(rhyme[:3])
# print(rhyme[3:])

# print(rhyme[0:6:2])
# print(rhyme[::2])
# print(rhyme[::-1])


# 列表 增删改查
# heros = ["钢铁侠", "绿巨人"]
#
# 增加
# heros.append("黑寡妇")
# heros.extend(["鹰眼", "灭霸", "雷神"])
# print(heros)

# s = [1, 2, 3, 4, 5]
# s[len(s):] = [6]
# print(s)
# s[len(s):] = [7,8,9]
# print(s)

# # 插入

# s = [1, 3, 4, 5]
# s.insert(1, 2)
# print(s)
# s.insert(len(s), 6)
# print(s)

# # 删除
# heros.remove("灭霸")
# print(heros)

# heros.pop(2)
# print(heros)

# heros.clear()
# print(heros)

# 改变

heros = ["蜘蛛侠", "绿巨人", "黑寡妇", "鹰眼", "灭霸", "雷神"]
heros[4] = "钢铁侠"
print(heros)

heros[3:] = ["武松", "林冲", "李逵"]
print(heros)

# # nums = [3, 1, 9, 6, 8, 3, 5, 3]

# # nums.sort()
# # print(nums)

# # nums.reverse()
# # print(nums)

# nums = [3, 1, 9, 6, 8, 3, 5, 3]
# nums.sort(reverse=True)
# print(nums)

# 查找
nums = [2, 1, 9, 6, 8, 2, 5, 2]
print(nums.count(2))

print(heros.index("绿巨人"))
heros[heros.index("绿巨人")] = "神奇女侠"
print(heros)


nums_copy1 = nums.copy()
print(nums_copy1)
