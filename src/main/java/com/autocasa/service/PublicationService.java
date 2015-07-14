package com.autocasa.service;

import org.springframework.data.domain.Page;

import com.autocasa.model.Publication;

public interface PublicationService {

	Page<Publication> getPublication(Integer pageNumber);

}