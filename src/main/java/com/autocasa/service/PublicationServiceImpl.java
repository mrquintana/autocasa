package com.autocasa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.autocasa.model.Publication;
import com.autocasa.repositories.PublicationRepository;

@Service
@Transactional
public class PublicationServiceImpl implements PublicationService {

	private static final int PAGE_SIZE = 16;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	/* (non-Javadoc)
	 * @see com.autocasa.service.PublicationService#getPublication(java.lang.Integer)
	 */
	@Override
	public Page<Publication> getPublication(Integer pageNumber ){
		PageRequest request = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "price");
		return publicationRepository.findAll(request);
	}
}
