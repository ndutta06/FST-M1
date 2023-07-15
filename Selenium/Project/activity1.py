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

# Assert

# Print the title of the new page
# print("New page title is: ", driver.title)
    title = driver.title

    if title == "SuiteCRM":
        print("Title matches 'SuiteCRM'.")

# Close the browser window
driver.quit()
