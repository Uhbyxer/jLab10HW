<%@ taglib uri="/WEB-INF/customTag.tld" prefix="ct" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSTL Custom Tag Today</title>
  </head>
  <body>
  Opapa
  
        <h2 align="center"><ct:today format="MMMM dd, yyyy"/></h2>
        
        <br> <br> Test2<br>
        
                <h2>
            Upper Case : 
              <ct:changeCase case="upper">
            Hello World
              </ct:changeCase>
        </h2>
        <h2>
            Lower Case : 
            <ct:changeCase case="lower">
                Hello World
            </ct:changeCase>
        </h2>
        
        
  </body>
</html>