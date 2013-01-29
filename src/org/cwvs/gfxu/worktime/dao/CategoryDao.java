package org.cwvs.gfxu.worktime.dao;

import java.util.List;

import org.cwvs.gfxu.worktime.domain.Category;
import org.springframework.dao.DataAccessException;

public interface CategoryDao {

	List getCategoryList() throws DataAccessException;

  Category getCategory(String categoryId) throws DataAccessException;

}
