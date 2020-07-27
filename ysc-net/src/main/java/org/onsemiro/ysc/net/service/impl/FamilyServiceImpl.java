package org.onsemiro.ysc.net.service.impl;

import java.util.List;

import org.onsemiro.ysc.net.domain.db.Family;
import org.onsemiro.ysc.net.repository.FamilyRepository;
import org.onsemiro.ysc.net.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FamilyServiceImpl implements FamilyService {
	
	@Autowired
	private FamilyRepository familyRepository;

	@Override
	public Family get(Integer id) {
		return familyRepository.findById(id).get();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Family> getList() {
		return familyRepository.findAll();
	}

	@Override
	public boolean regist(Family domain) {
		if (isNew(domain)) {
			return familyRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(Family domain) {
		if (!isNew(domain)) {
			return familyRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Integer id) {
		familyRepository.deleteById(id);
		return true;
	}

	private boolean isNew(Family domain) {
		return !familyRepository.existsById(domain.getId());
	}
}
