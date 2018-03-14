package data_structures.tree.AVL;


public class AvlTree<AnyType extends Comparable> {


    private static final int ALLOWED_IMBALANCE = 1;
    private AvlNode<AnyType> root;


    private static class  AvlNode<AnyType> {
    AnyType element;
    AvlNode<AnyType> left;
    AvlNode<AnyType> right;
    int height;

    AvlNode(AnyType data) {
        this(data, null, null);
    }

    AvlNode(AnyType data, AvlNode<AnyType> lt, AvlNode<AnyType> rt) {
        element = data;
    }
}

    public AvlTree() {
        this.root = null;
    }

    public AvlNode<AnyType> getRoot() {
        return root;
    }

    public AnyType findMax(){
        return findMax(root).element;
    }

    public AnyType findMin(){
        return findMin(root).element;
    }

    public int height(){
      return  height(root);
    }

    public void insert(AnyType data){
        root =  insert(data,root);
    }

    public void checkBalance(){
        checkBalance(root);
    }

    public void printTree(){
        printTree(root);
    }

    public Boolean contains(AnyType data){
        return contains(data,root);
    }

    public void remove(AnyType data){
        root = remove(data,root);
    }

    public Boolean isEmpty(){
        return root == null;
    }

    public void makeEmpty(){
        root = null;
    }


    private int height(AvlNode<AnyType> t) {
        return t == null ? -1 : t.height;
    }

    private AvlNode<AnyType> findMin(AvlNode<AnyType> t){

        if(t == null){
            return t; // not found; do nothing
        }
        while(t.left != null ){
            t = t.left;
        }
        return t;
    }

    private AvlNode<AnyType> findMax(AvlNode<AnyType> t){
        if(t == null){
            return t;
        }
        while(t.right != null ){
            t = t.right;
        }
        return t;
    }


    private Boolean contains(AnyType data, AvlNode<AnyType> t){
        while( t != null ){
            int compareResult = data.compareTo(t.element);
            if( compareResult > 0 ){
                t = t.right;
            }
            else if ( compareResult < 0 ){
                t = t.left;
            }
            else  {
                return true;
            }

        }

        return false;
    }


    private AvlNode<AnyType> insert(AnyType data, AvlNode<AnyType> t){
        if(t == null){
            return new AvlNode<>(data,null,null);
        }

        int compareResult = data.compareTo(t.element);

        if (compareResult < 0){
            t.left = insert(data,t.left);
        }

        else if(compareResult > 0){
            t.right = insert(data,t.right);
        }

        else {
            //duplicate; do nothing
        }

        return balance(t);

    }

    private AvlNode<AnyType> balance(AvlNode<AnyType> t) {
        if (t == null) {
            return t;

        }

        if(height(t.left)- height(t.right) > ALLOWED_IMBALANCE){
            if( height(t.left.left) >= height(t.left.right)){
                t = rotateWithLeftChild(t);
            }
            else{
                t = doubleWithLeftChild(t);
            }
        }

        else if( height(t.right) - height(t.left) > ALLOWED_IMBALANCE){
            if(height(t.right.right) >= height(t.right.left)){
                t = rotateWithRightChild(t);
            }
            else{
                t = doubleWithRightChild(t);
            }
        }

        t.height = Math.max( height(t.left), height(t.right))+1;
        return t;
    }

    private int checkBalance(AvlNode<AnyType> t){
        if(t == null ){
            return -1;
        }
        if(t != null){
            int lh = checkBalance( t.left );
            int rh = checkBalance( t.right );
            if(Math.abs( height( t.left ) - height( t.right ) ) > 1 || height( t.left ) != lh || height( t.right ) !=rh ){
                System.out.println( "not balanced!" );
            }
            else
                System.out.println( "accept!" );
        }

        return height(t);
    }

    private void printTree( AvlNode<AnyType> t){
        printTree(t.left);
        System.out.println(t.element);
        printTree(t.right);
    }


    //当向左儿子的左子树做插入
    //右旋 顺时针旋转
    private AvlNode<AnyType> rotateWithLeftChild(AvlNode<AnyType> t){
        AvlNode<AnyType> upNode = t.left;
        t.left = upNode.right;
        upNode.right = t;
        t.height = Math.max(height(t.left),height(t.right))+1;
        upNode.height = Math.max(height(upNode.left),t.height)+1;
        return upNode;
    }

    //当向右儿子的右子树做插入
    //左旋 逆时针旋转
    private AvlNode<AnyType> rotateWithRightChild(AvlNode<AnyType> t){
        AvlNode<AnyType> upNode = t.right;
        t.right = upNode.left;
        upNode.left = t;
        t.height = Math.max(height(t.left),height(t.right))+1;
        upNode.height = Math.max(t.height,height(upNode.right))+1;
        return  upNode;
    }

    //当向左儿子的右子树做插入
    //对左儿子左旋
    //对根节点右旋
    private AvlNode<AnyType> doubleWithLeftChild(AvlNode<AnyType> t){
        t.left = rotateWithRightChild(t.left);
        return rotateWithLeftChild(t);
    }
    //当向右儿子的左子树做插入
    //对右儿子右旋
    //对根节点左旋
    private AvlNode<AnyType> doubleWithRightChild(AvlNode<AnyType> t){
        t.left = rotateWithLeftChild(t.left);
        return rotateWithRightChild(t);
    }



    private AvlNode<AnyType> remove(AnyType data, AvlNode<AnyType> t){
        if(t == null){
            return t; //not found;   do nothing
        }
        int compareResult = data.compareTo(t.element);
        if(compareResult < 0) {
            t.left = remove(data, t.left);
        }
        else if(compareResult > 0){
            t.right = remove(data, t.right);
        }
        else if(t.left != null && t.right != null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }else{
            t = (t.left != null)?t.left:t.right;
        }
        return balance(t);
    }


    public static void main(String[] args) {
        AvlTree<Integer> t = new AvlTree( );
        final int SMALL = 40;
        final int NUMS = 1000000;  // must be even
        final int GAP  =   37;

        System.out.println( "Checking... (no more output means success)" );

        for( int i = GAP; i != 0; i = ( i + GAP ) % NUMS )
        {
            //    System.out.println( "INSERT: " + i );
            t.insert( i );
            if( NUMS < SMALL )
                t.checkBalance( );
        }

        for( int i = 1; i < NUMS; i+= 2 )
        {
            //   System.out.println( "REMOVE: " + i );
            t.remove( i );
            if( NUMS < SMALL )
                t.checkBalance( );
        }
        if( NUMS < SMALL )
            t.printTree( );
        if( t.findMin( ) != 2 || t.findMax( ) != NUMS - 2 )
            System.out.println( "FindMin or FindMax error!" );

        for( int i = 2; i < NUMS; i+=2 )
            if( !t.contains( i ) )
                System.out.println( "Find error1!" );

        for( int i = 1; i < NUMS; i+=2 )
        {
            if( t.contains( i ) )
                System.out.println( "Find error2!" );
        }
    }

}
