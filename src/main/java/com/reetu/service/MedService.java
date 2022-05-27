package com.reetu.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Med;

public interface MedService {
	public String addmed(Med m, MultipartFile image);
	public List<Med> viewall();
	public byte[] getimage(int mid);
	public List<Med> getlikename(String name);
	public String delete(int mid);
	public String update(Med m);
	public String updateimage(int mid, MultipartFile image);
	 public List<Integer> getallids();
}
