package main;

import java.util.ArrayList;

public class RecordArray {

    private SongRecord[] records;
    private int ptr;

    public RecordArray(int size) {

        records = new SongRecord[size];
        ptr = 0;
    }

    public int getSize() {
        return records.length;
    }

    public void insert(SongRecord record) {

        if (ptr == 0)
            records[ptr] = record;
        else {

            int x = ptr;
            int i;

            for (i = x-1 ; (i >= 0 && records[i].compareTo(record) > 0) ; i--)
                records[i+1] = records[i];

            records[i+1] = record;
        }

        ptr++;
    }


    public int find(String recordToFind) {

        int mid = 0 , lo = 0;
        int hi = records.length-1;

        while (lo <= hi) {

            mid = (lo+hi)/2;

            if (records[mid].getKey().compareToIgnoreCase(recordToFind) == 0)
                break;

            if (records[mid].getKey().compareToIgnoreCase(recordToFind) < 0)
                lo = mid+1;
            else
                hi = mid-1;
        }

        return (records[mid].getKey().compareToIgnoreCase(recordToFind) == 0 ? mid : -1);
    }

    public SongRecord getRec(int ptr) {

        return records[ptr];
    }

    public void delete(SongRecord rec) {

        if (find(rec.getKey()) != -1) {

            ArrayList<SongRecord> newArr = new ArrayList<>();

            for (int i = 0 ; i < records.length ; i++) {

                if (i != find(rec.getKey()))
                    newArr.add(records[i]);
            }

            if (newArr.size() != records.length) {

                SongRecord[] newRec = new SongRecord[newArr.size()];

                for (int i = 0 ; i < newArr.size() ; i++) {
                    newRec[i] = newArr.get(i);
                }

                records = newRec;
            } else
                System.out.println("Song with name \"" + rec.getKey()
                        + "\" was not found.");
        }
    }

    public void display() {

        for (SongRecord record : records)
            System.out.println(record.toString());
    }
}