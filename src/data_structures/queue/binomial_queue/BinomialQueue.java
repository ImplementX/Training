package data_structures.queue.binomial_queue;

public class BinomialQueue< AnyType extends Comparable< ? super AnyType > > {
    public BinomialQueue() {
    }

    public BinomialQueue( AnyType item ) {

    }

    public void merge( BinomialQueue< AnyType > rhs ) {

    }

    public void insert( AnyType x ) {
        merge( new BinomialQueue<>( x ) );
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public void makeEmpty() {

    }

    private static class Node< AnyType > {
        public Node( AnyType theElement ) {
            this( theElement, null, null );
        }

        public Node( AnyType theElement, Node< AnyType > lt, Node< AnyType > rt ) {
            element = theElement;
            lt = leftChild;
            rt = nextSibling;
        }

        AnyType element;
        Node< AnyType > leftChild;
        Node< AnyType > nextSibling;
    }

    private static final int DEFAULT_TREES = 1;
    private int currentSize;
    private Node< AnyType >[] theTrees;

    private void expandTheTrees( int newNumTrees ) {

    }

    private Node< AnyType > combineTrees( Node< AnyType > smaller, Node< AnyType > bigger ) {
        if ( smaller.element.compareTo( bigger.element ) > 0 ) {
            return combineTrees( bigger, smaller );
        }
        bigger.nextSibling = smaller.leftChild;
        smaller.leftChild = bigger;
        return smaller;
    }

    private int capacity() {
        return ( 1 << theTrees.length ) - 1;
    }

    private int findMinIndex() {

    }
}
