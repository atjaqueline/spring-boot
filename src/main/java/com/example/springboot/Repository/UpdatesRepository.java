package com.example.springboot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springboot.Update;
import java.util.List;

@Repository
public interface UpdatesRepository extends JpaRepository<Update, Long> {
    List<Update> findByAffectedTeam(String affected_team);
}