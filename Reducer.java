package org.apache.hadoop.conf;


public class PokerCardReducer extends Reducer<Text, IntWritable, Text, NullWritable> {

    private static final List<String> fullDeck = generateFullDeck(); 

    public void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
        
        if (!isCardPresent(key.toString())) {
            context.write(new Text(key.toString()), NullWritable.get());
        }
    }

    
    private boolean isCardPresent(String card) {
        for (String fullCard : fullDeck) {
            if (fullCard.equals(card)) {
                return true; 
            }
        }
        return false; 
    }

    
    private static List<String> generateFullDeck() {
        
    }
}
