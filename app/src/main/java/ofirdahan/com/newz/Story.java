package ofirdahan.com.newz;

/**
 * Created by ofirdahan on 10/26/16.
 */

public class Story {
    private String mCreatedAt;
    private String mTitle;
    private String mAuthor;
    private int mPoints;

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public String getPoints() {
        return String.valueOf(mPoints);
    }

    public void setPoints(int mPoints) {
        this.mPoints = mPoints;
    }
}
