package com.kdu.JavaAssessment2.repo;

import com.kdu.JavaAssessment2.entity.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TenantRepository extends JpaRepository<Tenant,Long> {
}
