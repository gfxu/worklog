package org.cwvs.gfxu.worktime.dao.ibatis;

import java.util.List;

import org.cwvs.gfxu.worktime.dao.CategoryDao;
import org.cwvs.gfxu.worktime.domain.Category;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class SqlMapCategoryDao extends SqlMapClientDaoSupport implements CategoryDao {

  public List getCategoryList() throws DataAccessException {
    return getSqlMapClientTemplate().queryForList("getCategoryList", null);
  }

  public Category getCategory(String categoryId) throws DataAccessException {
    return (Category) getSqlMapClientTemplate().queryForObject("getCategory", categoryId);
  }

}
