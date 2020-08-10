package org.onsemiro.ysc.net.service;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.Notice;
import org.onsemiro.ysc.net.domain.param.SearchParam;

public interface NoticeService extends CRUDService<Notice, Integer> {

	List<Notice> getList(SearchParam param);

}