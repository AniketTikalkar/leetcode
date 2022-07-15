
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PracticeCollections {
    public static void main(String[] args) {
        //minheap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<10;i++){
            pq.add(i);
        }
        Iterator<Integer> it = pq.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }

        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }

        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<10;i++){
            pq2.add(i);
        }
        while(!pq2.isEmpty()){
            System.out.println(pq2.poll());
        }

        PriorityQueue<String> pq3 = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2){
                if(o1.length() < o2.length()){
                    return -1;
                }
                if(o1.length() > o2.length()){
                    return 1;
                }
                return 0;
            }
        });
        pq3.add("sadgsbkmafpomb[p");
        pq3.add("ssgsd");
        pq3.add("s");
        System.out.println(pq3.poll());

        Deque<Integer> deq = new LinkedList<>();
        deq.addFirst(1);
        deq.addFirst(2);
        deq.addLast(6);
        deq.addLast(9);
        System.out.println(deq.getFirst());
        System.out.println(deq.getLast());
        Iterator<Integer> it2 = deq.iterator();
        while(it2.hasNext()){
            System.out.println(it2.next());
        }
        while(!deq.isEmpty()){
            System.out.println(deq.removeFirst());
            System.out.println(deq.removeLast());
        }

        int arr[] = {3,22,67,-12,98,845};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int arr2[] = {3,22,67,-12,98,845};
        Arrays.sort(arr2,1,4);
        System.out.println(Arrays.toString(arr2));
        // Arrays.sort(arr, Collections.reverseOrder());
        
        int ind =  Arrays.binarySearch(arr, 0, 6, 67);
        System.out.println(ind);
        ind = Arrays.binarySearch(arr, 0, 6, 14);
        System.out.println(ind);
        List<Integer> list = Arrays.asList(23,12,90,-33,-45);
        Collections.sort(list);
    
        ind = Collections.binarySearch(list, 4);
        System.out.println(ind);

        //if list sorted in descending order
        Collections.sort(list,Collections.reverseOrder());
        ind = Collections.binarySearch(list, 25,Collections.reverseOrder());
        System.out.println(ind);

        // Deque<Integer> deque = new LinkedList<Integer>();
        // for(int i=0;i<5;i++){
        //     deque.addFirst(i);
        // }
        // for(int i=10;i<15;i++){
        //     deque.addLast(i);
        // }
        // for(Iterator itr = deque.descendingIterator();itr.hasNext();){
        //     System.out.print(itr.next());
        // }
        // System.out.println();
        // for(int i=0;i<3;i++){
        //     System.out.print(deque.getFirst());
        //     deque.removeFirst();
        // }
        // System.out.println();
        // for(int i=0;i<3;i++){
        //     System.out.print(deque.getLast());
        //     deque.removeLast();
        // }
        // System.out.println();;
        // for(Iterator itr = deque.descendingIterator();itr.hasNext();){
        //     System.out.print(itr.next());
        // }
    }
}
