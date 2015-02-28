package com.javahelps.stripes.helloworld.action;

import java.util.Date;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;

public class TimeActionBean implements ActionBean {
	private static final String VIEW = "/WEB-INF/jsp/result.jsp";
	private ActionBeanContext context;
	private Date time;

	@Override
	public ActionBeanContext getContext() {
		return this.context;
	}

	@Override
	public void setContext(ActionBeanContext ctx) {
		this.context = ctx;
	}

	public Date getTime() {
		return this.time;
	}

	@DefaultHandler
	public Resolution currentTime() {
		this.time = new Date();
		return new ForwardResolution(VIEW);
	}
}
