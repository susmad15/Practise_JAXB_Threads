package itemstore;

import com.google.gson.annotations.Expose;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.commons.codec.digest.DigestUtils;

@XmlAccessorType(XmlAccessType.FIELD)
public class Item {

    @Expose
    @XmlElement
    private String data;

    @Expose
    @XmlElement
    private long timeStamp;

    @Expose
    @XmlElement
    private String previousHash;

    @Expose
    @XmlElement
    private String hash;

    @XmlTransient
    private Item previousItem;

    public Item(String previousHash) {
        data = UUID.randomUUID().toString();
        this.previousHash = previousHash;
        timeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        hash = calculateHash();
    }

    public Item() {
    }

    public String calculateHash() {
        return DigestUtils.sha256Hex(previousHash + timeStamp + data);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Item getPreviousItem() {
        return previousItem;
    }

    public void setPreviousItem(Item previousItem) {
        this.previousItem = previousItem;
    }

}
