package com.github.liyiorg.common.api;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.github.liyiorg.common.result.DwzResult;

/**
 * 百度短网址API
 * @author SLYH
 *
 */
public class DwzAPI extends BaseAPI{
	
	/**
	 * 
	 * 生成短网址
	 * @param url	长网址
	 * @return 短网址
	 */
	public static DwzResult create(String url){
		return create(url, null);
	}
	
	/**
	 * 自定义短网址
	 * @param url	长网址
	 * @param alias 自定义网址
	 * @return 短网址
	 */
	public static DwzResult create(String url,String alias){
		HttpUriRequest httpUriRequest = RequestBuilder
										.post()
										.setUri("http://dwz.cn/create.php")
										.addParameter("url", url)
										.addParameter("alias", alias==null?"":alias)
										.build();
		
		try {
			HttpResponse response = httpClient.execute(httpUriRequest);
			String json = EntityUtils.toString(response.getEntity(),"utf-8");
			return JSON.parseObject(json, DwzResult.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	/**
	 * 显示原网址
	 * @param tinyurl 查询的短地址
	 * @return 长网址
	 */
	public static DwzResult query(String tinyurl){
		HttpUriRequest httpUriRequest = RequestBuilder
										.post()
										.setUri("http://dwz.cn/query.php")
										.addParameter("tinyurl", tinyurl)
										.build();
		try {
			CloseableHttpResponse response = httpClient.execute(httpUriRequest);
			String json = EntityUtils.toString(response.getEntity(),"utf-8");
			response.close();
			return JSON.parseObject(json, DwzResult.class);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
