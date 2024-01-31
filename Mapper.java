

public static class Mapper extends Mapper<LongWritable, Text, Text, IntWritable>
{
    private Text cardKey;
    private IntWritable cardValue;
    
    public Mapper() {
        this.cardKey = new Text();
        this.cardValue = new IntWritable(1);
    }
    
    public void map(final LongWritable longWritable, final Text text, final Mapper.Context context) throws IOException, InterruptedException {
        int i = 0;
        final String[] array = { "HEARTS", "DIAMONDS", "SPADES", "CLUBS" };
        while (i < 4) {
            this.cardKey.set(array[i]);
            this.cardValue.set(0);
            context.write((Object)this.cardKey, (Object)this.cardValue);
            ++i;
        }
        final String[] split = text.toString().split("\t");
        this.cardKey.set(split[0]);
        this.cardValue.set(Integer.parseInt(split[1]));
        context.write((Object)this.cardKey, (Object)this.cardValue);
    }
}
