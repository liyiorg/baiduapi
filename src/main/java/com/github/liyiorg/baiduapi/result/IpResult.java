package com.github.liyiorg.baiduapi.result;

public class IpResult extends BaseResult{

	private String address;

	private Content content;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public static class Content {
		private String address;

		private AddressDetail address_detail;

		private Point point;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public AddressDetail getAddress_detail() {
			return address_detail;
		}

		public void setAddress_detail(AddressDetail address_detail) {
			this.address_detail = address_detail;
		}

		public Point getPoint() {
			return point;
		}

		public void setPoint(Point point) {
			this.point = point;
		}

		public static class AddressDetail {

			private String city;
			private String city_code;
			private String district;
			private String province;
			private String street;

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getCity_code() {
				return city_code;
			}

			public void setCity_code(String city_code) {
				this.city_code = city_code;
			}

			public String getDistrict() {
				return district;
			}

			public void setDistrict(String district) {
				this.district = district;
			}

			public String getProvince() {
				return province;
			}

			public void setProvince(String province) {
				this.province = province;
			}

			public String getStreet() {
				return street;
			}

			public void setStreet(String street) {
				this.street = street;
			}

		}

		public static class Point {

			private String x;

			private String y;

			public String getX() {
				return x;
			}

			public void setX(String x) {
				this.x = x;
			}

			public String getY() {
				return y;
			}

			public void setY(String y) {
				this.y = y;
			}

		}

	}
}
