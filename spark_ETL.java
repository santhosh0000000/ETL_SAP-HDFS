package com.ssk.app;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class spark_ETL {
    public static void main(String[] args) {
        String host = "192.168.77.162";
        String port = "73645";
        String username = "BIG_DATA_USER";
        String password = "PYTFWJKHGKJKBGWE#@#$";
        String url = "jdbc:sap://" + host + ":" + port;

        String schema = "MODBAC";
        String tableName = "/MIUGPLD/SSK";
        String query = "(SELECT * FROM \"" + schema + "\".\"" + tableName + "\") as tmp";

        SparkSession spark = SparkSession
                .builder()
                .appName("SparkConnector")
                .master("local[*]")  // Use all available cores for local execution
                .getOrCreate();

        Dataset<Row> df = spark.read()
                .format("jdbc")
                .option("url", url)
                .option("user", username)
                .option("password", password)
                .option("dbtable", query)
                .load();

        // Specify the Hadoop Distributed File System (HDFS) output path
        String hdfsOutputPath = "hdfs://192.168.247.6:8020/test1/NES-TES1";

         df.write().option("header", "true").csv(hdfsOutputPath);

        spark.stop();
    }
}
