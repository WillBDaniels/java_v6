Vantiv-Developer-Portal and Vantiv-Payment-Web-Services
=======================================================
*** IMPORTANT You will need to create a project at https://apideveloper.vantiv.com/ in order to get access to the sandbox and test your code

Integration Guidelines available here: https://apideveloper.vantiv.com/docs/payment-web-services/implementation-guidelines<br>
Online developers guide: https://apideveloper.vantiv.com/documentation<br>

Entry point is Home.java, this will start the GUI.

The Java CXF implementation of Vantiv-Developer-Portal sample code demonstrating how to integrate with both Vantiv-Developer-Portal as well as Vantiv-Payment-Web-Services
- Contains a REST sample* for integrating to Vantiv-Developer-Portal 
- Contains a SOAP sample* for integrating to Payment-Web-Services

* Please note that if you are unsure of which solution which will match your solution needs you should contact a vantiv solution consultant first before starting any development efforts. Not doing so may lead to lost coding time. 


Resources used:
	•	Eclipse Indigo - https://www.eclipse.org/downloads/
	•	Java 6 - http://www.oracle.com/technetwork/java/javasebusiness/downloads/java-archive-downloads-javase6-419409.html 
	•	Included in Maven POM.xml file:
		o	Apache CXF 3.01 – used to consume WSDL and build proxy classes for sending/receiving SOAP messages.
				 http://cxf.apache.org/download.html
		o	GSON 2.2.4 –  used to convert/revert JSON objects.
				http://mvnrepository.com/artifact/com.google.code.gson/gson/2.2.4
		o	Log4j – used for logging  REST messages to and from Apigee (NOT USED FOR SOAP LOGGING).
				http://mvnrepository.com/artifact/log4j/log4j
			IMPORTANT: To enable log4j logging functionality (for REST/Apigee logging only), 
			you must add the log4j.properties file to the classpath within eclipse. 
			To do this follow these steps:
			•	Right click your project folder  -> Run as -> Run Configurations -> Classpath Tab -> 
				Click on User Entries -> Click on Advanced -> Check the Add Folders option and and hit OK -> 
				browse to your folder which holds the log4j.properties file and add it. 
				If you have the source files from GITHUB, this properties file will be located 
				in the "/Resources" folder.


