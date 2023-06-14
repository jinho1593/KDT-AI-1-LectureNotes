def bigger_than_20(num):
    return  num > 20

def add_10(num):
    return num + 10

def times(num1, num2):
    return num1 * num2

def intersect(preList, postList):
    retList = []
    for x in preList:
        if x in postList:
            retList.append(x)
    return retList

def change(x):
    x = x[:] #원본을 복사했기 때문에 원본을 변경하지 않음
    x[0] = 'H'
    print("in function =", x)

def change2(x):
    x[0] = 'H'

#전역 변수
glob = 1
def xChgScope(num):
    global glob #global이 붙었기 때문에 아예 7로 바뀜
    glob = 7
    return glob + num

import random
import math
def function_test():
    numList = [res for res in range(10, 31, 5)]
    filteredNumList = filter(bigger_than_20, numList)

    for num in filteredNumList:
        print("element: {0}".format(num))

    print(filteredNumList)
    print(type(filteredNumList))

    print(list(filter(bigger_than_20, numList))) #같은
    print(list(filter(lambda i: i> 20, numList))) #내용

    print(numList)
    for i in map(add_10, numList):
        print("num: {0}".format(i))


    print(list(map((lambda i: i+10), numList)))
    print(times)
    print(times(10,10))

    function_address = times
    print(function_address(10, 10))

    list1 = "apple"
    list2 = "grape"
    list3 = "banana"

    print(intersect(list1, list2))
    print(intersect(list1, list3))

    wordList = ['J', 'A', 'M']
    print(wordList)

    change(wordList) #원본을 변경하지 않음
    print(wordList)

    change2(wordList)  # 원본을 변경함
    print(wordList)

    print(glob)
    print(xChgScope(3))
    print(glob)

    for _ in range(5):
        print(random.randrange(3, 7)) # 3, 4, 5, 6까지

    print(math.pow(3, 4))
    print(3 ** 4)

    print(math.sqrt(9))