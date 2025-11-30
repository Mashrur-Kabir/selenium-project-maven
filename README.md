# Selenium Test Automation Framework

A modular, maintainable, and scalable **Selenium-based automation framework** built using **Java**, **TestNG**, and the **Page Object Model (POM)** design pattern.
It includes automated test coverage for **DemoQA** components and **SauceDemo** workflows, along with custom utilities, reusable base classes, and structured test suites.

---

## Key Features

### Page Object Model (POM)

* Every webpage has a dedicated class.
* Elements and actions are isolated for better maintenance.
* Easy to expand with new pages.

### TestNG Test Framework

* Structured tests using annotations (`@Test`, `@BeforeMethod`, etc.).
* Parallel test execution support.
* Assertions included.

---

## What This Framework Tests

### 🔹 DemoQA Automated Tests

| Category         | Test Examples                      |
| ---------------- | ---------------------------------- |
| Elements         | LinksTest, WebTableTest            |
| Forms            | CheckboxTest, RadioButtonTest      |
| Widgets          | DateTest, ScrollSelectDropdownTest |
| Modals           | ModalTest                          |
| Failure Handling | CaptureFailedScreenshotTest        |

### 🔹 SauceDemo Automated Tests

| Feature           | Tests        |
| ----------------- | ------------ |
| User Login        | LoginTests   |
| Product Inventory | ProductsTest |

---

## Requirements

* **Java 8+**
* **Maven**
* **TestNG**
* **Selenium WebDriver**
* (Optional) ChromeDriver / EdgeDriver installed locally

---

## ▶ Running Tests

### Run all tests:

```bash
mvn test
```

### Run a specific test class:

```bash
mvn -Dtest=LoginTests test
```

### Run using TestNG XML (if provided):

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

---

## How the Framework Works

### 1. BaseTest

* Launches WebDriver
* Loads configuration
* Manages browser setup & teardown

### 2. BasePage

* Wrapper for Selenium actions
* Click, type, wait, scroll, dropdown selection, etc.
* Reduces code repetition

### 3. Page Objects

* Each page contains **locators + page actions**
* Example: LoginPage → enter username → enter password → click login

### 4. Test Classes

* Use page methods
* Follow AAA pattern (Arrange – Act – Assert)

---

## Screenshot on Failure

Automated screenshot capturing is included via:

```
CaptureFailedScreenshotTest
```

Applicable during assertion failures.

---

## 🧩 Extending the Framework

To add a new test:

1. Create a new Page Object under `src/main/java/...`
2. Add locators + methods
3. Write a new test under `src/test/java/...`
4. Use TestNG annotations
5. Run via Maven

---

## Summary

This repository provides a **complete, scalable, and maintainable test automation framework** for UI testing with Selenium. It includes:

* Clean POM architecture
* Wide DemoQA coverage
* Functional SauceDemo login/product tests
* Utility-rich reusable structure
* Screenshot support
* Organized test suites

Perfect for academic submission, production use, or extending into CI/CD.

---
