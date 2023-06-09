package com.cos.blog.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cos.blog.model.ProductType;
import com.cos.blog.model.green_img;
import com.cos.blog.model.green_product;
import com.cos.blog.model.green_shoessize;
import com.cos.blog.model.searchhistory;
import com.cos.blog.repository.ItemRepository;
import com.cos.blog.repository.historyRepository;
import com.cos.blog.repository.itemStockRepository;
import com.cos.blog.repository.itemimgrepository;
import com.cos.blog.model.green_Users;




@Service
public class ItemService {
	static String url;
	
	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private itemStockRepository itemstockrepository;
	@Autowired
	private itemimgrepository itemimgrepository;	
	@Autowired
	private historyRepository historyrepository; //repository 임 
	static green_img green;	
	static searchhistory history;
	@Transactional
	public green_product 상품확인(String productname) {
		green_product refer =itemRepository.findByProductname(productname.toString());
		return refer;
	}
	
	@Transactional
	public void 상품입력(green_product pd)  {
		pd.setStatus(ProductType.NEW);
		pd.setImg("/downloadimg/"+url);
		itemRepository.save(pd);
	}	
	@Transactional
	public void 상품입력old(green_product pd)  {
		
		pd.setStatus(ProductType.OLD);
		pd.setImg("/downloadimg/"+url);
		itemRepository.save(pd);
	}	
	@Transactional
	public void 이미지저장(MultipartFile file) throws IOException {
		UUID uuid= UUID.randomUUID();//랜덤문자 생성
		file.transferTo(new File( "C:\\Users\\GREEN\\Documents\\workspace-spring-tool-suite-4-4.11.1.RELEASE\\project-5\\src\\main\\resources\\static\\downloadimg\\"+uuid.toString()+file.getOriginalFilename()));
		String imgaddr =uuid.toString()+file.getOriginalFilename();//이미지 이름 저장할 방법 생각하기
		url=imgaddr;
	}
	@Transactional
	public void 다중이미지저장(int id, MultipartFile[] files) {
		green_product product =itemRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("상품 상세보기 실패:상품을 찾을수없습니다.");
		});
		green=new green_img();
		green.setProduct(product);
		for(int i=0;i<files.length;i++) {
			try {
				UUID uuid= UUID.randomUUID();//랜덤문자 생성
				files[i].transferTo(new File( "C:\\Users\\GREEN\\Documents\\workspace-spring-tool-suite-4-4.11.1.RELEASE\\project-5\\src\\main\\resources\\static\\downloadimg\\"+uuid.toString()+files[i].getOriginalFilename()));
				String imgname = uuid.toString()+files[i].getOriginalFilename();
				selectimgnumber(i,imgname);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}//여기에 이미지 이름 변경
		itemimgrepository.save(green);
		
	}
	public void selectimgnumber(int i,String imgname) {
		
		boolean condi= true;
		while(condi) {
			switch(i) {
			case 0:{
				green.setSubimg0("/downloadimg/"+imgname);
				condi=false;
				break;
			}
			case 1:{
				green.setSubimg1("/downloadimg/"+imgname);
				condi=false;
				break;
			}
			case 2:{
				green.setSubimg2("/downloadimg/"+imgname);
				condi=false;
				break;
			}
			case 3:{
				green.setSubimg3("/downloadimg/"+imgname);
				condi=false;
				break;
			}
			case 4:{
				green.setSubimg4("/downloadimg/"+imgname);
				condi=false;
				break;
			}
			case 5:{
				green.setSubimg5("/downloadimg/"+imgname);
				condi=false;
				break;
			}
			}
		}
	}
	
	@Transactional
	public void 상품수정(int id,green_product pd) {
		green_product referpd =itemRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("상품 찾기 실패");
		});
		referpd.setContents(pd.getContents());
		referpd.setImg("/downloadimg/"+url);
		referpd.setMaterial(pd.getMaterial());
		referpd.setPrice(pd.getPrice());
		referpd.setPurpose(pd.getPurpose());
		
	}
	@Transactional
	public void 상품삭제(int id) {
		itemRepository.deleteById(id);
	}
	@Transactional(readOnly=true)
	public  Page<green_product> 상품목록(Pageable pageable){
		return itemRepository.findAll(pageable);
	}
	@Transactional(readOnly=true)
	public green_product 상품상세(int id) {
		return itemRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("상품 상세보기 실패:상품을 찾을수없습니다.");
		});
	}

	@Transactional
	public void 재고입력(green_shoessize greenshoessize, int productid) {
		green_product refer=itemRepository.findById(productid).orElseThrow(()->{
			return new IllegalArgumentException("상품을 찾을수 없습니다.");
		});
		
		greenshoessize.setProduct(refer);
		itemstockrepository.save(greenshoessize);
	}
	@Transactional(readOnly=true)
	public Page<green_shoessize> 재고목록(Pageable pageable){
		return itemstockrepository.findAll(pageable);
	}
	@Transactional
	public green_shoessize 재고상세(int id) {
		return itemstockrepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("재고를 찾을수 없습니다.");
		});
	}
	@Transactional
	public void 재고변경(int id,green_shoessize green_shoessize) {
		green_shoessize refer = itemstockrepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("상품 찾기 실패");
		});
		refer.setItem_size(green_shoessize.getItem_size());
		refer.setItem_stock(green_shoessize.getItem_stock());
	}
	@Transactional
	public List<green_shoessize> 사이즈(int id) {
		green_product refer=itemRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("상품을 찾을수 없습니다.");
		});
		return itemstockrepository.findAllByProduct(refer);
		//refer 의 상품명으로 찾기 만들기
	}
	@Transactional
	public void 기록입력(String searchhistory,green_Users user) {
		
		history = new searchhistory();
		history.setSearchhistory(searchhistory);
		history.setUsers(user);
		historyrepository.save(history);
	}
	@Transactional(readOnly=true)
	public Page<searchhistory> 기록보기(Pageable pageable,green_Users user){		
		Page<searchhistory> listboard = null;
		listboard=	(Page<searchhistory>) historyrepository.findByUsers(user,pageable);
		return listboard;
	}
	@Transactional
	public void 기록삭제(int id) {
		historyrepository.deleteById(id);
	}
}
