# ETL_SAP-HDFS
database, transform it (although no transformation is happening in this script), and then load it into a Hadoop Distributed File System (HDFS) as a CSV file. This process is often referred to as ETL (Extract, Transform, Load).

Here's a step-by-step explanation of the code:

Connection details for the SAP HANA database, such as host, port, username, and password, are defined.
The JDBC URL for the SAP HANA database is constructed using the host and port details.
The schema and table name for the data to be extracted from the SAP HANA database are defined.
A SQL query is constructed to retrieve all data from the specified SAP HANA table.
A SparkSession is built with the application name "SparkConnector" and is configured to use all available cores for local execution.
The spark.read() method is used to connect to the SAP HANA database using the JDBC URL, username, and password.
The SQL query is executed on the SAP HANA database and the result is loaded into a DataFrame.
The DataFrame is written as a CSV file to the specified HDFS path, with a header line included.
Finally, the SparkSession is stopped.
