# write Excel file
import pandas
import os
from pandas import ExcelWriter

# filepath
filepath = '../Activity19data.xlsx'
# Data dict
inputdata = {
    'FirstName': ["Satvik", "Avinash", "Lahri"],
    'LastName': ["Shah", "Kati", "Rath"],
    'Email': ["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
    'PhoneNumber': ["4537829158", "4892184058", "4528727830"]
}

# convert to data frame
df = pandas.DataFrame(inputdata)

# print dataframe
print(df)

# create excel object
writer = ExcelWriter(filepath)

# create excel & add data
df.to_excel(writer, 'Sheet1', index=False)

# close file
writer.close()
