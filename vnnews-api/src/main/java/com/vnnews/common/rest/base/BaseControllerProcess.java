package com.vnnews.common.rest.base;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.vnnews.common.Message;
import com.vnnews.common.rest.Utility;
import com.vnnews.common.rest.interfaces.BaseProcessI;
import com.vnnews.common.rest.request.RestRequest;
import com.vnnews.common.rest.respone.ResponseHeader;
import com.vnnews.common.rest.respone.RestResponse;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@ApiResponses(value = { @ApiResponse(code = 200, message = "Thành công"),
		@ApiResponse(code = 401, message = "Chưa xác thực"), @ApiResponse(code = 403, message = "Truy cập bị cấm"),
		@ApiResponse(code = 404, message = "Không tìm thấy"), @ApiResponse(code = 201, message = "Khởi tạo"),
		@ApiResponse(code = 0001, message = "Thông tin request không chính xác") })

@CrossOrigin(maxAge = 360,
	origins = "http://localhost:3000")
public abstract class BaseControllerProcess<REQ extends BaseRequest, REP extends BaseRespone> {

	private final Class<REQ> req;
	private final Class<REP> rep;
	private Logger log;

	public void setLogger(Class<?> clazz) {
		log = LoggerFactory.getLogger(clazz);
	}

	public Logger getLogger() {
		if (log == null) {
			this.setLogger(this.getClass());
		}

		return log;
	}

	public REP getResponse() throws InstantiationException, IllegalAccessException {
		return this.rep.newInstance();
	}

	public BaseControllerProcess(Class<REQ> req, Class<REP> rep) {
		this.req = req;
		this.rep = rep;
	}

	/**
	 * 
	 * @param requestRequest
	 * @return true or false
	 * @apiNote Hàm này để kiểm tra thông tin trên header có đúng hay không
	 */
	protected boolean vaildateHeader(RestRequest requestRequest) {

		return true;
	}

	/**
	 * 
	 * @param requestRequest
	 * @return Class extends BaseRequest
	 * @throws UnsupportedEncodingException
	 * @throws JsonSyntaxException
	 * @throws ClassNotFoundException
	 * @throws JsonProcessingException
	 * @throws JsonMappingException
	 * @apiNote Lấy thông tin request lên server
	 */
	protected REQ pasreRestRequest(RestRequest requestRequest)
			throws UnsupportedEncodingException, ClassNotFoundException, JsonMappingException, JsonProcessingException {
		Object request = null;

		// request = Utility.fromJson(Utility.decodeBase64(requestRequest.getBody()),
		// Class.forName(this.req.getName()));
		request = Utility.fromJson(requestRequest.getParams(), Class.forName(this.req.getName()));
		if (request != null) {
			return this.req.cast(request);
		}

		return null;
	}

	protected RestResponse createRestResponse(ResponseHeader header, REP body) throws JsonProcessingException {

		RestResponse response = new RestResponse();

		response.setParams(Utility.toJson(body));

		return response;
	}

	protected RestResponse baseProcess(RestRequest restRequest, BaseProcessI<REQ, REP> process) {
		long startTime = System.currentTimeMillis();

		REQ request = null;
		RestResponse restResponse = null;
		REP rep = null;

		try {
			request = this.pasreRestRequest(restRequest);
			rep = this.getResponse();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResponseHeader header = new ResponseHeader();
		if (request == null) {

			try {
				restResponse = this.createRestResponse(header, rep);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			return restResponse;
		}

		try {
			rep = process.processRequest(request);

			restResponse = this.createRestResponse(header, rep);

		} catch (Exception e) {
			e.printStackTrace();
			restResponse = new RestResponse();

			BaseRespone response = new BaseRespone();
			response.setStatus(2);
			response.setMesage(Message.error_002);

			try {
				restResponse.setParams(Utility.toJson(response));
			} catch (JsonProcessingException e1) {

			}
		}

		System.out.println(System.currentTimeMillis() - startTime);
		return restResponse;
	}

	@ModelAttribute
	public void setResponseHeader(HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Access-Control-Allow-Origin", "*");
	}

}
