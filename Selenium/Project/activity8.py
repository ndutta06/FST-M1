from selenium import webdriver
from selenium.webdriver.common.by import By

from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
import time

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())
#locator = Locator()

# Start the Driver
with webdriver.Firefox(service=service) as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")

    # Print the title of the page
    print("Page title is: ", driver.title)
    # Find the username field
    username = driver.find_element(By.ID, "user_name")
    # Find the password field
    password = driver.find_element(By.ID, "username_password")

    # Enter the given credentials
    # Enter username
    username.send_keys("admin")
    # Enter password
    password.send_keys("pa$$w0rd")

    # Find the login button
    login = driver.find_element(By.ID, "bigbutton")
    login.click()
    # Print the login message
    message = driver.find_element(By.CLASS_NAME, "hidden-xs")
    print("Login message: ", message.text)
    # Navigate to Sales.

    Sales = WebDriverWait(driver,10).until(EC.visibility_of_element_located((By.ID,"grouptab_0")))
    Sales.click()

    # Find and click the Sales >> Account submenu
    Account_submenu = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, "moduleTab_9_Accounts")))
    Account_submenu.click()
    # Print the Account Page message
    time.sleep(5)
    #total odd data
    oddRows = driver.find_elements(By.XPATH,("//*[@class='oddListRowS1']"))
    print("Total odd data rows found in table:" ,len(oddRows))

    #loop
    for i in range(0, 5):
        row = oddRows[i]

        name = row.find_element(By.XPATH, ".//td[3]").text  # Assuming the name is in the third column (td[3])
        print("Name:", name)
    #close browser
    driver.quit()