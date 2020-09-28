# spring-security-with-zuul-api-gateway

Spring Security integration with Zuul API Gateway

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/spring-security-with-zuul-api-gateway/api_gateway_application_diagram.png">

Microservices :
_________________________________________

1) spring-discovery-server		<= Here Register all services
2) spring-oauth-server			<= Authentation Server
3) spring-gateway-server		<= All service talk to each other through Gateway Server
4) product-web-services			<= All product related APIs using Relational Database
5) order-web-services			<= All order lyrics related APIs using Document database

How to run this application :
-------------------------------------

1) Extract the .zip file then go to Application Source Code directory.

2) Import all projects in your fevarate IDE.

3) Now run "spring-discovery-server" and open following URI in your fevarate browser.

        http://localhost:8761

4) Open project "spring-oauth-server". Go to resource directory, check mysql database credintial in application.properties file.

5) Create a database name "product_db" in your mysql DB.

Database Mysql Crediential :

------------------------------------------------------------

    spring.datasource.url = jdbc:mysql://localhost:3306/product_db?useSSL=false
    spring.datasource.username = root
    spring.datasource.password = root
    
------------------------------------------------------------

6) Now Run "spring-oauth-server" application.

7) Then run "spring-oauth-server" test class (SpringOauthServerApplicationTests) to insert some user registration data into mysql DB.

8) Now we try to signin using following user details.

------------------------------------------------------------

    HTTP URI 	: localhost:8080/signin/token?grant_type=password&username=test@gmail.com&password=pass

    HTTP Method	: POST
    HTTP Headers :
      Accept : application/json

    Authorization Type : Basic Auth
    Username : client
    password : secret

-----------------------------------------------------------
9) After successful signin you get following token details :

---------------------------------------------

    {
        "access_token": "e3e10f04-4f4f-4577-9e1c-1b9f016c4d39",
        "token_type": "bearer",
        "refresh_token": "7f000ce7-6b13-433f-832c-fd1f73440af7",
        "expires_in": 43199,
        "scope": "webclient mobileclient"
    }

---------------------------------------------

10) Now you run your spring-gateway-server and product-web-service.

11) Configure MongoDB : Open project "order-web-service". Go to resource directory, check mongo database credintial in application.properties file.

12) Then Run this order-web-service service

13) Now you can execute All APIs and get output : Reference check "Unit Testing Screen Shots" folder.

A) spring-discovery-server :
---------------------------------------------

    http://localhost:8761
    
<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/spring-security-with-zuul-api-gateway/application_eureka_server.JPG">

B) product-web-service	:
---------------------------------------------

    POST: http://localhost:8080/products
    GET: http://localhost:8080/products
    GET: http://localhost:8080/products/{id}
    DELETE: http://localhost:8080/products/{id}

C) order-web-service :
---------------------------------------------

    POST: http://localhost:8080/orders
    GET: http://localhost:8080/orders
    GET: http://localhost:8080/orders/{id}
    DELETE: http://localhost:8080/orders/{id}

---------------------------------------------
14) Note : Configure lombok for application :

i) Download latest lombok jar from : 

    https://projectlombok.org/download

ii) Then double click on it. Then Select STS .exe file.

iii) Then closed and restart STS.

------------------------------------------------------------------
API's Screenshots:
------------------

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/spring-security-with-zuul-api-gateway/api_user_sign_in.JPG">

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/spring-security-with-zuul-api-gateway/api_save_product.JPG">

<img src="https://github.com/90rajibgarai/doc-important-links/blob/master/spring-security-with-zuul-api-gateway/api_get_products.JPG">

