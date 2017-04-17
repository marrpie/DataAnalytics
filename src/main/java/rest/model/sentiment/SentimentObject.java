package rest.model.sentiment;

/**
 * Created by Marr on 2017-04-17.
 */
public class SentimentObject {
    private long id;
    private String text;
    private double sentiment;

    public SentimentObject(long id, String text, double sentiment) {
        this.id = id;
        this.text = text;
        this.sentiment = sentiment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getSentiment() {
        return sentiment;
    }

    public void setSentiment(double sentiment) {
        this.sentiment = sentiment;
    }
}
