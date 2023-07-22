# Write a function sum() such that it can accept a list of elements and print the sum of all elements

listnumers = list(input('Enter the list of numbers to sum by comma seperated :').split(','))


def sum(n):
    total = 0
    for x in n:
        total += int(x)
    return total

print(f'sum of given list is :{sum(listnumers)}')
