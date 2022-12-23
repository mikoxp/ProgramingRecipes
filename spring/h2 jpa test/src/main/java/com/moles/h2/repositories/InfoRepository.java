package com.moles.h2.repositories;

import com.moles.h2.entities.Info;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface InfoRepository extends PagingAndSortingRepository<Info, Integer> {

    List<Info> findAll();
}
