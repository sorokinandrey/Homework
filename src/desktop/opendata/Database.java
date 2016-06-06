package desktop.opendata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by stran on 23.05.2016.
 */


public class Database {
    private static Database inst;
    private Map<String, Table> tables;

    private Database(String[] paths) {
        tables = new HashMap<>();
        for (String path : paths) {
            String fileName = path.substring(0, path.lastIndexOf('.'));
            tables.put(fileName, new Table(path));
        }

    }

    public static Database fromCSV(String[] paths) {
        if (inst != null) {
            return inst;
        } else {
            inst = new Database(paths);
            return inst;
        }
    }

    public Table getTable(String table) {
        return tables.get(table);
    }

    public List<Record> getRecords(String table) {
        return getTable(table).getRecords();
    }

    public Map<String, Integer> getHeader(String table) {
        return getTable(table).getHeader();
    }

    public Record getByRecordById(String table, String id) {
        return getTable(table).getByRecordById(id);
    }

    public List<Record> findInColumns(String table, String str, List<String> columns) {
        return getTable(table).findInColumns(str, columns);
    }

    public List<Record> findInColumn(String table, String str, String column) {
        return getTable(table).findInColumn(str, column);
    }

    public List<Record> findInAllColumns(String table, String str) {
        return getTable(table).findInAllColumns(str);
    }

    public int maxPerPage(String table) {
        return getTable(table).size();
    }

    public int maxPage(String table, int perPage) {
        return (int) Math.floor((double) getTable(table).size() / perPage) + 1;
    }

    public List<Record> getPage(String table, int page, int perPage) {
        return getTable(table).getPage(page, perPage);
    }

    // Used to join second table to first by same column
    public List<Record> joinTablesByColumn(String table1, String table2, String column1, String column2) {
        List<Record> resp = new ArrayList<>();
        List<Record> tableData1 = getTable(table1).getRecords();
        for (Record record : tableData1) {
            String joinStr = record.getValue(column1);
            List<Record> found = getTable(table2).findInColumn(joinStr, column2);
            if (!found.isEmpty()) {
                Record joinedRecord = Record.joinRecords(record, found.get(0));
                System.out.println("JOINED" + joinedRecord.toString());
                resp.add(joinedRecord);
            }

        }
        return resp;
    }


}
