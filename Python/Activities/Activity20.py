# read Excel file
import pandas
import os
from pandas import ExcelWriter

# filepath
filepath = '../Activity20data.xlsx'
# Data dict

# convert to data frame
df = pandas.read_excel(filepath, sheet_name='Sheet1')

# print dataframe
print(df)

# Print the number of rows and columns
print(f'number of rows and columns is {df.shape}')

# Print the data in the emails column only
print('Data in the email column :', end='')
print(df['Email'].values)

# Sort the data based on FirstName in ascending order and print the data
print('Data after ascending FirstName :', end='\n')
print(df.sort_values('FirstName'))
