import time

from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

# Set up the Firefox Driver with WebDriverManger
service = FirefoxService(GeckoDriverManager().install())

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

    # Find and click the Sales >> Lead submenu
    Leads_submenu = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, "moduleTab_9_Leads")))
    Leads_submenu.click()
    time.sleep(5)

    # for i in range(0, 5):
    Row_element = driver.find_elements(By.XPATH,("//table[contains(@class,'responsive')]/tbody/tr"))

    #loop
    for i in range(0, len(Row_element), 1):
        row = Row_element[i]
        name = row.find_element(By.XPATH, ".//td[3]").text
        user = row.find_element(By.XPATH, ".//td[8]").text
        print("Name displayed in Row number is: ",name, "and respective User ID is: ",user)

        # Stop after printing the names of the first 5 odd-numbered rows
        if i >= 9:
            break

    driver.quit()