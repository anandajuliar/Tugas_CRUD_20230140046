package com.tugas.tugasktp.repository;

import com.tugas.tugasktp.model.Ktp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KtpRepository extends JpaRepository<Ktp, Integer> {
    boolean existsByNomorKtp(String nomorKtp);
}