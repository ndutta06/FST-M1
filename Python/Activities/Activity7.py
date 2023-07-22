# Sum all the numbers given by users
list1 = list(input("Enter the list of numbers in comma seperated:").split(','))
total = 0
for item in list1:
    total += int(item)
print('sum is : ' + str(total))
