package desktop.opendata;

import org.apache.commons.csv.CSVRecord;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by stran on 02.06.2016.
 */

public class Record {
    private Map<String, Integer> mapping;
    private List<String> values;

    public Record(CSVRecord sourceRecord, Map<String, Integer> header) {
        mapping = header;
        String[] array = new String[header.size()];
        try {
            for (Map.Entry<String, Integer> entry : header.entrySet()) {
                array[entry.getValue()] = sourceRecord.get(entry.getKey());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "record " + sourceRecord.toString());
        }
        values = Arrays.asList(array);

    }

    public Record(List<String> vals, Map<String, Integer> header) {
        mapping = header;
        values = vals;
    }

    public Map<String, Integer> getMapping() {
        return mapping;
    }

    public List<String> getValues() {
        return values;
    }

    public String getValue(String key) {
        return values.get(mapping.get(key));
    }

    public String getId() {
        return values.get(0);
    }

    public static Record joinRecords(Record r1, Record r2) {
        List<String> valuesRes = r1.getValues();
        Map<String, Integer> headerRes = r1.getMapping();
        valuesRes.addAll(r2.getValues());
        headerRes.putAll(r2.getMapping());
        return new Record(valuesRes, headerRes);
    }

    @Override
    public String toString() {
        return "Record{" +
                "mapping=" + mapping +
                ", values=" + values +
                '}';
    }
}
