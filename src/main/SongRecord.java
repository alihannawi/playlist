package main;

public class SongRecord {

    private String key;
    private int location;

    public SongRecord(String key, int location) {
        this.key = key;
        this.location = location;
    }

    public String getKey() {
        return key;
    }

    public int getLocation() {
        return location;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return key + " | " + location;
    }

    public int compareTo(SongRecord songRecord) {

        int compare = this.key.compareTo(songRecord.getKey());

        if (compare != 0)
            return compare;
        else {

            if (this.key.compareTo(songRecord.getKey()) < 0)
                return -1;

            if (this.key.compareTo(songRecord.getKey()) > 0)
                return 1;
        }

        return 0;
    }
}
