package com.reporting.files.csv.service;

import com.reporting.files.csv.model.DownloadRequest;

public interface CSVService {
  
  public byte[] load(DownloadRequest request);
}
