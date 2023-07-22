# writing CSV files
import os

import pandas

userdata = {
    "Usernames": ["admin", "Charles", "Deku"],
    "Passwords": ["password", "Charl13", "AllMight"]
}

userdatadf = pandas.DataFrame(userdata)

print(userdatadf)

if os.path.exists('../Activity17data.csv'):
    os.remove('../Activity17data.csv')
    userdatadf.to_csv('../Activity17data.csv', index=False)
else:
    userdatadf.to_csv('../Activity17data.csv', index=False)
