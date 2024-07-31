import java.util.ArrayList;
import java.util.List;

public class MergingSortedLists {
    public static List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> list3 = new ArrayList<>();
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                list3.add(list1.get(i));
                i++;
            } else {
                list3.add(list2.get(j));
                j++;
            }
        }
        while (i < list1.size()) {
            list3.add(list1.get(i));
            i++;
        }
        while (j < list2.size()) {
            list3.add(list2.get(j));
            j++;
        }

        return list3;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(13);
        list1.add(25);
        list1.add(29);
        List<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(14);
        list2.add(26);
        list2.add(87);
        List<Integer> mergedList = mergeTwoLists(list1, list2);
        System.out.println(mergedList);
    }
}

