package com.hospital.management;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByUsernameAndPassword(String username, String password);
}

