package me.justeli.esqueleto;

/* Eli @ December 26, 2022 (creation) */
public final class SqlAdapter
{
    public static final String MARIADB = "org.mariadb.jdbc.MariaDbDataSource";
    public static final String MYSQL = "com.mysql.cj.jdbc.MysqlDataSource";
    public static final String SQLITE = "org.sqlite.SQLiteDataSource";
    public static final String POSTGRESQL = "org.postgresql.ds.PGSimpleDataSource";
    public static final String MSSQL = "com.microsoft.sqlserver.jdbc.SQLServerDataSource";
    public static final String H2 = "org.h2.jdbcx.JdbcDataSource";
}
