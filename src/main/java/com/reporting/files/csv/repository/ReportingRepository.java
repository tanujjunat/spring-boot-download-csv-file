package com.reporting.files.csv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reporting.files.csv.model.Reporting;

public interface ReportingRepository extends JpaRepository<Reporting, Long> {
}
