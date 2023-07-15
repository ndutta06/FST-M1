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
# Find the navigation and print its colour
    ToolBar = driver.find_element(By.ID, "toolbar")
    print("The color of the navigation menu is :" , ToolBar.value_of_css_property("color"))
    ToolBar1 = driver.find_element(By.ID, "toolbar")
    print("The navigation menu is : ",ToolBar1.text)

#close the browser
driver.quit()