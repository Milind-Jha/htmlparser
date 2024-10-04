package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App {
    public static void main(String[] args) {
        try {
            // Step 1: Fetch and parse the HTML page
            String url = "https://www.techpowerup.com/cpu-specs/?mfgr=Intel&released=2023&server=No&sort=name"; 
            Document doc = Jsoup.connect(url).get();  // Fetch and parse the HTML

            // Step 2: Select all rows in the CPU specs table
            Elements cpuRows = doc.select("table tbody tr");  // Adjust the selector to match your HTML structure
            int results = 0;
            // Step 3: Loop through each row and extract the required data
            for (Element row : cpuRows) {
                // Extracting CPU name
                String cpuName = row.select("td a").text();  // Link text for CPU name

                // Extracting other specifications
                String architecture = row.select("td:nth-child(2)").text(); // Architecture
                String coresThreads = row.select("td:nth-child(3)").text(); // Cores/Threads
                String clockSpeed = row.select("td:nth-child(4)").text(); // Clock Speed
                String socket = row.select("td:nth-child(5)").text(); // Socket
                String process = row.select("td:nth-child(6)").text(); // Process
                String l3Cache = row.select("td:nth-child(7)").text(); // L3 Cache
                String tdp = row.select("td:nth-child(8)").text(); // TDP
                String released = row.select("td:nth-child(9)").text(); // Released Date
                if(!l3Cache.isEmpty()){
                    System.out.println("CPU Name: " + cpuName);
                    System.out.println("Architecture: " + architecture);
                    System.out.println("Cores/Threads: " + coresThreads);
                    System.out.println("Clock Speed: " + clockSpeed);
                    System.out.println("Socket: " + socket);
                    System.out.println("Process: " + process);
                    System.out.println("L3 Cache: " + l3Cache);
                    System.out.println("TDP: " + tdp);
                    System.out.println("Released: " + released);
                    System.out.println("-----------------------------------");
                    ++results;
                }
            }
            System.out.println(results);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
