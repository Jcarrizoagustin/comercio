package com.project.comercio.repositories;

import com.project.comercio.entities.Authority;
import com.project.comercio.utils.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findByName(AuthorityName name);
}
