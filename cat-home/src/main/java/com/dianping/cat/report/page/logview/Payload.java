package com.dianping.cat.report.page.logview;

import java.util.Arrays;

import com.dianping.cat.report.ReportPage;
import com.dianping.cat.report.page.AbstractReportPayload;
import com.site.web.mvc.ActionContext;
import com.site.web.mvc.payload.annotation.FieldMeta;
import com.site.web.mvc.payload.annotation.PathMeta;

public class Payload extends AbstractReportPayload<Action> {
	public Payload() {
		super(ReportPage.LOGVIEW);
	}

	@FieldMeta("op")
	private Action m_action;

	@FieldMeta("header")
	private boolean m_showHeader = true;

	@PathMeta("path")
	private String[] m_path;

	@FieldMeta("tag1")
	private String m_tag1;

	@FieldMeta("tag2")
	private String m_tag2;

	@Override
	public Action getAction() {
		if (m_action == null) {
			return Action.VIEW;
		}
		return m_action;
	}

	public String getDirection() {
		if (m_tag1 != null) {
			return "false";
		} else if (m_tag2 != null) {
			return "true";
		} else {
			return null;
		}
	}

	public String[] getPath() {
		return m_path;
	}

	public String getTag() {
		if (m_tag1 != null) {
			return m_tag1;
		} else if (m_tag2 != null) {
			return m_tag2;
		} else {
			return null;
		}
	}

	public boolean isShowHeader() {
		return m_showHeader;
	}

	public void setAction(String action) {
		m_action = Action.getByName(action, Action.VIEW);
	}

	public void setPath(String[] path) {
		if (path == null) {
			m_path = new String[0];
		} else {
			m_path = Arrays.copyOf(path, path.length);
		}
	}

	public void setShowHeader(String showHeader) {
		m_showHeader = !"no".equals(showHeader);
	}

	public void setTag1(String tag1) {
		m_tag1 = tag1;
	}

	public void setTag2(String tag2) {
		m_tag2 = tag2;
	}

	@Override
	public void validate(ActionContext<?> ctx) {
	}
}
