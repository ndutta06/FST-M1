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

# Find and click the Leads submenu
    leads_submenu = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.ID, "moduleTab_9_Leads")))
    leads_submenu.click()
#Navigate to Additional info icon

    icon = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.XPATH,"//span[@class='suitepicon suitepicon-action-info']")))
    icon.click()
    popupElement = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.XPATH,"//span[@class='phone']")))

    print("Mobile:" , popupElement.text)
# close the browser
driver.quit()