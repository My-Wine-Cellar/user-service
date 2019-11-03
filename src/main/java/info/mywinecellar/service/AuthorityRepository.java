package info.mywinecellar.service;

import info.mywinecellar.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}
