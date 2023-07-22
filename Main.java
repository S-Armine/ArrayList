import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //creating ArrayList and checking is it empty
        ArrayList<Integer> arr = new ArrayList<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("arr: " + arr.toString());
        System.out.println("arr size: " + arr.size());
        System.out.println("arr capacity: " + arr.capacity());
        System.out.println();
        ArrayList<String> arr1 = new ArrayList<>();
        System.out.println("arr1" + arr1.toString());
        System.out.println("arr1 size: " + arr1.size());
        System.out.println("arr1 capacity: " + arr1.capacity());
        System.out.println();
        System.out.println("Is arr1 empty?: " + arr1.isEmpty() + "   Is arr empty?" + arr.isEmpty());

        //adding and removing elements to ArrayList
        arr.add(11);
        arr.add(2, 4);
        System.out.println("arr: " + arr.toString());
        System.out.println("arr size: " + arr.size());
        System.out.println("arr capacity: " + arr.capacity());
        System.out.println();
        System.out.println("Removed element is: " + arr.remove(3));
        System.out.println("Was element removed: " + arr.remove(Integer.valueOf(9)));
        System.out.println("arr: " + arr.toString());
        System.out.println("arr size: " + arr.size());
        System.out.println("arr capacity: " + arr.capacity());
        System.out.println();
        System.out.println("Was element removed? " + arr.remove(Integer.valueOf(16)));
        System.out.println("arr: " + arr.toString());
        System.out.println("arr size: " + arr.size());
        System.out.println("arr capacity: " + arr.capacity());
        System.out.println();

        //get and set moethods
        arr1.add("1st");
        arr1.add("2nd");
        arr1.add("3rd");
        System.out.println("arr1: " + arr1.toString());
        System.out.println("arr1[1] " + arr1.get(1));
        System.out.println("arr1[-5] " + arr1.get(-5));
        arr1.set(0, "8th");
        System.out.println("arr1 size: " + arr1.size());
        System.out.println("arr1 capacity: " + arr1.capacity());
        System.out.println();

        //contains, indexOf, lastIndexOf
        System.out.println("Is arr1 contains 2nd? " + arr1.contains("2nd"));
        System.out.println("Index of 1st: " + arr1.indexOf("1st"));
        System.out.println("Last index of 4 in arr: " + arr.lastIndexOf(4));
        System.out.println();

        //clear, subList, addAll, removeAll
        arr1.clear();
        System.out.println("arr1 size: " + arr1.size());
        System.out.println("arr1 capacity: " + arr1.capacity());
        System.out.println("arr1: " + arr1.toString());
        System.out.println();
        List<Integer> list = arr.subList(3,7);
        System.out.println("Sublist of arr: " + list.toString());
        List<Integer> larr = new ArrayList(11,12,13,14);
        arr.addAll(larr);
        System.out.println("arr size:" + " " + arr.size());
        System.out.println("arr capacity: " + arr.capacity());
        System.out.println("arr after adding list: " + arr.toString());
        System.out.println();
        larr = new ArrayList<>(15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29);
        arr.addAll(8,larr);
        System.out.println("arr size:" + " " + arr.size());
        System.out.println("arr capacity: " + arr.capacity());
        System.out.println("arr after adding list: " + arr.toString());
        System.out.println();
        arr.removeAll(larr);

        System.out.println("arr size:" + " " + arr.size());
        System.out.println("arr capacity: " + arr.capacity());
        System.out.println("arr after removing list: " + arr.toString());
        System.out.println();

        //retainAll, containsAll, hashcode, equals, toArray
        larr = new ArrayList<>(1, 4, 11, 12, 13, 14);
        System.out.println(arr.retainAll(larr));
        System.out.println("arr: " + arr.toString());
        System.out.println();
        System.out.println("Does arr contain [1, 4, 12, 13, 14]: " + arr.containsAll(larr));
        larr.add(100);
        System.out.println("Does arr contain [1, 4, 12, 13, 14, 100]: " + arr.containsAll(larr));
        System.out.println();
        Object[] array = arr.toArray();
        System.out.println("array: " + Arrays.toString(array));
        System.out.println();
        String[] a = new String[16];
        Integer[] b = new Integer[16];
        Integer[] c = new Integer[3];
        System.out.println(Arrays.toString(arr.toArray(a)));
        System.out.println(Arrays.toString(arr.toArray(b)));
        System.out.println(Arrays.toString(arr.toArray(c)));

    }
}



