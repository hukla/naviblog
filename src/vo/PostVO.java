package vo;

public class PostVO extends BaseVO {
	private int postId;
	private String userId;
	private String blogId;
	private String title;
	private String content;
	private boolean permitReply;
	private boolean publicPost;
	
	public PostVO() {}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBlogId() {
		return blogId;
	}

	public void setBlogId(String blogId) {
		this.blogId = blogId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isPermitReply() {
		return permitReply;
	}

	public void setPermitReply(boolean permitReply) {
		this.permitReply = permitReply;
	}

	public boolean isPublicPost() {
		return publicPost;
	}

	public void setPublicPost(boolean publicPost) {
		this.publicPost = publicPost;
	}
	
	
}
