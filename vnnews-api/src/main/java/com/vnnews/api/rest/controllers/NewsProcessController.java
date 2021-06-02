package com.vnnews.api.rest.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vnnews.api.dto.interfaces.NewsI;
import com.vnnews.api.repository.NewsRepository;
import com.vnnews.common.Message;
import com.vnnews.common.object.PageInfo;
import com.vnnews.common.rest.base.BaseControllerProcess;
import com.vnnews.common.rest.dto.NewsDTO;
import com.vnnews.common.rest.interfaces.BaseProcessI;
import com.vnnews.common.rest.request.NewsListRequest;
import com.vnnews.common.rest.request.RestRequest;
import com.vnnews.common.rest.respone.RestResponse;
import com.vnnews.common.rest.response.NewsListResponse;

@RestController
public class NewsProcessController extends BaseControllerProcess<NewsListRequest, NewsListResponse> {

	@Autowired
	private NewsRepository newsRepository;
	

	/*
	 * @Autowired private EntityManager em;
	 */

	public NewsProcessController() {
		super(NewsListRequest.class, NewsListResponse.class);
	}

	@PostMapping(value = "/getNewsList", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })

	public RestResponse getNewsList(HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders,
			@RequestBody RestRequest restRequest) {

		BaseProcessI<NewsListRequest, NewsListResponse> process = new BaseProcessI<NewsListRequest, NewsListResponse>() {

			@Override
			public NewsListResponse processRequest( NewsListRequest request) {

				boolean validate = true;

				boolean hadCateId = (request.getCateId() != null && request.getCateId() > 0);
				boolean hadGroupType = (request.getGroupType() != null && request.getGroupType() > 0);
				boolean hadContentType = (request.getContentType() != null && request.getContentType() >= 0);

				NewsListResponse response = new NewsListResponse();

				if (request.getPage() <= 0) {
					request.setPage(1);
				}

				PageRequest pageable = PageRequest.of(request.getPage() - 1, request.getPageSize());

				if (request.getOrderType() == 0) {
					pageable = PageRequest.of(request.getPage() - 1, request.getPageSize(),
							Sort.by(Sort.Direction.DESC, "createTime"));
				}

				if (request.getOrderType() == 1) {
					pageable = PageRequest.of(request.getPage() - 1, request.getPageSize(),
							Sort.by(Sort.Direction.DESC, "viewCount"));
				}

				Page<NewsI> page = null;

				if (hadCateId && hadGroupType && hadContentType) {
					page = newsRepository.getNewsByCateIdAndGroupAndContent(request.getCateId(), request.getGroupType(),
							request.getContentType(), pageable);
					validate = false;
				}

				if (hadCateId && hadContentType && validate) {
					page = newsRepository.getNewsByCateIdAndContent(request.getCateId(), request.getContentType(),
							pageable);
					validate = false;
				}

				if (hadCateId && hadContentType && validate) {
					page = newsRepository.getNewsByCateIdAndGroup(request.getCateId(), request.getGroupType(),
							pageable);
					validate = false;
				}

				if (hadGroupType && hadContentType && validate) {
					page = newsRepository.getNewsByGroupAndContent(request.getGroupType(), request.getContentType(),
							pageable);
					validate = false;
				}

				if (hadGroupType && validate) {
					page = newsRepository.getGroupNews(request.getGroupType(), pageable);
					validate = false;
				}

				if (hadGroupType && validate) {
					if (request.getContentType() == 0 || request.getContentType() == 1 || request.getContentType() == 2
							|| request.getContentType() == 3) {
						page = newsRepository.getContentTypeNews(request.getContentType(), pageable);
						validate = false;
					}
				}

				if (hadCateId && validate) {
					page = newsRepository.getDefaultNews(request.getCateId(), pageable);
				}

				PageInfo pageInfo = new PageInfo();
				pageInfo.setPage(request.getPage());
				pageInfo.setPageSize(request.getPageSize());
				pageInfo.setTotalItem(page.getTotalElements());
				pageInfo.setTotalPage(page.getTotalPages());

				List<NewsI> list = page.getContent();

				List<NewsDTO> data = new ArrayList<NewsDTO>();

				if (list == null || list.isEmpty()) {
					response.setStatus(2);
					response.setPageInfo(pageInfo);
					response.setMesage(Message.error_002);
					return response;
				}

				for (NewsI news : list) {
					NewsDTO dto = new NewsDTO();
					news.getTitle();
					dto.setCateName(news.getCateName());
					dto.setCommentCount(news.getCommentCount());
					dto.setContentType(news.getNewsType());
					dto.setCreateTime(news.getCreateTime());
					dto.setGroupName(news.getGroupName());
					dto.setDescription(news.getDescription());
					dto.setImg1(news.getImage1());
					dto.setImg2(news.getImage2());
					dto.setLikeCount(news.getNumlike());
					dto.setNewsId(news.getId());
					dto.setShareCount(news.getShareCount());
					// dto.setSourceName(news.); dto.setTitle(news.getTitle());
					dto.setViewCount(news.getViewCount());
					dto.setTitle(news.getTitle());
					data.add(dto);
				}
				response.setData(data);
				response.setPageInfo(pageInfo);

				return response;
			}

		};

		return this.baseProcess(restRequest, process);
	}

	@PostMapping(value = "/getNewsById", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })

	public RestResponse getNewsById(HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders,
			@RequestBody RestRequest restRequest) {
		NewsListResponse response = new NewsListResponse();

		BaseProcessI<NewsListRequest, NewsListResponse> process = new BaseProcessI<NewsListRequest, NewsListResponse>() {

			@Override
			public NewsListResponse processRequest(NewsListRequest request) {
				if (request.getId() != null || request.getId() != 0) {
					NewsI news = newsRepository.getNewsById(request.getId());

					if (news == null) {
						response.setStatus(2);
						response.setMesage(Message.error_002);
						return response;
					}

					List<NewsDTO> data = new ArrayList<NewsDTO>();

					NewsDTO dto = new NewsDTO();

					dto.setCateName(news.getCateName());
					dto.setCommentCount(news.getCommentCount());
					dto.setContentType(news.getNewsType());
					dto.setCreateTime(news.getCreateTime());
					dto.setGroupName(news.getGroupName());
					dto.setDescription(news.getDescription());
					dto.setImg1(news.getImage1());
					dto.setImg2(news.getImage2());
					dto.setLikeCount(news.getNumlike());
					dto.setNewsId(news.getId());
					dto.setShareCount(news.getShareCount());
					// dto.setSourceName(news.); dto.setTitle(news.getTitle());
					dto.setViewCount(news.getViewCount());
					dto.setTitle(news.getTitle());
					
					data.add(dto);

					response.setData(data);

				}

				return response;

			}

		};

		return this.baseProcess(restRequest, process);
	}
}
