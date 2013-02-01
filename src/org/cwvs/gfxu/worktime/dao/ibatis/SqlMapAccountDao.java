package org.cwvs.gfxu.worktime.dao.ibatis;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.cwvs.gfxu.worktime.dao.AccountDao;
import org.cwvs.gfxu.worktime.domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * In this and other DAOs in this package, a DataSource property
 * is inherited from the SqlMapClientDaoSupport convenience superclass
 * supplied by Spring. DAOs don't need to extend such superclasses,
 * but it saves coding in many cases. There are analogous superclasses
 * for JDBC (JdbcDaoSupport), Hibernate (HibernateDaoSupport),
 * JDO (JdoDaoSupport) etc.
 *
 * <p>This and other DAOs are configured using Dependency Injection.
 * This means, for example, that Spring can source the DataSource
 * from a local class, such as the Commons DBCP BasicDataSource,
 * or from JNDI, concealing the JNDI lookup from application code.
 * 
 * @author Juergen Hoeller
 * @author Colin Sampaleanu
 */
public class SqlMapAccountDao extends SqlMapClientDaoSupport implements AccountDao {

  public User getAccount(String username) throws DataAccessException {
    return (User) getSqlMapClientTemplate().queryForObject("getAccountByUsername", username);
  }

  public User getAccount(String username, String password) throws DataAccessException {
    User account = new User();
    account.setUserName(username);
    account.setPassWord(password);
    return (User) getSqlMapClientTemplate().queryForObject("getAccountByUsernameAndPassword", account);
  }

  public void insertAccount(User account) throws DataAccessException {
    getSqlMapClientTemplate().insert("insertAccount", account);
    getSqlMapClientTemplate().insert("insertProfile", account);
    getSqlMapClientTemplate().insert("insertSignon", account);
  }

  public void updateAccount(User account) throws DataAccessException {
    getSqlMapClientTemplate().update("updateAccount", account, 1);
    getSqlMapClientTemplate().update("updateProfile", account, 1);
    if (account.getPassWord() != null && account.getPassWord().length() > 0) {
      getSqlMapClientTemplate().update("updateSignon", account, 1);
    }
  }
 
	public List getUsernameList() throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getUsernameList", null);
	}
	
	public static void main(String[] args) 
	{
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection c;
			try {
				c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9002", "sa", "");
			
				String sql = "select * from users";
				PreparedStatement st = c.prepareStatement(sql);
				
				ResultSet resultSet = st.executeQuery();
				//resultSet.setFetchSize(10);
				while(resultSet.next())
				{
					ResultSetMetaData md = resultSet.getMetaData();
					int count = md.getColumnCount();
					StringBuffer sb = new StringBuffer("");
					for(int i=1;i<=count;i++)
					{
						String columnName = md.getColumnName(i);
						sb.append(columnName);
						sb.append(":");
						sb.append(resultSet.getString(i));
						sb.append(" ");
					}
					System.out.println(sb);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
