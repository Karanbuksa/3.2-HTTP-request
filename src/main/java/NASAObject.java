import com.fasterxml.jackson.annotation.JsonProperty;

public class NASAObject {
    String copyright;
    String date;
    String explanation;
    String hdurl;
    String mediaType;
    String serviceVersion;
    String title;
    String url;

    public NASAObject(@JsonProperty("copyright") String copyright,
                      @JsonProperty("date") String date,
                      @JsonProperty("explanation") String explanation,
                      @JsonProperty("hdurl") String hdURL,
                      @JsonProperty("media_type") String mediaType,
                      @JsonProperty("service_version") String serviceVersion,
                      @JsonProperty("title") String title,
                      @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdURL;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return
                "copyright='" + copyright + '\'' +
                        ", date='" + date + '\'' +
                        ", explanation='" + explanation + '\'' +
                        ", hdurl='" + hdurl + '\'' +
                        ", mediaType='" + mediaType + '\'' +
                        ", serviceVersion='" + serviceVersion + '\'' +
                        ", title='" + title + '\'' +
                        ", url='" + url + '\'';
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public void setServiceVersion(String serviceVersion) {
        this.serviceVersion = serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
