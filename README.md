# UI testing con SeleniumWebDriver (Cucumber - Allure Report)  

  🧪 Portfolio BDD — Test Automation Framework

Automation framework built with **Java + Selenium + Cucumber** following the BDD methodology and Page Object Model pattern. Developed as a portfolio project to demonstrate end-to-end testing skills on a real e-commerce application.

---

## 🚀 Tech Stack

| Tool | Purpose |
|---|---|
| Java 22 | Main language |
| Selenium WebDriver 4 | Browser automation |
| Cucumber 7 | BDD / Gherkin scenarios |
| TestNG | Test runner |
| Allure Reports | Test reporting |
| GitHub Actions | CI/CD pipeline |
| Maven | Dependency management |

---

## 🌐 Application Under Test

**[Practice Software Testing](https://practicesoftwaretesting.com/)** — open e-commerce platform designed specifically for automation practice.

---

## 📁 Project Structure

```
src/
└── test/
    ├── java/
    │   ├── base/
    │   │   ├── DriverFactory.java      # ThreadLocal WebDriver management
    │   │   └── BaseTest.java           # Allure screenshot attachment
    │   ├── pages/
    │   │   ├── Menu.java               # Navigation & categories
    │   │   ├── HomePage.java           # Search & product listing
    │   │   ├── HandtoolsCategory.java  # Sort & filter interactions
    │   │   ├── LoginPage.java          # Authentication page
    │   │   └── Cart.java               # Checkout flow
    │   └── steps/
    │       ├── Hooks.java              # @Before / @After lifecycle
    │       ├── E2ESteps.java           # Purchase flow steps
    │       ├── LoginSteps.java         # Auth steps
    │       └── Filters.java            # Filter & sort steps
    └── resources/
        └── features/
            ├── e2e.feature             # End-to-end purchase flow
            ├── filters.feature         # Category filter & price sort
            └── login.feature           # Authentication scenarios
```

---

## ✅ Test Scenarios

### 🔐 Authentication (`login.feature`)
- Successful login with valid credentials
- Error handling with invalid email
- Error handling with wrong password

### 🛒 End-to-End Purchase (`e2e.feature`)
- Search product → add to cart → checkout → payment confirmation
- Parameterized with `Scenario Outline` for multiple data sets

### 🔽 Filters & Sorting (`filters.feature`)
- Filter products by category (Hand Tools)
- Sort products by price high to low and validate descending order

---

## 📊 Allure Reports

This project generates visual test reports with Allure.

**Run tests and generate report locally:**

```bash
mvn test
allure serve target/allure-results
```

> Allure must be installed. See [Allure CLI installation](https://allurereport.org/docs/install/).

---

## ⚙️ CI/CD — GitHub Actions

The pipeline runs automatically **every Tuesday morning** and can also be triggered manually.

```yaml
on:
  schedule:
    - cron: '0 9 * * 2'   # Every Tuesday at 9:00 AM UTC
  workflow_dispatch:        # Manual trigger
```

The pipeline:
1. Checks out the repository
2. Sets up Java 22
3. Runs all tests with Maven
4. Uploads Allure results as artifacts

---

## ▶️ Run Locally

**Prerequisites:** Java 22, Maven, Chrome browser

```bash
# Clone the repository
git clone https://github.com/your-username/your-repo.git
cd your-repo

# Run all tests
mvn test

# Run a specific feature
mvn test -Dcucumber.filter.tags="@login"
```

---

## 🏗️ Design Patterns

**Page Object Model (POM)** — each page has its own class with locators and methods, keeping steps clean and readable.

**ThreadLocal DriverFactory** — thread-safe WebDriver management, ready for parallel execution.

**Shared state via constructor injection** — step classes receive the driver through `DriverFactory.getDriver()`, avoiding null references across Cucumber step classes.

---

## 📝 Notes

- This is a **portfolio project** focused on demonstrating BDD automation skills
- Logging with Log4j is not included by design — the project is intentionally kept simple and readable
- The test suite is small and targeted, covering the most representative scenarios of a real e-commerce flow

---

## 👤 Author

**[Lujan Torres]**  
[LinkedIn](https://www.linkedin.com/in/malujantorres/) 

