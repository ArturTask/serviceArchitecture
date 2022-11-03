# SSL tutorial

####**generate key:**
keytool -genkeypair -alias soa -keyalg RSA -keysize 4096 -storetype jks -keystore soa.jks -validity 3650 -storepass password

 ####**add to application.properties:**
server.ssl.key-alias=soa

server.ssl.key-store-type=JKS

server.ssl.key-password=password

server.ssl.key-store=classpath:soa.jks

server.ssl.key-store-password=password

server.ssl.enabled=true

####**move soa.jks to src/main/resources**

####**same for second service (from 1 to 3) BUT other alias and keystore**
keytool -genkeypair -alias soa2 -keyalg RSA -keysize 4096 -storetype jks -keystore soa2.jks -validity 3650 -storepass password

####**import certificates** 
go to your localhost:8080/somUrl/get and download certificate (first service in my case - dragons service) 
it would be file "firstname lastname.cer" in my case "a a.cer". Then import your certificate (from first service aca dragons service in my case) to your second service keystore (in my case my second service's keystore is soa2.jks)

keytool -import -alias soa -keystore soa2.jks -file a\ a.cer

Alias in this case means alias of certificate (if something goes wrong try without -alias key)

If Everething is correct you will see the question: "Trust this certificate?"

And same for second certificate (download it (second service aka killers service's certificate) and import to the first service keystore dragons service's keystore)
  

## Don't forget
To add SSLConnectionSocketFactory to your httpClient so that it also knows about ssl
**(Only needed for second service in HttpClient if you send request from second service)**

Check RequestService in SecondServiceArchitecture for better understanding  
 
## **enjoy**

### useful materials:

https://www.aurigait.com/blog/how-to-implement-2-way-ssl-using-spring-boot/
https://habr.com/ru/company/dbtc/blog/487318/?ysclid=l9bjqwztc1659089142
