package lk.himash.employeeservice.repository;

import lk.himash.employeeservice.model.EmployeeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMasterRepository extends JpaRepository<EmployeeMaster, Integer> {
}
