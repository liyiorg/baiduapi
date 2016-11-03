
## 示例
```java
	//百度短网址
	DwzResult result = DwzAPI.create("http://www.test.com");
	if(result != null && result.isSuccess()){
		System.out.println(result.getTinyurl());
	}

	//百度IP地址解析
	IpResult result = IpAPI.ip("124.193.218.82","ak",null,null);
	if(result != null && result.isSuccess()){
		System.out.println(result.getAddress());
	}
	
```