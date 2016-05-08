<%@page import="com.javahelps.samplecarbon.ui.SampleServiceClient"%>
<%@ page import="org.apache.axis2.context.ConfigurationContext"%>
<%@ page import="org.wso2.carbon.CarbonConstants"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIUtil"%>
<%@ page import="org.wso2.carbon.utils.ServerConstants"%>
<%@ page import="org.wso2.carbon.ui.CarbonUIMessage"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://wso2.org/projects/carbon/taglibs/carbontags.jar"
	prefix="carbon"%>
<%
    String[] languages;
	SampleServiceClient client;

	String serverURL = CarbonUIUtil.getServerURL(config.getServletContext(), session);
	ConfigurationContext configContext = (ConfigurationContext) config.getServletContext()
			.getAttribute(CarbonConstants.CONFIGURATION_CONTEXT);
	String cookie = (String) session.getAttribute(ServerConstants.ADMIN_SERVICE_COOKIE);

	try {
		client = new SampleServiceClient(configContext, serverURL, cookie);
		languages = client.getLanguages();
	} catch (Exception e) {
		CarbonUIMessage.sendCarbonUIMessage(e.getMessage(), CarbonUIMessage.ERROR, request, e);
%>
<script type="text/javascript">
	location.href = "../admin/error.jsp";
</script>
<%
    return;
    }
%>

<div id="middle">
	<h2>Sample Carbon</h2>

	<div id="workArea">
		<table class="styledLeft" id="moduleTable">
			<thead>
				<tr>
					<th width="100%">Languages</th>
				</tr>
			</thead>
			<tbody>
				<%
				    for (String language : languages) {
				%>
				<tr>
					<td><%=language%></td>
				</tr>
				<%
				    }
				%>
			</tbody>
		</table>
	</div>
</div>