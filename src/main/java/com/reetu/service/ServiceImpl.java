package com.reetu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Med;
import com.reetu.dao.MedRepo;

@Service
public class ServiceImpl implements MedService {
	
	                                        @Autowired
	                                        MedRepo mr;

	@Override
	public String addmed(Med m, MultipartFile image) {
		// TODO Auto-generated method stub
		return mr.addmed(m, image);
	}

	@Override
	public List<Med> viewall() {
		// TODO Auto-generated method stub
		return mr.viewall();
	}

	@Override
	public byte[] getimage(int mid) {
		// TODO Auto-generated method stub
		return mr.getimage(mid);
	}

	@Override
	public List<Med> getlikename(String name) {
		// TODO Auto-generated method stub
		return mr.getlikename(name);
	}

	@Override
	public String delete(int mid) {
		// TODO Auto-generated method stub
		return mr.delete(mid);
	}

	@Override
	public String update(Med m) {
		// TODO Auto-generated method stub
		return mr.update(m);
	}

	@Override
	public String updateimage(int mid, MultipartFile image) {
		// TODO Auto-generated method stub
		return mr.updateimage(mid, image);
	}

	@Override
	public List<Integer> getallids() {
		// TODO Auto-generated method stub
		return mr.getallids();
	}

}
