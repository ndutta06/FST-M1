# Tuple -Get numbers and print only divide by 5
list1 = tuple(input("Enter first list of numbers in comma seperated:").split(','))
print('Entered numbers in tuple list :', list1)
print('Numbers which are divisible by 5 is :',end='')
for data in list1:
    if int(data) % 5 == 0:
        print(data,end=' ')
