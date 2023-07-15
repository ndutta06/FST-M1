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
# locate the footer
    footerText = driver.find_element(By.ID, "admin_options")
# print the copyright text in the footer
    print("copyright text in the footer: ", footerText.text)
# Close the browser
driver.quit();
