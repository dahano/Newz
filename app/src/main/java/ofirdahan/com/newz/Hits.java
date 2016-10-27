package ofirdahan.com.newz;

/**
 * Created by ofirdahan on 10/26/16.
 */

public class Hits {
    private String mCreatedAt;
    private String mTitle;
    private String mAuthor;
    private Double mPoints;

    private String getCreatedAt() {
        return mCreatedAt;
    }

    private void setCreatedAt(String mCreatedAt) {
        this.mCreatedAt = mCreatedAt;
    }

    private String getTitle() {
        return mTitle;
    }

    private void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    private String getAuthor() {
        return mAuthor;
    }

    private void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    private Double getPoints() {
        return mPoints;
    }

    private void setPoints(Double mPoints) {
        this.mPoints = mPoints;
    }
}
