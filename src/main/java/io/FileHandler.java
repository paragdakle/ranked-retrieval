package main.java.io;


import main.java.filter.IFilter;
import main.java.utils.Formatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHandler {

    private String filePath;

    private IFilter filter;

    private boolean doFormatInput = false;

    public FileHandler(String filePath) {
        this.filePath = filePath;
        this.filter = null;
    }

    public FileHandler(String filePath, IFilter filter) {
        this.filePath = filePath;
        this.filter = filter;
    }

    public FileHandler(String filePath, IFilter filter, boolean doFormatInput) {
        this.filePath = filePath;
        this.filter = filter;
        this.doFormatInput = doFormatInput;
    }

    public Map<String, String> read() {
        if(filePath.equals("")) {
            return null;
        }
        File file = new File(filePath);
        if(file.isDirectory()) {
            return readDirFiles();
        }
        else {
            return readFile();
        }
    }

    private Map<String, String> readDirFiles() {
        Map<String, String> content = new HashMap<String, String>();
        try {
            File dir = new File(filePath);
            for(File file: dir.listFiles()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line = "";
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    if(doFormatInput) {
                        line = Formatter.formatInput(line);
                    }
                    if (filter == null) {
                        builder.append(line.trim()).append("\n");
                    } else {
                        line = filter.filter(line.trim());
                        if(!line.equals("")) {
                            builder.append(filter.filter(line.trim()));
                        }
                    }
                    builder.append(" ");
                }
                reader.close();
                content.put(file.getName(), builder.toString());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    private Map<String, String> readFile() {
        Map<String, String> content = new HashMap<String, String>();
        try {
            File file = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = "";
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                if(doFormatInput) {
                    line = Formatter.formatInput(line);
                }
                if (filter == null) {
                    builder.append(line.trim());
                } else {
                    line = filter.filter(line.trim());
                    if(!line.equals("")) {
                        builder.append(filter.filter(line.trim()));
                    }
                }
                builder.append(" ");
            }
            reader.close();
            content.put(file.getName(), builder.toString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public Map<String, String> getDirFileHeadlines() {
        Map<String, String> content = new HashMap<>();
        try {
            File dir = new File(filePath);
            Pattern pattern = Pattern.compile("<TITLE>(.*?)</TITLE>");
            for(File file: dir.listFiles()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));

                String line;
                StringBuilder builder = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
                reader.close();
                Matcher matcher = pattern.matcher(builder.toString());
                if(matcher.find()) {
                    content.put(file.getName(), matcher.group(1));
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
