package com.reporting.files.csv.model;

public class DownloadResponse {
	
	private String fileName;
	private byte[] fileContent;
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileContent() {
		return fileContent;
	}
	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}
	
	

}
