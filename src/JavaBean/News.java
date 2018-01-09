package JavaBean;

public class News {
    private int newsId;
    private String newsBody;
    private String newsTitle;

    public int getNewsId() {
        return newsId;
    }

    public String getNewsBody() {
        return newsBody;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsBody(String newsBody) {
        this.newsBody = newsBody;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }
}
