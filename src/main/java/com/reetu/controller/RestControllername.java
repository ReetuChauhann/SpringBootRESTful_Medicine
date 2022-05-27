package com.reetu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.reetu.beans.Med;
import com.reetu.service.MedService;

@RestController
public class RestControllername {
	                                 @Autowired
	                                 MedService ms;
	                                 
	                                 @RequestMapping("/")
	                                 public String homepage() {
	                                	 return "Hello Developer";
	                                 }
	                                 
	                                 @PostMapping("/addmedicine")
	                                 public ResponseEntity<String> addmed( @RequestPart("Med") Med m,@RequestPart("image") MultipartFile image){
	                                	 String s=ms.addmed(m, image);
	                                	 if(s=="success") {
	                                		 return new ResponseEntity<String>(s, HttpStatus.OK);
	                                	 }else {
	                                		 return new ResponseEntity<String>(s,HttpStatus.NOT_MODIFIED);
	                                	 }
	                                 }
	                                 
	                                 @GetMapping("/getallmed")
	                                 public List<Med> getallmed(){
	                                	 List<Med> m=ms.viewall();
	                                	 return m;
	                                	 
	                                 }
	                                 
	                                 @GetMapping("/getsamename/{name}")
	                                 public List<Med> getsamename(@PathVariable("name") String name){
	                                	 List<Med> m=ms.getlikename(name);
	                                	 return m;
	                                 }
	                                 
	                                 @GetMapping("/getallids")
	                                 public List<Integer> getallids(){
	                                	 List<Integer> ids=ms.getallids();
	                                	 return ids;
	                                 }
	                                 
	                                 @PutMapping("/update")
	                                 public ResponseEntity<String> update(@RequestBody Med m){
	                                	 String s=ms.update(m);
	                                	 if(s=="success") {
	                                		 return new ResponseEntity<String>(s, HttpStatus.OK);
	                                	 }else {
	                                		 return new ResponseEntity<String>(s, HttpStatus.NOT_MODIFIED);
	                                	 }
	                                 }
	                                 
	                                 @RequestMapping("/delete/{mid}")
	                                 public String delete(@PathVariable("mid") int mid) {
	                                	 String s=ms.delete(mid);
	                                	 return s;
	                                 }
	                                 
	                                 @GetMapping("/getimage/{mid}")
	                                 public byte[] getimage(@PathVariable("mid") int mid) {
	                                	 byte[] b=ms.getimage(mid);
	                                	 return b;
	                                 }
	                                 
	                                 @PutMapping("/updateimage")
	                                 public ResponseEntity<String> updateimage(int mid, @RequestPart("image") MultipartFile image){
	                                	 String s=ms.updateimage(mid, image);
	                                	 if(s=="Success") {
	                                		 return new ResponseEntity<String>(s,HttpStatus.OK);
	                                	 }else {
	                                		 return new ResponseEntity<String>(s,HttpStatus.NOT_MODIFIED);
	                                	 }
	                                 }
	                                 
	                                 
	                                 
	                                	 
	                                 
	                                 

}
