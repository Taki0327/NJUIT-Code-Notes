package cn.jbit.epet.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JDBCUtil {
	private static String name = "root";
    private static String password = "nzzfl2";
    private static String url = "jdbc:mysql://localhost:3306/pett?userSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&allowPublicKeyRetrieval=true";
	private static Connection connnection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	private static JDBCUtil jdbcUtil = null; 
    //懒汉式加载
	public static  synchronized JDBCUtil getInitJDBCUtil() {
	    if (jdbcUtil == null) {
				jdbcUtil = new JDBCUtil();   //生成一个JDBCUtil对象
			}
	    return jdbcUtil;
	}
	public JDBCUtil(){
		
	}
	//加载驱动
	static{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//连接数据库
	public Connection getConnection(){
		
		try {
			connnection=DriverManager.getConnection(url,name,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return connnection;
	}
	
	//执行增删改的方法
	public int executeUpdate(String sql){
		int affectedLine=0;
		try {
			preparedStatement=getConnection().prepareStatement(sql);
			affectedLine=preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll();
		}
		
		return affectedLine;
	}


public int executeUpdate(String sql,Object[] params){
	int affectedLine = 0;
	try{
		connnection=getConnection();
		preparedStatement=connnection.prepareStatement(sql);
	    for(int i=0;i<params.length;i++){
	    	preparedStatement.setObject(i+1, params[i]);
	    }
	    affectedLine=preparedStatement.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
	}finally{
		closeAll();
	}
	return affectedLine;
    }
/**
 * 
 * @param sql
 * @param params
 * @return  resultSet
 */
  private ResultSet executeQueryRS(String sql,Object[] params){
	  connnection=getConnection();
	  try {
		preparedStatement=connnection.prepareStatement(sql);
		for(int i=0;i<params.length;i++){
		    preparedStatement.setObject(i+1, params[i]);	
		}
		resultSet=preparedStatement.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return resultSet;
  }
  public ArrayList executeQuery2(String sql,Object[] params) throws SQLException
  {
	  ArrayList list=new ArrayList();
	  resultSet=executeQueryRS(sql, params);
	  while(resultSet.next())
	  {
	  }
	  return list;
  }
  public List<HashMap> executeQuery(String sql,Object[] params){
	  ResultSet rs=executeQueryRS(sql, params);
	  //下面要做的就是要把rs中的数据放入List列表中
	  ResultSetMetaData rsmd = null;  
	  int columnCount=0;
	  try {
		rsmd = rs.getMetaData(); //取rs中的列 
	    columnCount = rsmd.getColumnCount(); //取列的数目 	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	ArrayList<HashMap> list = new ArrayList<HashMap>();
	try {
		while(rs.next()){
			HashMap<String, Object> map=new HashMap<String, Object>();
		    for(int i=1;i<=columnCount;i++){
		    	map.put(rsmd.getColumnLabel(i),rs.getObject(i));
		    }
		    list.add(map);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		closeAll();
	}
	return list;
  } 
  
 

  public void closeAll(){
    	if(resultSet!=null){
    		try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(preparedStatement!=null){
    	    try {
				preparedStatement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	if (connnection!=null){
    		try {
				connnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
}
