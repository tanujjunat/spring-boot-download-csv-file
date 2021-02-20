package com.reporting.files.csv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reporting.files.csv.model.DownloadRequest;
import com.reporting.files.csv.model.DownloadResponse;
import com.reporting.files.csv.service.CSVService;

@Controller
@RequestMapping("/api/csv")
public class CSVController {

  @Autowired
  private CSVService fileService;
  
  @PostMapping(path = "/download", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DownloadResponse> getFile(DownloadRequest request) {
    DownloadResponse response = new DownloadResponse();
    response.setFileContent(fileService.load(request));
    response.setFileName("reporting.csv");

    return ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(response);
  }
}
