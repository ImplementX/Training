package data_structures.heap;

import data_structures.exceptions.UnderflowException;
//小顶堆
public class BinaryHeap< AnyType extends Comparable< ? super AnyType > > {
    public BinaryHeap() {
        this( DEFAULT_CAPACITY );
    }

    public BinaryHeap( int capacity ) {
        currentSize = 0;
        array = (AnyType[]) new Comparable[ capacity + 1 ];
    }

    public BinaryHeap( AnyType[] items ) {
        currentSize = items.length;
        array = ( AnyType[] ) new Comparable[ ( currentSize + 2 ) * 11 / 10 ];

        int i = 1;
        for ( AnyType item : items ) {
            array[ i++ ] = item;
        }

        buildHeap();
    }

    public void insert( AnyType x ) {
        if ( currentSize == array.length - 1 ) {
            enlargeArray( array.length * 2 + 1 );
        }

        int hole = ++currentSize;
        for ( array[ 0 ] = x; x.compareTo( array[ hole / 2 ] ) < 0; hole /= 2 ) {
            array[ hole ] = array[ hole / 2 ];
        }
        array[ hole ] = x;
    }

    public AnyType findMin() throws UnderflowException {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return array[ 1 ];
    }

    public AnyType deleteMin() throws UnderflowException {
        if ( isEmpty() ) {
            throw new UnderflowException();
        }

        AnyType minItem = findMin();
        array[ 1 ] = array[ currentSize-- ];
        percolateDown( 1 );
        return minItem;
    }

    public boolean isEmpty() {
         return currentSize == 0;
    }

    public void makeEmpty() {
        for ( int i = 0; i < array.length; i++ ) {
            array[ i ] = null;
        }
        currentSize = 0;
    }

    private static final int DEFAULT_CAPACITY = 10;

    private int currentSize;

    private AnyType[] array;
//  下滤
    private void percolateDown( int hole ) {
        int child;
        AnyType tmp = array[ hole ];
//      向下层次迭代，下滤hole
        for ( ; hole * 2 <= currentSize; hole = child ) {
//          初始化左子节点
            child = hole * 2;
//          比较左右子节点大小，选择较小的子节点
            if ( child != currentSize && array[ child + 1 ].compareTo( array[ child ] ) < 0 ) {
                child++;
            }
//          比较子节点和hole节点大小，若小则交换
            if ( array[ child ].compareTo( tmp ) < 0 ) {
                array[ hole ] = array[ child ];
            } else {
                break;
            }
        }
//        将原节点的值填入最终合适的位置
        array[ hole ] = tmp;
    }


    private void buildHeap() {
        //初始化i为最后一个节点的父节点,开始下滤
        for ( int i = currentSize / 2; i > 0; i-- ) {
            percolateDown( i );
        }
    }

    private void enlargeArray( int newSize ) {
        AnyType [] old = array;
        array = (AnyType []) new Comparable[ newSize ];
        for( int i = 0; i < old.length; i++ )
            array[ i ] = old[ i ];
    }

    public static void main( String [ ] args ) throws UnderflowException {
        int numItems = 10000;
        BinaryHeap<Integer> h = new BinaryHeap<>( );
        int i = 37;

        for( i = 37; i != 0; i = ( i + 37 ) % numItems )
            h.insert( i );
        for( i = 1; i < numItems; i++ )
            if( h.deleteMin( ) != i )
                System.out.println( "Oops! " + i );
    }
}
