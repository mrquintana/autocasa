package com.autocasa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.autocasa.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long>{

}
