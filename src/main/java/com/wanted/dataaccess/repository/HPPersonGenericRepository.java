package com.wanted.dataaccess.repository;

import com.wanted.dataaccess.entity.HPPersonGeneric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HPPersonGenericRepository extends JpaRepository<HPPersonGeneric, Long> {

    HPPersonGeneric getByPersonId(String personId);
}
