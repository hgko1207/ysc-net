package org.onsemiro.ysc.net.service;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.NoticeFile;

public interface NoticeFileService extends CRUDService<NoticeFile, Integer> {

	boolean delete(List<NoticeFile> files);

}