####Folder Contents
logs - This folder contains SoapLog.txt and ApigeeLog.txt. These files log the request and responses of all SOAP/REST requests.<br>
Resources - This folder contains the WSDL (6.0.7) and the log4j properties folder. It is recommended to use log4j, but you can use other logging libraries.<br>
src - The source folder containing all code.
	* com.vantiv.pws.apigee - contains all code for sending JSON requests/responses to and from Apigee.
		* com.vantiv.pws.apigee.objects
			* Address.java - container for all address information
			* ApigeeObject.java - container for all sub-containers
			* Card.java - container for all Card information
			* CreateJsonRequest.java - This is the base class that creates an object (ApigeeObject) that conforms to the data contract of Apigee PWS portal. 
				The values that are used to populate these fields are found in the DataStore class. Each function creates an ApigeeObject which can then be 
				serialized into a JSON object to be sent to Apigee by using RESTFUL services.
			* Credentials.java - container for credential information (username and password)
			* Merchant.java - container for all merchant information.
			* PWS_ElementTranslator.java -  This class is used to translate a SOAP request to a Json Request (REST). It is useful if you have consumed the WSDL 
				and have created the java proxy classes as it will convert the Request Object to a JSON object, which can then be sent to Apigee through an HTTP post.
			* RestDriver.java - This class is used to send/receive JSON requests to Apigee through RESTFUL
				services. To send an authorize, call this.startTransaction("Authorize"). It will send a JSON request over HTTP to Apigee, the values for the Authorize
				request will be pulled from the DataStore class. The response comes back as a JSON object from which you can pull the data from. This class converts the
				JSON response into a Response object. The request and responses are logged by log4j. The log4j properties file can be found in the Resources folder.
			* SendJsonRequest.java -  This class sends a JSON request to Apigee with RESTFUL services. It returns a HttpResponse object.
			* Terminal.java - Container for all terminal information.
			* Transaction.java - container for all transaction information.
			
	* com.vantiv.pws.soap - contains all code for sending SOAP requests/responses to and from PWS direct.
		* com.vantiv.pws.soap.objects
			* InitializeClient.java - This class sets up the PWS SOAP client that is used to send and receive SOAP messages to PWS.
			* SoapDriver.java - This class is used to send/receive SOAP requests to PWS direct. To send an authorize, call this.startTransaction("Authorize"). 
				It will send a SOAP request to PWS, the values for the Authorize request will be pulled from the DataStore class. The response comes back as a Response Object 
				from which you can pull the data from. The SOAP request and responses are logged by CXF interceptors which is setup in InitializeClient.java.
			* TestAdjust.java - Creates an AdjustRequest object. Values pulled from DataStore.java.
			* TestAuthorize.java - Creates an AuthorizeRequest object. Values pulled from DataStore.java.
			* TestBatchBalance.java - Creates an BatchBalanceRequest object. Values pulled from DataStore.java.
			* TestCancel.java - Creates an CancelRequestst object. Values pulled from DataStore.java.
			* TestCapture.java - Creates an CaptureRequest object. Values pulled from DataStore.java.
			* TestCloseBatch.java - Creates an CloseBatchRequest object. Values pulled from DataStore.java.
			* TestPurchase.java - Creates an PurchaseRequest object. Values pulled from DataStore.java.
			* TestRefund.java - Creates an RefundRequest object. Values pulled from DataStore.java.
			* TestTokenize.java - Creates an TokenizeRequest object. Values pulled from DataStore.java.
			* TransactionResponseParse.java -  This class takes a transaction response object from a SOAP response and parses out any useful information from it 
				to display to the user in a string.
		* com.vantiv.pws.soap.handlers - 
			* PaymentsHandlerResolver.java -
			* SOAPLoggingHandler.java - 
			* WsseHeaderHandler.java - 
			
	* com.vantiv.pws.resources - contains classes that are used between both apigee and soap classes. DataStore.java is where all possible values that can be sent to PWS are stored. When a request
							is sent to PWS or Apigee, the requests are poplulated with values from DataStore.java. In the code this class is constantly referred to as 'globals'. Utils.java contains
							helper methods that are useful for sending requests to and from both PWS and apigee.
	* com.vantiv.pws.tool.gui - contains Home.java which is a GUI interface that can be used to easily set values for sending SOAP requests to PWS and JSON requests to Apigee. This class contains
							no logic, it is strictly for displaying information easily to the user. 
									

Vantiv-Developer-Portal and Vantiv-Payment-Web-Services
=======================================================
*** IMPORTANT You will need to create a project at http://vantiv.devportal.apigee.com/ in order to get access to the sandbox and test your code

Integration Guidelines available here: Coming
Online developers guide: Coming

Entry point is Home.java, this will start the GUI.

The Java CXF implementation of Vantiv-Developer-Portal sample code demonstrating how to integrate with both Vantiv-Developer-Portal as well as Vantiv-Payment-Web-Services
- Contains a REST sample* for integrating to Vantiv-Developer-Portal 
- Contains a SOAP sample* for integrating to Payment-Web-Services

* Please note that if you are unsure of which solution which will match your solution needs you should contact a vantiv solution consultant first before starting any development efforts. Not doing so may lead to lost coding time. 


