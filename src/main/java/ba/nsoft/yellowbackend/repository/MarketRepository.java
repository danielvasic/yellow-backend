package ba.nsoft.yellowbackend.repository;

import ba.nsoft.yellowbackend.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarketRepository extends JpaRepository<Market, String> {}
