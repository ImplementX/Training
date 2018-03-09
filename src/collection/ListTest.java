package collection;

import java.util.*;


public class ListTest {
	static Comparator<Integer> c = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			if ((int) o1 < (int) o2)
				return -1;
			else
				return 1;

		}
	};

	public static void main(String[] args) {

		 //aArrayList();
		aLinkedList();
	}

	public static void aLinkedList() {
		List<Integer> link = new LinkedList<Integer>();
		List<Integer> anotherlink = new LinkedList<Integer>();
		link.add(4);
		link.add(2);
		link.add(5);
		link.add(1);
		link.add(3);
		link.add(1);
		link.add(6);
		link.add(7);
		
		anotherlink.add(40);
		anotherlink.add(20);
		anotherlink.add(50);
		anotherlink.add(10);
		anotherlink.add(30);
		anotherlink.add(10);
		anotherlink.add(60);
		anotherlink.add(70);
		ListIterator<Integer> it = link.listIterator();
		while (it.hasNext()) {
			System.out.print(it.next()+"  ");

		}
		System.out.println("\n-------------------------------------------");
		while (it.hasPrevious()) {
			System.out.print(it.previous()+"  ");
		}
		link.sort(c);
		System.out.println("\n-------------------------------------------");
		while (it.hasNext()) {
			System.out.print(it.next()+"  ");

		}
		System.out.println("\n-------------------------------------------");
		//link.clear();
		System.out.println("是否含有20 "+link.contains(20));
		link.addAll(anotherlink);
		//link.remove(link.indexOf(20));
		//link.removeAll(anotherlink);
		System.out.println("是否含有10 "+link.contains(20));
		System.out.println("位于第"+(link.indexOf(20)+1)+"位");
		it = link.listIterator();
		
		while (it.hasNext()) {
			System.out.print(it.next()+"  ");

		}
		

	}

	public static void aArrayList() {

		List<Integer> list = new ArrayList<Integer>();

		list.add(6);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(1);

		for (int x : list) {
			System.out.print(x+"  ");
		}
		// for (int x = 0; x < list.size(); x++) {
		// System.out.println(list.get(x));
		// }
		System.out.println("\n-------------------------------------------------------------");

		 list.sort(c);
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+"  ");
		}
	}

}
