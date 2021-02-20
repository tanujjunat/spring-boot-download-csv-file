package com.reporting.files.csv.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reporting.files.csv.helper.CSVHelper;
import com.reporting.files.csv.model.DownloadRequest;
import com.reporting.files.csv.model.Reporting;
import com.reporting.files.csv.repository.ReportingRepository;
import com.reporting.files.csv.service.CSVService;

@Service
public class CSVServiceImpl implements CSVService {

  @Autowired
  ReportingRepository repository;
  
  public byte[] load(DownloadRequest request) {
	  
    List<Reporting> reportings = repository.findAll();

    return CSVHelper.reportingToCSV(reportings);
    
  }
}
