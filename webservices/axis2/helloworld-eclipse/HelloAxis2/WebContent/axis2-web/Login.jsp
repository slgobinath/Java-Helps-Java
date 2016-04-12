<%--
  ~ Licensed to the Apache Software Foundation (ASF) under one
  ~ or more contributor license agreements. See the NOTICE file
  ~ distributed with this work for additional information
  ~ regarding copyright ownership. The ASF licenses this file
  ~ to you under the Apache License, Version 2.0 (the
  ~ "License"); you may not use this file except in compliance
  ~ with the License. You may obtain a copy of the License at
  ~
  ~ http://www.apache.org/licenses/LICENSE-2.0
  ~
  ~ Unless required by applicable law or agreed to in writing,
  ~ software distributed under the License is distributed on an
  ~ "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
  ~ KIND, either express or implied. See the License for the
  ~ specific language governing permissions and limitations
  ~ under the License.
  --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
  <head>
    <jsp:include page="include/httpbase.jsp"/>
    <title>Login to Axis2 :: Administration page</title>
    <link href="axis2-web/css/axis-style.css" rel="stylesheet" type="text/css">
  </head>

  <body onload="javascript:document.LoginForm.userName.focus();">
    <jsp:include page="include/header.inc"/>
    <jsp:include page="include/link-footer.jsp"/>
    <table summary="main content table" class="FULL_BLANK">
      <tr>
        <td valign="top">
        	<h2>Welcome :</h2>
        	<p>Welcome to the Axis2 administration console. From inside the Axis2 administration console you can :</p>
	    	<ul style="list-style: none;" class="loginUL">
	       		<li>Check on the health of your Axis2 deployment.</li>
 	       		<li>Change any parameters at run time.</li>
 	       		<li>Upload new services into Axis2 [Service hot-deployment].</li>
 	   		</ul>
	        <span style="color:orange">Warning: Please note that configuration changes done through the administration console
    	    will be lost when the server is restarted.</span>
    	</td>
        <td valign="top" align="left">
          <form method="post" name="LoginForm" action="axis2-admin/login">
            <table summary="login table" class="LOG_IN_FORM">
              <tr>
                <td align="center" colspan="2" style="bgcolor:#b0b0b0"><span style="color:#FFFFFF">Login</span></td>
              </tr>
              <tr>
                 <td align="center" colspan="2">&nbsp;</td>
               </tr>
              <tr>
                <td align="right">Username:</td>
                <td><input style="align:left" type="text" name="userName" tabindex="1">
                </td>
              </tr>
              <tr>
                <td align="right">Password : </td>
                <td><input style="align:left" type="password" name="password" tabindex="2">
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  <br>
                </td>
              </tr>
              <tr>
                <td align="center" colspan="2">
                  <input name="cancel" type="reset" value=" Clear "> &nbsp; &nbsp;
                  <input name="submit" type="submit" value=" Login ">
                </td>
              </tr>
              <tr>
                <td align="center" colspan="2">
                  <span style="color:red">&nbsp;<% if (request.getAttribute("errorMessage") != null) {%><%= request.getAttribute("errorMessage")%><% } %>&nbsp;</span>
                </td>
              </tr>
            </table>
          </form>
          <br><br><br><br><br><br>
        </td>
      </tr>
    </table>   
    <jsp:include page="include/footer.inc"/>
  </body>
</html>


