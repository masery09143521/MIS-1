package Action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import Service.GuitarService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class BaseAction<T> extends ActionSupport implements ApplicationAware,RequestAware,SessionAware,ModelDriven<T>{
    
	protected JSONArray jsonArray = new JSONArray();
	protected JSONObject jsonObject = new JSONObject();
	protected GuitarService guitarService;
	//调用service，创建set方法   
	protected List<T> lists=new ArrayList<T>();
	protected List<T> lists2=new ArrayList<T>();
	protected InputStream inputStream;
	
	protected Map<String,Object> maps=new HashMap<String,Object>();
	
	//当前页所用到的行数
	protected int rows;
	//第几页
	protected int page;
	

	
	protected Date date=new Date();

	protected Map<String, Object> request;

	protected Map<String, Object> session;

	protected Map<String, Object> application;	

	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application=application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session=session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request=request;
	}



	public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	public Map<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}



	public InputStream getResult() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return date;
	}


	public List<T> getLists2() {
		return lists2;
	}

	public void setLists2(List<T> lists2) {
		this.lists2 = lists2;
	}

	public void setGuitarService(GuitarService guitarService) {
		this.guitarService = guitarService;
	}

	public void setJsonArray(JSONArray jsonArray) {
		this.jsonArray = jsonArray;
	}

	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}

	@Override
	public T getModel() {
		// TODO Auto-generated method stub
		return null;
	}


	

}
