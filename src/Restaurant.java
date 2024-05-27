// Restaurant.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Table> tables;

    public Restaurant(String name) {
        this.name = name;
        this.tables = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Table> getTables() {
        return tables;
    }

    public void addTable(Table table) {
        tables.add(table);
    }

    public void removeTable(Table table) {
        tables.remove(table);
    }

    public void saveState(String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Table table : tables) {
                writer.write(table.toString());
                writer.newLine();
            }
        }
    }

    public void restoreState(String fileName) throws IOException {
        tables.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int tableNumber = Integer.parseInt(parts[0]);
                int capacity = Integer.parseInt(parts[1]);
                tables.add(new Table(tableNumber, capacity));
            }
        }
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", tables=" + tables +
                '}';
    }
}

