import re


def match_id(txt_content):
    msg = {
        'id': [],
        'num': 0,
        'dismatch': [],
        'has_chinese': []
    }
    temp = ''
    for i in txt_content['content']:
        try:
            result = re.search(r'[a-zA-Z]+-[0-9]+', i).group()
            msg['id'].append(result.upper())
            msg['num'] += 1
            try:
                if re.search(r'[a-zA-Z]+-[0-9]+-[Cc]|[a-zA-Z]+-[0-9]+ch|[a-zA-Z]+-[0-9]+[cC]', i).group():
                    msg['has_chinese'].append(result.upper())
                    print(result+"  有中文")
                # print(result)
            except AttributeError:
                pass

        except AttributeError:
            # print(f'未成功匹配:{i}')
            try:
                if re.search(r'[a-zA-Z]+[0-9]{2,}', i).group():
                    前 = re.search(r'[a-zA-Z]+', i).group()
                    后 = re.search(r'[0-9]+', i).group()
                    temp = f"{前}-{后}"
                    msg['id'].append(temp)
                    print(f"{i.strip()}数据不完整 ====> {temp}")
                    msg['num'] += 1
                    if re.search(r'[a-zA-Z]+[0-9]{2,}[cC]', i).group():
                        msg['has_chinese'].append(temp.upper())
                        print(temp+"  有中文")
            except AttributeError:
                msg['dismatch'].append(i)

    if msg['dismatch'] != []:
        print("==============================================================")
        print()
        print(f"匹配失败:\n{msg['dismatch']}")

    print()
    print(f"============数据清理完毕================")
    print()
    print()
    return msg
