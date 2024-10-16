# Polynomial Operations

This project provides a set of operations for manipulating polynomials, including addition, subtraction, multiplication, derivation, and integration. The project is implemented in Java and uses Maven for dependency management, as well as JUnit testing for accurate results.

For more details about the implementation, please check the documentation in the repo.

## Features

- **Addition**: Add two polynomials.
- **Subtraction**: Subtract one polynomial from another.
- **Multiplication**: Multiply two polynomials.
- **Derivation**: Derive a polynomial.
- **Integration**: Integrate a polynomial.

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/flaviamarincau/polynomial-calc.git
    cd polynomial-calc
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

### Running the Application

You can run the application using your IDE (e.g., IntelliJ IDEA) or from the command line.

#### Using IntelliJ IDEA

1. Open the project in IntelliJ IDEA.
2. Navigate to `src/main/java/gui/UserAppController.java`.
3. Run the `UserAppController` class.

#### Using Command Line

1. Navigate to the project directory.
2. Run the following command:
    ```sh
    mvn exec:java -Dexec.mainClass="gui.UserAppController"
    ```

### Running Tests

To run the tests, use the following command:
```sh
mvn test

