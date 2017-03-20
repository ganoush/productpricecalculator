Features:
--------
Application was built on Java 8, Springboot/cloud/hystrix, Maven in a MAC OS machine & intelliJ IDE
Application uses sl4j simple logging.

Application contains two modules. One to host Microservices and other for Circuit Breaker

Circuit Breaker module:
----------------------
The timeout set was 100ms
These values can be changed in config.properties

Whenever these above conditions are not met a default value is returned based on the request input.

Sample url when hosted in my local: http://localhost:8080/api/priceQuote/GOOG/123.32/12.0
where GOOG is the product quote which is of type String,
      123.32 is the value of the product attribute
      12.0 is the volaitlity

Circuit breaker looks for the microservices url avaailable at http://localhost:8080/api/priceQuote
With Circuit Breaker: http://localhost:8080/api/priceQuote/GOOG/123.32/12.0

Microservices Module:
---------------------
Application uses random delay mechanism to manipulate the response.
On start of the application the following product quotes are loaded:

GOOG/123.32/12.0 => 25.32, getDate(2016,11,21)
MSFT/243.22/6.1 => 54.43, getDate(2016,4,15)
QLCM/83.22/3.54 => 76.83, getDate(2016,9,05)

only the product price of these items can be fetched. (Uses an hashmap not a database)
The application runs in the port 8060

sample url
http://localhost:8060/product/productPrice/GOOG/123.32/12.0


Note:
----
I could not able to complete the test cases as I could not find time.
However the REST test cases are similiar to that of other projects that I have it in my github:
refer: https://github.com/ganoush/watermarkTest/tree/master/src/test/java/com/springerNature/watermark