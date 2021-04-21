package pojos;

import java.io.Serializable;

public class Comment implements Serializable{
	
	private String commentText;

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}
	
}
