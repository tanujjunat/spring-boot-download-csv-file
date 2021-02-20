package com.reporting.files.csv.helper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import com.reporting.files.csv.model.Reporting;

public class CSVHelper {

  public static byte[] reportingToCSV(List<Reporting> reportings) {
    final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

    try (ByteArrayOutputStream out = new ByteArrayOutputStream();
        CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format);) {
      for (Reporting reporting : reportings) {
        List<String> data = Arrays.asList(
              String.valueOf(reporting.getId()),
              reporting.getTitle(),
              reporting.getDescription(),
              String.valueOf(reporting.isPublished())
            );

        csvPrinter.printRecord(data);
      }
      csvPrinter.flush();
      return out.toByteArray();
    } catch (IOException e) {
      throw new RuntimeException("fail to import data to CSV file: " + e.getMessage());
    }
  }
}
