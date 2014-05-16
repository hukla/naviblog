package vo;

public class BlogVO extends BaseVO {
	private String blogId;
	private String title;
	private String codeId;
	private String tag;
	private boolean publicBlog;
	private int cntDisplayPost;
	private String status;
	private String imagePath;
	
	public BlogVO() {}

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

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public boolean isPublicBlog() {
		return publicBlog;
	}

	public void setPublicBlog(boolean publicBlog) {
		this.publicBlog = publicBlog;
	}

	public int getCntDisplayPost() {
		return cntDisplayPost;
	}

	public void setCntDisplayPost(int cntDisplayPost) {
		this.cntDisplayPost = cntDisplayPost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
}
