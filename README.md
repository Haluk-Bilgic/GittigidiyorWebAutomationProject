# Gittigidiyor Case Study
This project is a case study that tests main functions of some pages on Gittigidiyor fo Web UI Automation.
## Language and Frameworks
* Java
* Selenium WebDriver
* Maven
* Junit
* POM Design Pattern
>     Page Object Model according to which I created a separate class for the pages of my application---
* Page Factory Design
>     Page Factory is a design which makes it easy to access the page object class---
* log4j for logging purpose
* Intellij IDE

## Test Steps

- The website www.gittigidiyor.com opens.
- Bilgisayar word is entered in the search box.
- The second page opens from the search results page.
- It is checked that the 2nd page is opened.
- A random product is selected from the exhibited products according to the result.
- Screenshot of the Product is taken.
- The product information and amount information of the selected product are written to the txt file.
- The selected product is added to the basket.
- The accuracy of the price on the product page and the price of the product in the basket is compared.
- It is verified that the quantity of products is 2 by increasing the number.
- The product is deleted from the basket and it is checked that the basket is empty.

