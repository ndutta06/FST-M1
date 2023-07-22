# Write a recursive function to calculate the sum of numbers from 0 to 10
def sum(n):
    if n<=0:
        return 0
    else:
        return n+ sum(n-1)
print(f'sum of numbers from 0 to 10 is : {sum(10)}')