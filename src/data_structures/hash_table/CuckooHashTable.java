package data_structures.hash_table;

import java.util.Random;

//布谷鸟散列
public class CuckooHashTable<AnyType> {
    public CuckooHashTable( HashFamily<? super AnyType> hf ){
        this( hf, DEAFAULT_TABLE_SIZE );
    }

    public  CuckooHashTable( HashFamily<? super AnyType> hf, int size ){
        allocateArray( nextPrime(size) );
        doClear();
        hashFunctions = hf;
        numHashFunctions = hf.getNumberOfFunctions();
    }

    public void makeEmpty(){
        doClear();
    }

    public boolean contains( AnyType x ){
        return findPos( x ) != -1;
    }

    private int myhash( AnyType x, int which ){
        int hashVal = hashFunctions.hash( x, which );
        hashVal %= array.length;
        if( hashVal < 0 ){
            hashVal += array.length;
        }
        return hashVal;
    }

    private int findPos( AnyType x ){
        for ( int i = 0; i < numHashFunctions; i++ ){
            int pos = myhash( x, i );
            if( array[ pos ] != null && array[ pos ].equals( x ) ){
                return pos;
            }
        }

        return -1;
    }

    public boolean remove( AnyType x ){
        int pos = findPos( x );
        boolean result = pos != -1;

        if ( result ){
            array[ pos ] = null;
            currentSize--;
        }

        return result;
    }

    public boolean insert(AnyType x){
        if ( contains( x ) ){
            return false;
        }

        if ( currentSize >= array.length * MAX_LOAD ) {
            expand();
        }

        return insertHelper( x );
    }

    private int rehashes = 0;
    private Random r =new Random();
    private boolean insertHelper( AnyType x ){
        final  int COUNT_LIMIT = 100;
        while ( true ){
            int lastPos = -1;
            int pos;
            for ( int count = 0; count < COUNT_LIMIT; count++ ){
                for ( int i = 0; i < numHashFunctions; i++ ){
                    pos = myhash( x, i );

                    if ( array[ pos ] == null ){
                        array[ pos ] = x;
                        currentSize++;
                        return true;
                    }
                }
                //无可用空位置，随机选择进行替换
                int i = 0;
                do {
                    pos = myhash( x, r.nextInt( numHashFunctions ) );
                }while ( pos == lastPos && i++ < 5 );
                //取出原位数据并替换
                AnyType tmp = array[ lastPos = pos ];
                array[ pos ] = x;
                x = tmp;
            }

            if(  ++rehashes > ALLOWED_REHASHES ){
                expand();
                rehashes = 0;
            }
            else{
                rehash();
            }
        }
    }



    private void expand(){
        rehash( (int) ( array.length / MAX_LOAD ));
    }

    private void rehash(){

    }

    private void rehash( int newLength ){
        AnyType [] oldArray = array;
        allocateArray( nextPrime( newLength ) );
        currentSize = 0;
        for ( AnyType str : oldArray ){
            if ( str != null ){
                insert( str );
            }
        }
    }

    private void doClear(){
        currentSize = 0;
        for ( int i = 0; i < array.length; i++)
            array[i] = null;
    }

    private void allocateArray( int arraySize ){
        array =( AnyType[] ) new Object[ arraySize ];
    }

    private int nextPrime( int x ){
        while (true){
            x++;
            if ( isPrime(x) ){
                return x;
            }
        }
    }

    private static boolean isPrime( int num ){
        if( num <= 2 ){
            return true;
        }
        for( int temp = 2; temp < Math.sqrt( num ) + 1; temp++ ){
            if( num % temp == 0 ){
                return false;
            }
        }
        return true;
    }

    private static final double MAX_LOAD = 0.4;

    private static final int ALLOWED_REHASHES = 1;

    private static final int DEAFAULT_TABLE_SIZE = 101;

    private final HashFamily<? super AnyType> hashFunctions;

    private final int numHashFunctions;

    private AnyType [] array;

    private int currentSize;




}
