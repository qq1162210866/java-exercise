package priv.psq.old.exceptiontrain;

import java.sql.SQLException;

/**
 * ExceptionTrain1.java
 * Description: 异常练习
 *
 * @author Peng Shiquan
 * @date 2020/5/4
 */
public class ExceptionTrain1 {
    public void throwSQLException() throws SQLException {
        try {
            throw new SQLException("这是一个测试demo");
        } catch (SQLException e) {
        }

    }
}
