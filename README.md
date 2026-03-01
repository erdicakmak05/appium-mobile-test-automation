# Appium Mobile Test Automation

Mobile test automation framework for Android and iOS using Appium with Cucumber BDD and TestNG.

## Tech Stack

- **Java 17**
- **Appium 9.3** - Mobile automation
- **Selenium 4.27** - WebDriver support
- **Cucumber 7.20** - BDD framework
- **TestNG** - Test runner
- **UiAutomator2** - Android automation engine
- **XCUITest** - iOS automation engine
- **Log4j2** - Logging framework

## Project Structure

```
├── App/                            # Application binaries (.apk)
├── configuration.properties        # Device and app configuration
└── src/test/
    ├── java/
    │   ├── pages/android/          # Android Page Objects
    │   ├── runner/                 # TestNG Cucumber runner
    │   ├── stepdefinitions/        # Step definitions + Hooks
    │   └── utilities/              # Driver, ConfigReader, ReusableMethods
    └── resources/
        └── features/               # Gherkin feature files
```

## Features

- **Android & iOS support** with platform-specific drivers
- **Thread-safe drivers** with `ThreadLocal`
- **Custom mobile gestures** - scroll, long press, iOS-specific interactions
- **Page Object Model** with Appium PageFactory
- **UiAutomator2** scroll into view support
- **Configurable** via properties file and environment variables

## Prerequisites

- Java 17+
- Maven 3.8+
- Appium Server 2.x (`npm install -g appium`)
- Android SDK / Xcode
- Android Emulator or physical device

## Setup

1. Start Appium server: `appium`
2. Start Android emulator or connect device
3. Update `configuration.properties` with your device details

## Running Tests

```bash
# Run all tests
mvn clean test

# Run specific tag
mvn clean test -Dcucumber.filter.tags="@smoke"
```

## Configuration

Update `configuration.properties` for your environment:

```properties
automationName=UiAutomator2
platformName=android
platformVersion=11.0
deviceName=Emulator
appPath=/path/to/your/app.apk
```
