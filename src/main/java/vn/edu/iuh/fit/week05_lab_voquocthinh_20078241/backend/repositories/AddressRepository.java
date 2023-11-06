package vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.week05_lab_voquocthinh_20078241.backend.models.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
