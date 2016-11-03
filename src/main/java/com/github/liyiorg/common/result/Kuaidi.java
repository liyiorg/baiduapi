package com.github.liyiorg.common.result;

import java.util.List;

public class Kuaidi{

	private String nu;			//订单号
	
	private String message;		//消息
	
	private String ischeck;		//是否检查
	
	private String com;			//快递类型
	
	private String updatetime;	//更新时间
	
	private String status;		//HTTP状态 200
	
	private String condition;	//未知
	
	private String state;		/*快递单当前的状态 ：　 
								0：在途，即货物处于运输过程中；
								1：揽件，货物已由快递公司揽收并且产生了第一条跟踪信息；
								2：疑难，货物寄送过程出了问题；
								3：签收，收件人已签收；
								4：退签，即货物由于用户拒签、超区等原因退回，而且发件人已经签收；
								5：派件，即快递正在进行同城派件；
								6：退回，货物正处于退回发件人的途中；*/
	
	private List<Data> data;
	
	public static class Data{
		
		private String time;
		
		private String context;
		
		private String ftime;

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getContext() {
			return context;
		}

		public void setContext(String context) {
			this.context = context;
		}

		public String getFtime() {
			return ftime;
		}

		public void setFtime(String ftime) {
			this.ftime = ftime;
		}
	}

	public String getNu() {
		return nu;
	}

	public void setNu(String nu) {
		this.nu = nu;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getIscheck() {
		return ischeck;
	}

	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}

	public String getCom() {
		return com;
	}

	public void setCom(String com) {
		this.com = com;
	}

	public String getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Data> getData() {
		return data;
	}

	public void setData(List<Data> data) {
		this.data = data;
	}
	
}
