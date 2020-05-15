package itemstore;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.UUID;
import org.apache.commons.codec.digest.DigestUtils;


public class Item {
   
    private String data;
    
    private long timeStamp;
    
    private String previousHash;
    
    private String hash;
    
    private Item previousItem;

    public Item(String previousHash) {
        data = UUID.randomUUID().toString();
        this.previousHash = previousHash;
        timeStamp = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        hash = calculateHash();
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
