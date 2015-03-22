package action;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import pojo.User;
import service.UserService;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class UserAction extends ActionSupport {

	@Resource
	private UserService userService;

	private Integer id;
	private String name;
	private String password;
	private String username;
	private String birth;

	private Integer start;
	private Integer limit;
	
	private Map<String, Object> dataMap;

	public String page() {
		dataMap = userService.page(start, limit);
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

}
