package cn.jbit.epet.test;

import cn.jbit.epet.dao.JDBCUtil;

public class test {
    public static void main(String[] args) {
        JDBCUtil jdbcUtil=JDBCUtil.getInitJDBCUtil(); 
		String sqlString="delete from pet where health>?  and love>?";
		Object[]  params= {95,85};
		jdbcUtil.executeUpdate(sqlString, params);
    }
}
