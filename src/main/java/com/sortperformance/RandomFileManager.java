package com.sortperformance;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RandomFileManager {
    private String path = "./src/main/java/com/sortperformance/Data.txt";

    public void saveRandomNumbers(int count) throws IOException {
        File file = new File(path);
        FileWriter writer = new FileWriter(file);
        RandomGenerator randomGenerator = new RandomGenerator();
        ArrayList<SortItem> numbers = randomGenerator.generate(count);

        for (int index = 0; index < numbers.size(); index++) {
            writer.write(Integer.toString(numbers.get(index).getValue()));
            if (index != (numbers.size() - 1))
                writer.write("\n");
        }

        writer.close();
    }

    public ArrayList<SortItem> readRandomNumbers() throws FileNotFoundException {
        File file = new File(path);
        Scanner reader = new Scanner(file);
        ArrayList<SortItem> data = new ArrayList<SortItem>();

        while (reader.hasNextLine()) {
            String value = reader.nextLine().trim();
            data.add(new SortItem(Integer.valueOf(value)));
        }
        reader.close();

        return data;
    }
}
