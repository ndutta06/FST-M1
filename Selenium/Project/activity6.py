from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.firefox.service import Service as FirefoxService
from webdriver_manager.firefox import GeckoDriverManager

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
#Locate Menu Item
    MenuCheck = driver.find_element(By.ID,"grouptab_3")
    print("Menu Item exist as : ",MenuCheck.text)

#close browser
driver.quit()