package org.zuinnote.examplemapreduce.TweetCount;
 import java.io.IOException;
 import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.io.*;
import java.util.*;

public class MyTweetReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    public void reduce(Text key, Iterable<IntWritable> values, Context context) 
      throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable val : values) {
            sum += val.get();
        }
        context.write(key, new IntWritable(sum));
    }
 }
