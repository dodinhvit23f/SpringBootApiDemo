package com.vnnews;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.vnnews.common.rest.Utility;
import com.vnnews.common.rest.request.CategoryListRequest;
import com.vnnews.common.rest.request.CommentRequest;
import com.vnnews.common.rest.request.FavoriteRequest;
import com.vnnews.common.rest.request.NewsListRequest;
import com.vnnews.common.rest.request.RequestHeader;
import com.vnnews.common.rest.request.RestRequest;
import com.vnnews.common.rest.respone.RestResponse;

public class Test {
	public static void CategoryListApi() {
		try {
			RequestHeader headr = new RequestHeader();
			long requestTime = System.currentTimeMillis();
			headr.setRequestTime(requestTime);
			
			headr.setAuthorization(requestTime);
			
		
			
			CategoryListRequest request = new CategoryListRequest();

			request.setPage(1);
			request.setPageSize(10);
			request.setCateId(1);
			
			
			System.out.println(Utility.toJson(request));

			HttpHeaders headers = new HttpHeaders();
			// Bắt buộc request theo kiểu json.
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Tạo header cho request chứa các thông tin để xác nhận client.

			// Khởi tại 1 RestFul request
			RestRequest restRequest = new RestRequest();
		
			restRequest.setParams(Utility.toJson(request));

			// Tạo HttpEntity bảo gồm cả phần body (RestRequest) và Header
			HttpEntity<String> httpEntity = new HttpEntity<String>(Utility.toJson(restRequest), headers);

			// Tạo RestTemplateBuilder để tạo RestTemplate nhằm mục đích gửi các request
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
			restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(5));
			restTemplateBuilder.setReadTimeout(Duration.ofSeconds(5));

			RestTemplate restTemplate = restTemplateBuilder.build();

			ResponseEntity<RestResponse> restEntity = restTemplate.postForEntity("http://localhost:8084/api/getCateList",
					httpEntity, RestResponse.class);
			
			System.out.println(restEntity.getBody().getParams());
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
	
			e.printStackTrace();
		}
	}
	
	public static void FavoriteApi() {
		try {
			RequestHeader headr = new RequestHeader();
			long requestTime = System.currentTimeMillis();
			
			headr.setRequestTime(requestTime);
			headr.setAuthorization(requestTime);
			
		
		
			
			FavoriteRequest request = new FavoriteRequest();

			request.setMsisdn("0366947190");
			request.setCateList("1,2,3,4");
			
			System.out.println(Utility.toJson(request));
			
			HttpHeaders headers = new HttpHeaders();
			// Bắt buộc request theo kiểu json.
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			// Tạo header cho request chứa các thông tin để xác nhận client.
			

			// Khởi tại 1 RestFul request
			RestRequest restRequest = new RestRequest();
			
			restRequest.setParams(Utility.toJson(request));

			// Tạo HttpEntity bảo gồm cả phần body (RestRequest) và Header
			HttpEntity<String> httpEntity = new HttpEntity<String>(Utility.toJson(restRequest), headers);

			// Tạo RestTemplateBuilder để tạo RestTemplate nhằm mục đích gửi các request
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
			restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(5));
			restTemplateBuilder.setReadTimeout(Duration.ofSeconds(5));

			RestTemplate restTemplate = restTemplateBuilder.build();

			ResponseEntity<RestResponse> restEntity = restTemplate.postForEntity("http://localhost:8084/api/updateFavoriteCate",
					httpEntity, RestResponse.class);
			
			System.out.println(restEntity.getBody().getParams());
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			//
			e.printStackTrace();
		}
	}
	
	public static void NewsListApi() {
		try {
			RequestHeader headr = new RequestHeader();
			long requestTime = System.currentTimeMillis();
			
			headr.setRequestTime(requestTime);
			headr.setAuthorization(requestTime);
			
		
		
			
			NewsListRequest request = new NewsListRequest();
			request.setCateId(31L);
			request.setGroupType(13L);
			request.setContentType(0L);
			
			System.out.println(Utility.toJson(request));
			
			
			HttpHeaders headers = new HttpHeaders();
			// Bắt buộc request theo kiểu json.
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Tạo header cho request chứa các thông tin để xác nhận client.

			// Khởi tại 1 RestFul request
			RestRequest restRequest = new RestRequest();
			
			restRequest.setParams(Utility.toJson(request));

			// Tạo HttpEntity bảo gồm cả phần body (RestRequest) và Header
			HttpEntity<String> httpEntity = new HttpEntity<String>(Utility.toJson(restRequest), headers);

			// Tạo RestTemplateBuilder để tạo RestTemplate nhằm mục đích gửi các request
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
			restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(5));
			restTemplateBuilder.setReadTimeout(Duration.ofSeconds(5));

			RestTemplate restTemplate = restTemplateBuilder.build();

			ResponseEntity<RestResponse> restEntity = restTemplate.postForEntity("http://localhost:8084/api/getNewsList",
					httpEntity, RestResponse.class);
			
			System.out.println(restEntity.getBody().getParams());
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			//
			e.printStackTrace();
		}
	}
	
	public static void NewstApi() {
		try {
			RequestHeader headr = new RequestHeader();
			long requestTime = System.currentTimeMillis();
			
			headr.setRequestTime(requestTime);
			headr.setAuthorization(requestTime);

		
			
			NewsListRequest request = new NewsListRequest();
			request.setId(2L);
			
			System.out.println(Utility.toJson(request));
			
			HttpHeaders headers = new HttpHeaders();
			// Bắt buộc request theo kiểu json.
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Tạo header cho request chứa các thông tin để xác nhận client.
			
		
			// Khởi tại 1 RestFul request
			RestRequest restRequest = new RestRequest();
			
			restRequest.setParams(Utility.toJson(request));

			// Tạo HttpEntity bảo gồm cả phần body (RestRequest) và Header
			HttpEntity<String> httpEntity = new HttpEntity<String>(Utility.toJson(restRequest), headers);

			// Tạo RestTemplateBuilder để tạo RestTemplate nhằm mục đích gửi các request
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
			restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(5));
			restTemplateBuilder.setReadTimeout(Duration.ofSeconds(5));

			RestTemplate restTemplate = restTemplateBuilder.build();

			ResponseEntity<RestResponse> restEntity = restTemplate.postForEntity("http://localhost:8084/api/getNewsById",
					httpEntity, RestResponse.class);
			
			System.out.println(restEntity.getBody().getParams());
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			//
			e.printStackTrace();
		}
	}
	
	public static void CommentListApi() {
		try {
			RequestHeader headr = new RequestHeader();
			long requestTime = System.currentTimeMillis();
			
			headr.setRequestTime(requestTime);
			headr.setAuthorization(requestTime);
			
		
		
			
			CommentRequest request = new CommentRequest();
			request.setId(3L);
			//request.setParentId(1L);
			
			System.out.println(Utility.toJson(request));
			
			HttpHeaders headers = new HttpHeaders();
			// Bắt buộc request theo kiểu json.
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Tạo header cho request chứa các thông tin để xác nhận client.
			

			// Khởi tại 1 RestFul request
			RestRequest restRequest = new RestRequest();
		
			restRequest.setParams(Utility.toJson(request));

			// Tạo HttpEntity bảo gồm cả phần body (RestRequest) và Header
			HttpEntity<String> httpEntity = new HttpEntity<String>(Utility.toJson(restRequest), headers);

			// Tạo RestTemplateBuilder để tạo RestTemplate nhằm mục đích gửi các request
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
			restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(5));
			restTemplateBuilder.setReadTimeout(Duration.ofSeconds(5));

			RestTemplate restTemplate = restTemplateBuilder.build();

			ResponseEntity<RestResponse> restEntity = restTemplate.postForEntity("http://localhost:8084/api/getCommentList",
					httpEntity, RestResponse.class);
			
			System.out.println(restEntity.getBody().getParams());
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			//
			e.printStackTrace();
		}
	}
	
	public static void InsertCommentApi() {
		try {
			RequestHeader headr = new RequestHeader();
			long requestTime = System.currentTimeMillis();
			
			headr.setRequestTime(requestTime);
			headr.setAuthorization(requestTime);
			
		
		
			
			CommentRequest request = new CommentRequest();
			
			
			request.setContent("Ngay 18/02/2021 Tiến test api comment 2");
			request.setParentId(0L);
			request.setMsidn("0904718019");
			request.setSrc("IOS");
			request.setNewId(1L);
			
			System.out.println(Utility.toJson(request));
			
			HttpHeaders headers = new HttpHeaders();
			// Bắt buộc request theo kiểu json.
			headers.setContentType(MediaType.APPLICATION_JSON);

			// Tạo header cho request chứa các thông tin để xác nhận client.
			

			// Khởi tại 1 RestFul request
			RestRequest restRequest = new RestRequest();
			restRequest.setParams(Utility.toJson(request));

			// Tạo HttpEntity bảo gồm cả phần body (RestRequest) và Header
			HttpEntity<String> httpEntity = new HttpEntity<String>(Utility.toJson(restRequest), headers);

			// Tạo RestTemplateBuilder để tạo RestTemplate nhằm mục đích gửi các request
			RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
			restTemplateBuilder.setConnectTimeout(Duration.ofSeconds(5));
			restTemplateBuilder.setReadTimeout(Duration.ofSeconds(5));

			RestTemplate restTemplate = restTemplateBuilder.build();

			ResponseEntity<RestResponse> restEntity = restTemplate.postForEntity("http://localhost:8084/api/insertComment",
					httpEntity, RestResponse.class);
			
			System.out.println(restEntity.getBody().getParams());
			
		} catch (JsonProcessingException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			//
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//CategoryListApi();
		//FavoriteApi();
		//NewsListApi();
		//CommentListApi();
		//NewstApi();
		InsertCommentApi();
	}

}
