package data_structures.heap.skew_heap;

import data_structures.exceptions.UnderflowException;
//斜堆，未测试
public class SkewHeap < AnyType extends Comparable<? super AnyType>>{
    private Node< AnyType > root;

    private static class Node< AnyType > {
        public Node( AnyType theElement ) {
            this( theElement, null, null );
        }

        public Node( AnyType theElement, Node< AnyType > lt, Node< AnyType > rt ) {
            element = theElement;
            left = lt;
            right = rt;
        }

        AnyType element;
        Node< AnyType > left;
        Node< AnyType > right;

        
    }


    public SkewHeap() {
        root = null;
    }

    public void merge( SkewHeap< AnyType > rhs ) {
        if ( this == rhs ) {
            return;
        }
        root = merge( root, rhs.root );
        rhs.root = null;
    }

    public void insert( AnyType x ) {
        root = merge( new Node< AnyType >( x ), root );
    }

    public AnyType findMin() {
        return root.element;
    }

    public AnyType deleteMin() throws UnderflowException {
        if ( isEmpty() ) {
            throw new UnderflowException();
        }
        AnyType minItem = root.element;
        root = merge( root.left, root.right );
        return minItem;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }


    private Node< AnyType > merge( Node< AnyType > h1, Node< AnyType > h2 ) {
        if ( h1 == null ) {
            return h2;
        }
        if ( h2 == null ) {
            return h1;
        }
        if ( h1.element.compareTo( h2.element ) < 0 ) {
            return mergeHelper( h1, h2 );
        } else {
            return mergeHelper( h2, h1 );
        }
    }

    private Node< AnyType > mergeHelper( Node< AnyType > smaller, Node< AnyType > bigger ) {
        if ( smaller.left == null ) {
            smaller.left = bigger;
        } else {
            smaller.right = merge( smaller.right, bigger );
            swapChildren( smaller );
        }

        return smaller;
    }

    private void swapChildren( Node< AnyType > t ) {
        Node< AnyType > tmp = t.left;
        t.left = t.right;
        t.right = tmp;
    }
}
