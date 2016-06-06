package desktop.opendata;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;

/**
 * Created by stran on 02.06.2016.
 */
public class Table {
    private List<Record> records;
    private Map<String, Integer> header;
    private boolean fullCmp = false;

    public Table(String path) {
        Reader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(
                    new FileInputStream(path), "UTF-8"));

            CSVParser parser = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
            header = new LinkedHashMap<>(parser.getHeaderMap());
            records = new ArrayList<>();
            for (CSVRecord rec : parser) {
                records.add(new Record(rec, header));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setFullCmp(boolean newValue) {
        fullCmp = newValue;
    }

    public boolean isFullCmp() {
        return fullCmp;
    }


    public List<Record> getRecords() {
        return records;
    }

    public Map<String, Integer> getHeader() {
        return header;
    }


    public Record getByRecordById(String id) {
        for (Record record : records) {
            if (record.getId().equals(id)) {
                System.out.println("FOUND " + record.toString());
                return record;
            }
        }
        return null;
    }

    public boolean isInColumn(Record record, String str, String column) {
        if (fullCmp) {
            return record.getValue(column).contains(str);
        }
        return record.getValue(column).equals(str);
    }

    public List<Record> findInColumns(String str, List<String> columns) {
        List<Record> resp = new ArrayList<>();
        for (Record record : records) {
            for (String column : columns) {
                if (isInColumn(record, str, column)) {
                    System.out.println("FOUND " + record.toString());
                    resp.add(record);
                    break;
                }
            }
        }
        return resp;
    }

    public List<Record> findInColumn(String str, String column) {
        return findInColumns(str, Collections.singletonList(column));
    }

    public List<Record> findInAllColumns(String str) {
        List<String> headerList = new ArrayList<>(header.keySet());
        return findInColumns(str, headerList);
    }

    public int size() {
        return records.size();
    }

    public List<Record> getPage(int page, int perPage) {
        int numberOfRecords = size();
        if (perPage == -1 || perPage > numberOfRecords) {
            return records;
        }
        return records.subList(perPage * page - 1, perPage * (page + 1) - 1);
    }

    public JSONArray toJSON() {
        JSONArray res = new JSONArray();
        for (Record record : records) {
            JSONArray row = new JSONArray(record.getValues());
            res.put(row);
        }
        return res;
    }


}
