package com.ocpp.endpoint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import ocpp.cs._2015._10.AuthorizationStatus;
import ocpp.cs._2015._10.AuthorizeRequest;
import ocpp.cs._2015._10.AuthorizeResponse;
import ocpp.cs._2015._10.IdTagInfo;
import ocpp.cs._2015._10.ObjectFactory;

@Endpoint
public class OCPPEndpoint {

	private static final String NAMESPACE_URI = "urn://Ocpp/Cs/2015/10/";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "authorizeRequest")
	@ResponsePayload
	public AuthorizeResponse authorize(@RequestPayload AuthorizeRequest authorizeRequest) {
		ObjectFactory objectFactory = new ObjectFactory();
		AuthorizeResponse response = objectFactory.createAuthorizeResponse();
		IdTagInfo idTagInfo = new IdTagInfo();
		idTagInfo.setStatus(AuthorizationStatus.ACCEPTED);
		idTagInfo.setParentIdTag("PARENTIDTAG1");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String lexicalRepresentation = dateFormat.format(new Date());
		try {
			idTagInfo.setExpiryDate(DatatypeFactory.newInstance().newXMLGregorianCalendar(lexicalRepresentation));
		} catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		response.setIdTagInfo(idTagInfo);
		return response;
	}
}
