package com.github.liyiorg.common.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.github.liyiorg.common.result.Kuaidi;

/**
 * @author KD
 * @version 1.0
 * 创建时间：2014-09-01 上午09:49:02
 * 最后修改人：
 * 修改时间：
 * 类说明: 快递查询
 *
 *
 快递公司简称
A
	aae	AAE
	anxindakuaixi	安信达
B
	baifudongfang	百福东方
	bht	BHT
	youzhengguonei	包裹/平邮/挂号信（暂不支持，请转用Open_API_APICode_URL）
C
	cces	希伊艾斯（CCES）
	coe	中国东方（COE）
D
	datianwuliu	大田物流
	debangwuliu	德邦物流
	dpex	DPEX
	dhl	DHL
	dsukuaidi	D速快递
E
	ems	EMS
	ems	E邮宝
F
	fedex	Fedex（国际）（说明：Fedex是国际，国内的请用“lianbangkuaidi”）
	feikangda	飞康达物流
	feikuaida	飞快达
	rufengda	凡客如风达
G
	ganzhongnengda	港中能达
	guangdongyouzhengwuliu	广东邮政
	youzhengguonei	挂号信（暂不支持，请转用Open_API_APICode_URL）
	youzhengguonei	国内邮件（暂不支持，请转用Open_API_APICode_URL）
	youzhengguoji	国际邮件（暂不支持，请转用Open_API_APICode_URL）
	gls	GLS
H
	huitongkuaidi	汇通快运
	hengluwuliu	恒路物流
	huaxialongwuliu	华夏龙
	tiantian	海航天天
	haiwaihuanqiu	海外环球
J
	jinguangsudikuaijian	京广速递
	jixianda	急先达
	jiajiwuliu	佳吉物流
	jiayiwuliu	佳怡物流
	jiayunmeiwuliu	加运美
	jinyuekuaidi	晋越快递
K
	kuaijiesudi	快捷速递
L
	lianhaowuliu	联昊通
	longbanwuliu	龙邦物流
	lanbiaokuaidi	蓝镖快递
	lejiedi	乐捷递（暂不支持）
	lianbangkuaidi	联邦快递（国内）（说明：国外的请用 fedex）
M
	minghangkuaidi	民航快递
R
	rufengda	如风达快递
Q
	quanchenkuaidi	全晨快递
	quanjitong	全际通
	quanritongkuaidi	全日通
	quanyikuaidi	全一快递
	quanfengkuaidi	全峰快递
S
	shentong	申通速递
	shentong	申通E物流
	shunfeng	顺丰速递
	santaisudi	三态速递
	shenghuiwuliu	盛辉物流
	suer	速尔物流
	shengfengwuliu	盛丰物流
	shangda	上大物流
	santaisudi	三态速递
	shandonghaihong	山东海红
	saiodi	赛澳递
T
	tiandihuayu	天地华宇
	tiantian	天天快递
	tnt	TNT
U
	ups	UPS
W
	wanjiawuliu	万家物流
	wxwl	万象物流（即将支持）
X
	xinbangwuliu	新邦物流
	xinfengwuliu	信丰物流
	xingchengjibian	星晨急便（暂不支持，请转用Open_API_APICode_URL）
	xinhongyukuaidi	鑫飞鸿
Y
	yafengsudi	亚风速递
	yibangwuliu	一邦速递
	youshuwuliu	优速物流
	yuanchengwuliu	远成物流
	yuantong	圆通速递
	yuanweifeng	源伟丰快递
	yuanzhijiecheng	元智捷诚
	yuefengwuliu	越丰物流
	yunda	韵达快运
	yuananda	源安达
	yuanfeihangwuliu	原飞航
	yuntongkuaidi	运通快递
	zhongxinda	忠信达快递
	zhimakaimen	芝麻开门
	youzhengguonei	邮政国内给据（暂不支持，请转用Open_API_APICode_URL）
	youzhengguoji	邮政国际（暂不支持，请转用Open_API_APICode_URL）
Z
	zhaijisong	宅急送
	zhongtiewuliu	中铁快运
	zhongtong	中通速递
	zhongyouwuliu	中邮物流

 *
 */
public class KDAPI extends BaseAPI{
	
	private static String URI = "h t t p s : // w w w . k u a i d i 1 0 0 . c o m".replace(" ", "");

	/**
	 * 快递查询完整记录
	 * @param com    快递公司简称
	 * @param postid 快递单号
	 * @return json
	 */
	public static String query(String type,String postid){
		Random r = new Random();
		long temp = r.nextLong();
		HttpUriRequest httpUriRequest = RequestBuilder.get()
										.setUri(URI + "/query")
										.addParameter("type", type)
										.addParameter("postid", postid)
										.addParameter("id", "1")
										.addParameter("temp", temp+"")
										.addParameter("valicode", "")
										.build();
		try {
			CloseableHttpResponse response = httpClient.execute(httpUriRequest);
			String data = EntityUtils.toString(response.getEntity(), Charset.forName("utf-8"));
			response.close();
			return data;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			
		}
		return null;
	}


	/**
	 * 快递查询完整记录
	 * @param com    快递公司简称
	 * @param postid 快递单号
	 * @return json
	 */
	public static Kuaidi queryJSON(String type,String postid){
		String data = query(type, postid);
		if(data != null){
			return JSON.parseObject(data, Kuaidi.class);
		}
		return null;
	}

}