Table of Contents
=======================
logs - This folder contains SoapLog.txt and ApigeeLog.txt. These files log the request and responses of all SOAP/REST requests.
Resources - This folder contains the WSDL (6.0.7) and the log4j properties folder. It is recommended to use log4j, but you can use other logging libraries.
src - The source folder containing all code.
	* com.vantiv.pws.apigee - contains all code for sending JSON requests/responses to and from Apigee.
		* com.vantiv.pws.apigee.objects
			* Address.java - container for all address information
			* ApigeeObject.java - container for all sub-containers
			* Card.java - container for all Card information
			* CreateJsonRequest.java - This is the base class that creates an object (ApigeeObject) that conforms to the data contract of Apigee PWS portal. 
				The values that are used to populate these fields are found in the DataStore class. Each function creates an ApigeeObject which can then be 
				serialized into a JSON object to be sent to Apigee by using RESTFUL services.
			* Credentials.java - container for credential information (username and password)
			* Merchant.java - container for all merchant information.
			* PWS_ElementTranslator.java -  This class is used to translate a SOAP request to a Json Request (REST). It is useful if you have consumed the WSDL 
				and have created the java proxy classes as it will convert the Request Object to a JSON object, which can then be sent to Apigee through an HTTP post.
			* RestDriver.java - This class is used to send/receive JSON requests to Apigee through RESTFUL
				services. To send an authorize, call this.startTransaction("Authorize"). It will send a JSON request over HTTP to Apigee, the values for the Authorize
				request will be pulled from the DataStore class. The response comes back as a JSON object from which you can pull the data from. This class converts the
				JSON response into a Response object. The request and responses are logged by log4j. The log4j properties file can be found in the Resources folder.
			* SendJsonRequest.java -  This class sends a JSON request to Apigee with RESTFUL services. It returns a HttpResponse object.
			* Terminal.java - Container for all terminal information.
			* Transaction.java - container for all transaction information.
			
	* com.vantiv.pws.soap - contains all code for sending SOAP requests/responses to and from PWS direct.
		* com.vantiv.pws.soap.objects
			* InitializeClient.java - This class sets up the PWS SOAP client that is used to send and receive SOAP messages to PWS.
			* SoapDriver.java - This class is used to send/receive SOAP requests to PWS direct. To send an authorize, call this.startTransaction("Authorize"). 
				It will send a SOAP request to PWS, the values for the Authorize request will be pulled from the DataStore class. The response comes back as a Response Object 
				from which you can pull the data from. The SOAP request and responses are logged by CXF interceptors which is setup in InitializeClient.java.
			* TestAdjust.java - Creates an AdjustRequest object. Values pulled from DataStore.java.
			* TestAuthorize.java - Creates an AuthorizeRequest object. Values pulled from DataStore.java.
			* TestBatchBalance.java - Creates an BatchBalanceRequest object. Values pulled from DataStore.java.
			* TestCancel.java - Creates an CancelRequestst object. Values pulled from DataStore.java.
			* TestCapture.java - Creates an CaptureRequest object. Values pulled from DataStore.java.
			* TestCloseBatch.java - Creates an CloseBatchRequest object. Values pulled from DataStore.java.
			* TestPurchase.java - Creates an PurchaseRequest object. Values pulled from DataStore.java.
			* TestRefund.java - Creates an RefundRequest object. Values pulled from DataStore.java.
			* TestTokenize.java - Creates an TokenizeRequest object. Values pulled from DataStore.java.
			* TransactionResponseParse.java -  This class takes a transaction response object from a SOAP response and parses out any useful information from it 
				to display to the user in a string.
		* com.vantiv.pws.soap.handlers - These are SOAP handler classes that are necessary for inserting the correct WSSE security information into the SOAP headers. These		
				should not be modified.
			* PaymentsHandlerResolver.java - adds the WSSE security data into a SOAP message
			* SOAPLoggingHandler.java - handler for logging the SOAP messages.
			* WsseHeaderHandler.java - used by PaymentsHandlerResolver to insert the wsse security info.
			
	* com.vantiv.pws.resources - contains classes that are used between both apigee and soap classes. DataStore.java is where all possible values that can be sent to PWS are stored. When a request
							is sent to PWS or Apigee, the requests are poplulated with values from DataStore.java. In the code this class is constantly referred to as 'globals'. Utils.java contains
							helper methods that are useful for sending requests to and from both PWS and apigee.
	* com.vantiv.pws.tool.gui - contains Home.java which is a GUI interface that can be used to easily set values for sending SOAP requests to PWS and JSON requests to Apigee. This class contains
							no logic, it is strictly for displaying information easily to the user. 
									

