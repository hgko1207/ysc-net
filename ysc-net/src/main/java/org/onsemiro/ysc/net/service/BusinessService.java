package org.onsemiro.ysc.net.service;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.Business;
import org.onsemiro.ysc.net.domain.param.SearchParam;

public interface BusinessService extends CRUDService<Business, Integer> {

	List<Business> getList(SearchParam param);

}