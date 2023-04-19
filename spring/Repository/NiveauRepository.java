package com.test.demo.Repository;

import com.test.demo.Model.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NiveauRepository extends JpaRepository<Niveau,Integer> {
}
