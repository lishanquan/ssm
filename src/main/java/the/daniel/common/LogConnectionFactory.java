package the.daniel.common;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: Daniel
 * @Date: 2019/1/15 15:46
 */
public class LogConnectionFactory {

    private static DruidDataSource dataSource;

    private static Logger logger = LogManager.getLogger(LogConnectionFactory.class);

    static {
        //加载属性
        Properties props = loadProperties();
        //初始化数据源
        dataSource = new DruidDataSource();
        //装配参数
        dataSource.setDriverClassName(props.getProperty("driver"));
        dataSource.setUrl(props.getProperty("url"));
        dataSource.setUsername(props.getProperty("username"));
        dataSource.setPassword(props.getProperty("password"));
        dataSource.setInitialSize(Integer.valueOf(props.getProperty("initialSize")));
        dataSource.setMinIdle(Integer.valueOf(props.getProperty("minIdle")));
        dataSource.setMaxActive(Integer.valueOf(props.getProperty("maxActive")));
        dataSource.setMaxWait(Long.valueOf(props.getProperty("maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Long.valueOf(props.getProperty("timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(props.getProperty("minEvictableIdleTimeMillis")));
        dataSource.setValidationQuery(props.getProperty("validationQuery"));
        dataSource.setTestWhileIdle(Boolean.valueOf(props.getProperty("testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(props.getProperty("testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(props.getProperty("testOnReturn")));
        dataSource.setPoolPreparedStatements(Boolean.valueOf(props.getProperty("poolPreparedStatements")));
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(Integer.valueOf(props.getProperty("maxPoolPreparedStatementPerConnectionSize")));
        try{
            dataSource.setFilters(props.getProperty("filters"));
        }catch (Exception e){
            logger.error(e);
        }
//        dataSource.setConnectionProperties("config.decrypt=true;config.decrypt.key="+String.valueOf(props.getProperty("publicKey")));
    }

    private static Properties loadProperties(){
        Properties props = new Properties();
        try {
            InputStream stream = LogConnectionFactory.class.getClassLoader().getResourceAsStream("log-db.properties");
            props.load(stream);
        } catch (FileNotFoundException e) {
            logger.error("读取配置文件异常",e);
        } catch(IOException ie){
            logger.error("读取配置文件时IO异常",ie);
        }
        return props;

    }

    /**
     * 取得连接池中的连接
     * @return
     */
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            logger.error("[错误日志记录] - 连接池获取异常！ -->> ",e);
        }
        return conn;
    }

}
