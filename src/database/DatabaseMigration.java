package database;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class DatabaseMigration {

    public static void main(String[] args) {
        try {
            // Get the database connection
            Connection connection = DatabaseConnection.getConnection();

            // Create a Statement
            Statement statement = connection.createStatement();

            // SQL statements to create tables
            String[] createTableStatements = {
                    "CREATE TABLE Customer (CustomerID INT PRIMARY KEY, FirstName VARCHAR(50), LastName VARCHAR(50), Email VARCHAR(100), PhoneNumber VARCHAR(20), Address VARCHAR(255));",
                    "CREATE TABLE Account (AccountID INT PRIMARY KEY, CustomerID INT, AccountType VARCHAR(20), Balance DECIMAL(15, 2), FOREIGN KEY (CustomerID) REFERENCES Customer(CustomerID));",
                    "CREATE TABLE Transaction (TransactionID INT PRIMARY KEY, AccountID INT, TransactionType VARCHAR(10), Amount DECIMAL(15, 2), TransactionDate TIMESTAMP, FOREIGN KEY (AccountID) REFERENCES Account(AccountID));",
                    "CREATE TABLE Branch (BranchID INT PRIMARY KEY, BranchName VARCHAR(50), Location VARCHAR(100));",
                    "CREATE TABLE Employee (EmployeeID INT PRIMARY KEY, FirstName VARCHAR(50), LastName VARCHAR(50), Position VARCHAR(50), BranchID INT, FOREIGN KEY (BranchID) REFERENCES Branch(BranchID));",
                    "CREATE TABLE Loan (LoanID INT PRIMARY KEY, AccountID INT, LoanAmount DECIMAL(15, 2), InterestRate DECIMAL(5, 2), LoanTermMonths INT, FOREIGN KEY (AccountID) REFERENCES Account(AccountID));"
            };

            // Execute SQL statements
            for (String sql : createTableStatements) {
                statement.executeUpdate(sql);
            }

            System.out.println("Tables created successfully!");

            // Close resources
            statement.close();

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
