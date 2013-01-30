package org.cwvs.gfxu.worktime.dao;

import java.util.List;

import org.cwvs.gfxu.worktime.domain.User;
import org.springframework.dao.DataAccessException;

public interface AccountDao {

  User getAccount(String username) throws DataAccessException;

  User getAccount(String username, String password) throws DataAccessException;

  void insertAccount(User account) throws DataAccessException;

  void updateAccount(User account) throws DataAccessException;

	List getUsernameList() throws DataAccessException;

}
