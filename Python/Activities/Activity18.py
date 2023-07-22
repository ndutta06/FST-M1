# read CSV file
import pandas
import os

filepath = '../Activity18data.csv'
if os.path.exists(filepath):
    print('File exists..you can see the data below')
    df = pandas.read_csv(filepath)
    print('CSV data below')
    print(df)
    print('Usernames values are :', end='')
    print(df['Usernames'].values)
    print('2nd row username is : ' + df['Usernames'][1] + ' and password is :' + df['Passwords'][1])
    print('Username column data in asending order :', end='\n')
    print(df.sort_values('Usernames'))
    print('password values in dscsending order :', end='\n')
    print(df.sort_values('Passwords', ascending=False))
else:
    print('File not exists ,please create file')
