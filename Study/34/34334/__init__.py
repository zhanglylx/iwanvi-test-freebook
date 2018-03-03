import http.client  
conn = http.client.HTTPConnection("www.baidu.com")  
conn.request("GET", "/index.html")  
r1 = conn.getresponse()#返回的是HTTPResponse对象  
