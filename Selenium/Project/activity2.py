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

    headerImage = driver.find_element(By.XPATH, "//img[@alt='SuiteCRM']")
    imageUrl = headerImage.get_attribute("src")
    print("URL of the header image: ", imageUrl);
# Close the browser window
driver.quit()
