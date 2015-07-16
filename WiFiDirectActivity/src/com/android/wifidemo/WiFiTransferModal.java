package com.android.wifidemo;

import java.io.Serializable;

public class WiFiTransferModal implements Serializable{

	private String FileName;
	private Long FileLength;
	private String InetAddress;


	public WiFiTransferModal(){
		
	}
	
	public WiFiTransferModal(String inetaddress){
		this.InetAddress = inetaddress;
	}

	public WiFiTransferModal(String name, Long filelength){
		this.FileName = name;
		this.FileLength = filelength;
//		this.FileData = in;
	}
	
	public String getInetAddress() {
		return InetAddress;
	}

	public void setInetAddress(String inetAddress) {
		InetAddress = inetAddress;
	}
	
	
	public Long getFileLength() {
		return FileLength;
	}
	public void setFileLength(Long fileLength) {
		FileLength = fileLength;
	}
	
	public String getFileName() {
		return FileName;
	}
	public void setFileName(String fileName) {
		FileName = fileName;
	}
	
	
	
}
