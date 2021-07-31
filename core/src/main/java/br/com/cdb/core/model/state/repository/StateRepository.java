package br.com.cdb.core.model.state.repository;

import br.com.cdb.core.model.state.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
}