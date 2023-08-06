# ETL_SAP-HDFS
database, transform it (although no transformation is happening in this script), and then load it into a Hadoop Distributed File System (HDFS) as a CSV file. This process is often referred to as ETL (Extract, Transform, Load).

Here's a step-by-step explanation of the code:

1. Package Declaration
The code is part of the package com.ssk.app.

2. Importing Libraries
The necessary Spark classes for working with Datasets and Spark sessions are imported.

3. Main Class Definition
The main class spark_ETL is defined, and the main method is declared.

4. Defining SAP Database Connection Parameters
Connection parameters for the SAP database are defined, such as host, port, username, password, schema, and table name. The JDBC URL is constructed using the host and port.

5. Constructing SQL Query
A SQL query is created to select all records from the specified schema and table in the SAP database.

6. Creating Spark Session
A SparkSession is created using the SparkSession.builder() method with the following configuration:

appName("SparkConnector"): Sets the application name.
master("local[*]"): Specifies that the code should run locally, using all available cores.
7. Loading Data from SAP Database
Data is loaded from the SAP database into a Spark DataFrame using the JDBC connection parameters and the SQL query. The format("jdbc") method specifies the use of the JDBC connection.

8. Specifying HDFS Output Path
The output path for the resulting CSV file in HDFS is defined.

9. Writing Data to HDFS as CSV
The DataFrame is written to the specified HDFS path as a CSV file. The option("header", "true") part ensures that the header (column names) is included in the output file.

10. Stopping Spark Session
The Spark session is stopped using spark.stop(), which releases resources associated with the session.

Considerations
Sensitive Information: The code includes sensitive information such as the database username and password. It's advisable to handle these securely, e.g., using configuration files or environment variables.
Error Handling: The code doesn't include error handling, so any issues (e.g., connection failures, SQL errors) would lead to unhandled exceptions.
JDBC Driver: The code assumes that the necessary JDBC driver for SAP is available in the classpath.
Dependencies: The appropriate dependencies for Spark and the JDBC driver must be included in the project.
