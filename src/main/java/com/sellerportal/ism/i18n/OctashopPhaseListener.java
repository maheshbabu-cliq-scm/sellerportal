package com.sellerportal.ism.i18n;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OctashopPhaseListener implements PhaseListener {
	private static final Log LOGGER = LogFactory
			.getLog(OctashopPhaseListener.class);

	public void afterPhase(PhaseEvent evt) {
		String msg  = "AFTER";
		if (PhaseId.APPLY_REQUEST_VALUES.equals(evt.getPhaseId())) {
			processFormAndChildren(msg,evt);
		}
		
		if (PhaseId.INVOKE_APPLICATION.equals(evt.getPhaseId())) {
			processFormAndChildren(msg,evt);
		}
		
		if (PhaseId.RENDER_RESPONSE.equals(evt.getPhaseId())) {
			processFormAndChildren(msg,evt);
		}
	}

	public void beforePhase(PhaseEvent evt) {
		String msg = "BEFORE";
		if (PhaseId.APPLY_REQUEST_VALUES.equals(evt.getPhaseId())) {
			processFormAndChildren(msg,evt);
		}
		
		if (PhaseId.INVOKE_APPLICATION.equals(evt.getPhaseId())) {
			processFormAndChildren(msg,evt);
		}
		
		if (PhaseId.RENDER_RESPONSE.equals(evt.getPhaseId())) {
			processFormAndChildren(msg,evt);
		}
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

	public void processFormAndChildren(String msg,PhaseEvent evt) {
		/*
		FacesContext fc = FacesContext.getCurrentInstance();
		if(fc.getViewRoot() == null)
			return;
		fc.getViewRoot().setLocale(new Locale(I18nHelper.getLanguageCode(null)));
		List children = fc.getViewRoot().getChildren();
		if(children == null || children.size() == 0)
			return;
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			UIComponent element = (UIComponent) iter.next();
			if (element instanceof HtmlForm) {
				HtmlForm form = (HtmlForm) element;

				LOGGER.info(msg+" [" + evt.getPhaseId() + "] " + " Form  "+ form.getId() + " Enctype ::" + form.getEnctype());
				//form.setEnctype("multipart/form-data");
				for (Iterator it = form.getChildren().iterator(); it.hasNext();) {
					UIComponent ec = (UIComponent) it.next();

					if (ec instanceof UIInput) {
						UIInput ic = (UIInput) ec;
						LOGGER.info(msg+" [" + evt.getPhaseId() + "]" + "\t "
								+ ic.getId() + " TYPE = " + ec.getFamily()
								+ " Input :" + ic.getSubmittedValue() + " "
								+ ic.getValue());
					}
				}
			}
		}
		*/
	}
}
