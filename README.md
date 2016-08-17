# baiduapi
百度短网址接口,IP 地址接口。

```xml
	<dependency>
	  <groupId>com.github.liyiorg</groupId>
	  <artifactId>baiduapi</artifactId>
	  <version>1.0.0</version>
	</dependency>
```

## 示例
```java
	//短网址
	DwzResult result = DwzAPI.create("http://www.test.com");
	if(result != null && result.isSuccess()){
		System.out.println(result.getTinyurl());
	}

	//IP 地址解析
	IpResult result = IpAPI.ip("124.193.218.82","ak",null,null);
	if(result != null && result.isSuccess()){
		System.out.println(result.getAddress());
	}
	
```