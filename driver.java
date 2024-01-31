package org.apache.hadoop.conf;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class driver {
    public static void main(String[] args) {
        try {
            
            String inputPath = "file:///C:/Users/Sree/Desktop/INPUT-1.txt";
            String outputPath = "file:///C:/output";

            Configuration conf = new Configuration();
            conf.set("fs.defaultFS", "file:///"); 

            Job job = Job.getInstance(conf, "Poker Card Identification");

            
            FileInputFormat.addInputPath(job, new Path(inputPath));
            FileOutputFormat.setOutputPath(job, new Path(outputPath));

            
            System.exit(job.waitForCompletion(true) ? 0 : 1);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
