package com.jianyi;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class MultiThreadedFileDownloader {
    private static final int BUFFER_SIZE = 8192;
    private static final int NUM_THREADS = 4; // 并发下载线程数
    private static final String FILE_URL = "https://download-cdn.jetbrains.com/idea/ideaIU-2023.2.exe"; // 替换为实际的文件下载链接
    private static final String OUTPUT_FILE = "idea.exe"; // 替换为实际的输出文件名和扩展名

    public static void main(String[] args) {
        try {
            URL url = new URL(FILE_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int fileSize = connection.getContentLength();
            connection.disconnect();

            // 计算每个线程下载的字节范围
            int chunkSize = fileSize / NUM_THREADS;
            int remainingBytes = fileSize % NUM_THREADS;

            Thread[] downloadThreads = new Thread[NUM_THREADS];
            for (int i = 0; i < NUM_THREADS; i++) {
                int startIndex = i * chunkSize;
                int endIndex = startIndex + chunkSize - 1;

                if (i == NUM_THREADS - 1) {
                    // 最后一个线程下载剩余的字节
                    endIndex += remainingBytes;
                }

                downloadThreads[i] = new Thread(new Downloader(FILE_URL, startIndex, endIndex, "part_" + i));
                downloadThreads[i].start();
            }

            // 等待所有线程下载完成
            for (int i = 0; i < NUM_THREADS; i++) {
                downloadThreads[i].join();
            }

            // 将分片文件合并成完整的文件
            mergeFiles(OUTPUT_FILE, NUM_THREADS);

            System.out.println("文件下载完成。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void mergeFiles(String outputFileName, int numParts) throws IOException {
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(outputFileName))) {
            for (int i = 0; i < numParts; i++) {
                String partFileName = "part_" + i;
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(partFileName))) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                // 删除已合并的分片文件
                File partFile = new File(partFileName);
                partFile.delete();
            }
        }
    }

    static class Downloader implements Runnable {
        private final String url;
        private final int startByte;
        private final int endByte;
        private final String fileName;

        public Downloader(String url, int startByte, int endByte, String fileName) {
            this.url = url;
            this.startByte = startByte;
            this.endByte = endByte;
            this.fileName = fileName;
        }

        @Override
        public void run() {
            try {
                URL fileUrl = new URL(url);
                HttpURLConnection connection = (HttpURLConnection) fileUrl.openConnection();
                connection.setRequestProperty("Range", "bytes=" + startByte + "-" + endByte);
                System.out.println(Thread.currentThread().getName()+"长度起始，"+startByte+"结束"+endByte);
                try (InputStream in = connection.getInputStream();
                     BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName))) {
                    byte[] buffer = new byte[BUFFER_SIZE];
                    int bytesRead;
                    while ((bytesRead = in.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                }
                connection.disconnect();
                System.out.println("线程 " + Thread.currentThread().getName() + " 下载完成。");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
