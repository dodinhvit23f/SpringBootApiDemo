package com.vnnews.api.rest.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.vnnews.api.entities.Comment;
import com.vnnews.api.entities.News;
import com.vnnews.api.repository.CommentsRepository;
import com.vnnews.common.Message;
import com.vnnews.common.object.PageInfo;
import com.vnnews.common.rest.Utility;
import com.vnnews.common.rest.base.BaseControllerProcess;
import com.vnnews.common.rest.dto.CommentDTO;
import com.vnnews.common.rest.interfaces.BaseProcessI;
import com.vnnews.common.rest.request.CommentRequest;
import com.vnnews.common.rest.request.RestRequest;
import com.vnnews.common.rest.respone.RestResponse;
import com.vnnews.common.rest.response.CommentListResponse;

@RestController
public class CommentsProcessController extends BaseControllerProcess<CommentRequest, CommentListResponse> {

	@Autowired
	private CommentsRepository commentRepository;
	@Autowired
	private EntityManager em;

	public CommentsProcessController() {
		super(CommentRequest.class, CommentListResponse.class);
	}

	@GetMapping(value = "/commentinfo")
	public String info() {
		return "I'm running";
	}

	@PostMapping(value = "/getCommentList", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	private RestResponse getCommentList(HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders,

			@RequestBody RestRequest restRequest) {

		BaseProcessI<CommentRequest, CommentListResponse> process = new BaseProcessI<CommentRequest, CommentListResponse>() {

			@Override
			public CommentListResponse processRequest(CommentRequest request) {
				CommentListResponse response = new CommentListResponse();

				if (commentRepository == null || request.getId() == null) {
					response.setStatus(2);
					response.setMesage(Message.error_002);
					return response;
				}

				boolean validated = true;

				if (request.getId() <= 0) {
					validated = false;
				}

				if (request.getPage() <= 0 || request.getPageSize() <= 0)

					if (!validated) {
						response.setStatus(1);
						response.setMesage("Thông tin không chính xác");
						return response;
					}

				Pageable pageable = PageRequest.of(request.getPage() - 1, request.getPageSize());
				Page<Comment> page = null;

				if (request.getParentId() != null) {
					if (request.getParentId() > 0) {
						page = commentRepository.getCommentsByNewsIdAndParentId(request.getId(), request.getParentId(),
								pageable);
						validated = false;
					}
				}

				if (validated) {
					page = commentRepository.getCommentsByNewsId(request.getId(), pageable);
				}

				if (page == null || page.isEmpty()) {
					response.setStatus(2);
					response.setMesage(Message.error_002);
					return response;
				}

				PageInfo pageInfo = new PageInfo();
				pageInfo.setPage(request.getPage());
				pageInfo.setPageSize(request.getPageSize());
				pageInfo.setTotalItem(page.getTotalElements());
				pageInfo.setTotalPage(page.getTotalPages());

				List<Comment> list = page.getContent();

				List<CommentDTO> data = new ArrayList<CommentDTO>();

				for (Comment comment : list) {
					CommentDTO dto = new CommentDTO();

					dto.setContent(comment.getContent());
					dto.setCreateTime(comment.getCreateTime());
					dto.setId(comment.getId());

					if (comment.getLikeNum() > 0) {
						dto.setLikeNum(comment.getLikeNum());
					}
					dto.setMsisdn(comment.getMsisdn());

					if (comment.getParentId() > 0) {
						dto.setParentId(comment.getParentId());
					}

					data.add(dto);
				}

				response.setData(data);
				response.setPageInfo(pageInfo);

				return response;

			}

		};

		return this.baseProcess(restRequest, process);
	}

	
	@Transactional
	@PostMapping(value = "/insertComment", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	
	public RestResponse insertComment(HttpServletRequest httpServletRequest, @RequestHeader HttpHeaders httpHeaders,

			@RequestBody RestRequest restRequest) {

		BaseProcessI<CommentRequest, CommentListResponse> process = new BaseProcessI<CommentRequest, CommentListResponse>() {

			@Override
			public CommentListResponse processRequest(CommentRequest request) {
				CommentListResponse response = new CommentListResponse();

				if (commentRepository == null) {
					response.setStatus(2);
					response.setMesage(Message.error_002);
					return response;
				}

				boolean validated = true;
				if(request.getNewId() == null) {
					validated = false;
				}
				
				if (request.getContent() == null) {
					validated = false;
				}

				if (request.getMsidn() == null) {
					validated = false;
				}

				if (request.getSrc() == null) {
					validated = false;
				}

				if (!validated) {
					response.setStatus(1);
					response.setMesage("Thông tin không chính xác");
					return response;
				}

				String content = Utility.validateEmptyString(request.getContent());
				String msisdn = Utility.validateEmptyString(request.getMsidn());
				String source = Utility.validateEmptyString(request.getSrc());

				if (content.isEmpty()) {
					validated = false;
				}

				if (msisdn.isEmpty()) {
					validated = false;
				}

				if (!Utility.checkPhoneNumber(msisdn)) {
					validated = false;
				}
				
				if(source == null) {
					validated = false;
				}
				
				News news = em.find(News.class, request.getNewId());
				
				if(news == null) {
					validated = false;
				}
				
				
				
				if (validated) {				
					
					Comment comment = new Comment();
					comment.setContent(content);
					comment.setCreateTime(new Date());
					comment.setSource(source);
					comment.setMsisdn(msisdn);
					comment.setStatus(1L);
					em.persist(comment);
					
					response.setStatus(0);
					response.setMesage(Message.success);

					return response;
				}

				response.setStatus(2);
				response.setMesage(Message.error_002);

				return response;

			}

		};

		return this.baseProcess(restRequest, process);
	}
	
}
