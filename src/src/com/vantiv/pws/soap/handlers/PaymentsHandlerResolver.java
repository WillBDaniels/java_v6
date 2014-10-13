package com.vantiv.pws.soap.handlers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

/**
*/
public class PaymentsHandlerResolver implements HandlerResolver {

    private final List<Handler> handlerChain = new ArrayList<Handler>();

    public PaymentsHandlerResolver(String username, String password) {
        WsseHeaderHandler loginHeaderHandler = new WsseHeaderHandler(username, password);
        handlerChain.add(loginHeaderHandler);
    }

    public void addMessageHandler( SOAPHandler<SOAPMessageContext> handler )
    {
        handlerChain.add(handler);
    }

    @Override
	public List<Handler> getHandlerChain(PortInfo portInfo) {
        return handlerChain;
    }
}
