package data_structures.hash_table.cuckoo_hash;

import java.util.Random;

public class StringHashFamily implements HashFamily< String > {
    private final int[] MUTIPLIERS;
    private final Random r = new Random();

    public StringHashFamily( int d ) {
        MUTIPLIERS = new int[ d ];
        generateNewFunctions();
    }

    @Override
    public int getNumberOfFunctions() {
        return MUTIPLIERS.length;
    }

    @Override
    public void generateNewFunctions() {
        for ( int i = 0; i < MUTIPLIERS.length; i++ ){
            MUTIPLIERS[ i ] = r.nextInt();
        }
    }

    @Override
    public int hash( String x, int which ) {
        final int multiplier = MUTIPLIERS[ which ];
        int hashVal = 0;

        for ( int i = 0; i < x.length(); i++ ){
            hashVal = multiplier * hashVal + x.charAt( i );
        }
        return hashVal;
    }
}
