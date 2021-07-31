package br.com.cdb.core.model.phone.network.repository;

import br.com.cdb.core.model.phone.network.Network;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepository extends JpaRepository<Network, Long> {
}