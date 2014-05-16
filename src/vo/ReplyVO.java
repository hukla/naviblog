package vo;

public class ReplyVO extends BaseVO {
	private int replyId;
	private String userId;
	private String nickname;
	private int postId;
	private String content;
	private boolean publicReply;
	private int refId;
	
	public ReplyVO() {}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isPublicReply() {
		return publicReply;
	}

	public void setPublicReply(boolean publicReply) {
		this.publicReply = publicReply;
	}

	public int getRefId() {
		return refId;
	}

	public void setRefId(int refId) {
		this.refId = refId;
	}
	
	
}
