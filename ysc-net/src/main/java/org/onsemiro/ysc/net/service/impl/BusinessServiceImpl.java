package org.onsemiro.ysc.net.service.impl;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.Business;
import org.onsemiro.ysc.net.domain.param.SearchParam;
import org.onsemiro.ysc.net.repository.BusinessRepository;
import org.onsemiro.ysc.net.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class BusinessServiceImpl implements BusinessService {
	
	@Autowired
	private BusinessRepository businessRepository;

	@Override
	public Business get(Integer id) {
		return businessRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Business> getList() {
		return businessRepository.findAll();
	}

	@Override
	public boolean regist(Business domain) {
		if (isNew(domain)) {
			return businessRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(Business domain) {
		if (!isNew(domain)) {
			return businessRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Integer id) {
		businessRepository.deleteById(id);
		return true;
	}

	private boolean isNew(Business domain) {
		return !businessRepository.existsById(domain.getId());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Business> getList(SearchParam param) {
		return businessRepository.findAll();
	}
}
