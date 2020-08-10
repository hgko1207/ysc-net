package org.onsemiro.ysc.net.service;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.Family;
import org.onsemiro.ysc.net.domain.param.SearchParam;

public interface FamilyService extends CRUDService<Family, Integer> {

	List<Family> getList(SearchParam param);

}