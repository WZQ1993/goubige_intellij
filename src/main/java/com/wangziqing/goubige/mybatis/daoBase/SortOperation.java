package com.wangziqing.goubige.mybatis.daoBase;

import java.util.List;

import com.wangziqing.goubige.model.Sort;

public interface SortOperation {
	public void addSort(Sort sort);
	public List<Sort> getBigSorts();
}
