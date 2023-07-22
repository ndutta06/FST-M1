# Get numbers and check first and last number are same
list1 = list(input("Enter the list of numbers in comma seperated:").split(','))
print("entered list is:", list1)
if list1[0] == list1[len(list1) - 1]:
    print('true')
else:
    print('false')
