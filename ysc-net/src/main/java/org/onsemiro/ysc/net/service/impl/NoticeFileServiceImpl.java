package org.onsemiro.ysc.net.service.impl;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.NoticeFile;
import org.onsemiro.ysc.net.repository.NoticeFileRepository;
import org.onsemiro.ysc.net.service.NoticeFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class NoticeFileServiceImpl implements NoticeFileService {
	
	@Autowired
	private NoticeFileRepository noticeFileRepository;

	@Override
	public NoticeFile get(Integer id) {
		return noticeFileRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<NoticeFile> getList() {
		return noticeFileRepository.findAll();
	}

	@Override
	public boolean regist(NoticeFile domain) {
		if (isNew(domain)) {
			return noticeFileRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(NoticeFile domain) {
		if (!isNew(domain)) {
			return noticeFileRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Integer id) {
		noticeFileRepository.deleteById(id);
		return true;
	}

	private boolean isNew(NoticeFile domain) {
		return !noticeFileRepository.existsById(domain.getId());
	}

	@Override
	public boolean delete(List<NoticeFile> files) {
		noticeFileRepository.deleteInBatch(files);
		return true;
	}
}
