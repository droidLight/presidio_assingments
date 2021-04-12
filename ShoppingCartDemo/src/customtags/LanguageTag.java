package customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import java.util.ResourceBundle;

public class LanguageTag extends TagSupport {

	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	@Override
	public int doEndTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			ResourceBundle rb = (ResourceBundle) pageContext.getSession().getAttribute("rb");
			out.write(rb.getString(text));
		} catch (Exception e) {
			System.out.println("LanguageTag: " + e);
		}

		return super.doEndTag();
	}

}
