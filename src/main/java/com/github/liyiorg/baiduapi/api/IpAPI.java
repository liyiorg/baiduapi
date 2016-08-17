package com.github.liyiorg.baiduapi.api;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.github.liyiorg.baiduapi.result.IpResult;

/**
 * IP 地址API
 * @author SLYH
 *
 */
public class IpAPI extends BaseAPI{
	
	
	/**
	 * IP定位API <br>
	 * 每个key每天支持10万次调用，超过限制不返回数据。<br>
	 * IP定位的结果精度较差，主要应用获取省份或者城市的位置信息。移动平台的APP建议使用百度定位SDK 。
	 * @param ip	ip地址
	 * @param ak	用户密钥			(必选，在lbs云官网注册的access key，作为访问的依据)
	 * @param sn	用户的权限签名	(可选，若用户所用ak的校验方式为sn校验时该参数必须。)
	 * @param coor	输出的坐标格式	(可选，coor不出现时，默认为百度墨卡托坐标；coor=bd09ll时，返回为百度经纬度坐标)
	 * @return	地址解析
	 */
	public static IpResult ip(String ip,String ak,String sn,String coor){
		HttpUriRequest httpUriRequest = RequestBuilder
										.post()
										.setUri("http://api.map.baidu.com/location/ip")
										.addParameter("ip", ip)
										.addParameter("ak", ak==null?"":ak)
										.addParameter("sn", sn==null?"":sn)
										.addParameter("coor", coor==null?"":coor)
										.build();
		
		try {
			HttpResponse response = httpClient.execute(httpUriRequest);
			String json = EntityUtils.toString(response.getEntity(),"utf-8");
			return JSON.parseObject(json, IpResult.class);
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
