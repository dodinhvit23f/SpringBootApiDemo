package com.vnnews.api.rest.controllers;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vnnews.api.entities.FavoriteCate;
import com.vnnews.common.Message;
import com.vnnews.common.rest.base.BaseControllerProcess;
import com.vnnews.common.rest.base.BaseRespone;
import com.vnnews.common.rest.interfaces.BaseProcessI;
import com.vnnews.common.rest.request.FavoriteRequest;
import com.vnnews.common.rest.request.RestRequest;
import com.vnnews.common.rest.respone.RestResponse;

@RestController
public class FavoriteCateProcessController extends BaseControllerProcess<FavoriteRequest, BaseRespone> {
	
	@Autowired
	private EntityManager em;
	
	
	public FavoriteCateProcessController() {
		super(FavoriteRequest.class, BaseRespone.class);
	}

	@PostMapping(value = "/updateFavoriteCate", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	
	@Transactional
	public RestResponse getFravoriteCategoryList(HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders,
			@RequestBody RestRequest restRequest) {
		
		BaseProcessI<FavoriteRequest, BaseRespone> process = new BaseProcessI<FavoriteRequest, BaseRespone>(){

			@Override
			public BaseRespone processRequest( FavoriteRequest request) {
				BaseRespone response = new BaseRespone();
				boolean validated = true;
				
				if(request.getMsisdn().isEmpty()) {
					validated = false;
				}
				
				if(request.getCateList().isEmpty()) {
					validated = false;
				}
				
				String[] strings = request.getCateList().split(",");
				
				if(strings.length < 0) {
					validated = false;
				}
				
				if(!validated)
				{
					response.setStatus(1);
					response.setMesage(Message.error_001);
					
					return response;
				}
				
				
				for (String cateId : strings) {
					if(!cateId.isEmpty() || cateId.equals("") ) {
						
						
						FavoriteCate favorite = em.find(FavoriteCate.class, Long.parseLong(cateId));
						
						if(favorite == null) {
							favorite = new FavoriteCate();
							favorite.setCreateTime(new Date());
							favorite.setCateId(Long.parseLong(cateId));
							favorite.setMsisdn(request.getMsisdn());
							favorite.setSyncStatus(1l);						
							em.persist(favorite);
						}
					}
				}
			
				
				
				response.setStatus(0);
				response.setMesage("Thành Công");
				return response;
			}
			
		};
		
		return this.baseProcess(restRequest, process);
	}

}
