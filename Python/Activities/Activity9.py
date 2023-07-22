# Get numbers and check first and last number are same
list1 = list(input("Enter first list of numbers in comma seperated:").split(','))
list2 = list(input("Enter second list of numbers in comma seperated:").split(','))
print('1st entered list :', list1)
print('2nd entered list :', list2)
list3 = []
for data in list1:
    if int(data) % 2 > 0:
        list3.append(data)
for data in list2:
    if int(data) % 2 == 0:
        list3.append(data)

print('New list is :', list3)
