package com.vnnews.api.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vnnews.api.entities.Category;
import com.vnnews.api.repository.CategoryRepository;
import com.vnnews.common.object.PageInfo;
import com.vnnews.common.rest.base.BaseControllerProcess;
import com.vnnews.common.rest.dto.CategoryDTO;
import com.vnnews.common.rest.interfaces.BaseProcessI;
import com.vnnews.common.rest.request.CategoryListRequest;
import com.vnnews.common.rest.request.RestRequest;
import com.vnnews.common.rest.respone.RestResponse;
import com.vnnews.common.rest.response.CategoryListResponse;

@RestController
public class CategoryProcessController extends BaseControllerProcess<CategoryListRequest, CategoryListResponse> {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public CategoryProcessController() {
		super(CategoryListRequest.class, CategoryListResponse.class);
	}
	
	@GetMapping(value = "/info")
	public String info() {
		return "I'm running";
	}
	
	@PostMapping(value = "/getCateList", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })

	public RestResponse getCategoryList(HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders,
			@RequestBody RestRequest restRequest) {
		
		BaseProcessI<CategoryListRequest, CategoryListResponse> process = new BaseProcessI<CategoryListRequest, CategoryListResponse>(){

			@Override
			public CategoryListResponse processRequest( CategoryListRequest request) {
				
				if(request.getPage() <= 0) {
					request.setPage(1);
				}
				
				PageRequest pageable = PageRequest.of(request.getPage() - 1, request.getPageSize());
				
				Page<Category> page = categoryRepository.getHeadersCategory(pageable);
				
				List<CategoryDTO> data = new ArrayList<CategoryDTO>();
				
				page.forEach( (cate) -> {
					CategoryDTO dto = new CategoryDTO();
					dto.setCateId(cate.getCpId());
					dto.setImg(cate.getImage());	
					dto.setName(cate.getName());
					data.add(dto);
				});
			
				
				PageInfo pageInfo = new PageInfo();
				pageInfo.setPage(request.getPage());
				pageInfo.setPageSize(page.getSize());
				pageInfo.setTotalItem(page.getTotalElements());
				pageInfo.setTotalPage(page.getTotalPages());
				
				
				
				CategoryListResponse response = new CategoryListResponse();
				response.setPageInfo(pageInfo);
				response.setData(data);
				
				return response;
			}
			
		};
		
		return this.baseProcess(restRequest, process);
	}

}
