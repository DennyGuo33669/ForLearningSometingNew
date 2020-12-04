def find_max(numbers):
    # """
    # 查找最大数
    # """
    max = numbers[0]
    for number in numbers:
        if number > max:
            max = number
    return max
