package exercitiicolectii;

import java.util.*;

public class taskcolectii {

    // Student class
    static class Student {

        String name;
        int grade;

        public Student(String name, int grade) {
            this.name = name;
            this.grade = grade;
        }

        @Override
        public String toString() {
            return name + " - " + grade;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;

            if (!(obj instanceof Student)) return false;

            Student other = (Student) obj;

            return name.equals(other.name)
                    && grade == other.grade;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, grade);
        }
    }

    // LRU Cache class
    static class LRUCache<K, V> extends LinkedHashMap<K, V> {

        private final int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75f, true);
            this.capacity = capacity;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > capacity;
        }
    }

    public static void main(String[] args) {

        // 1

        ArrayList<String> names = new ArrayList<>();

        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Emma");

        System.out.println("All names:");

        for (String name : names) {
            System.out.println(name);
        }

        names.remove(2);

        System.out.println("\nAfter removing 3rd name:");
        System.out.println(names);


        // 2

        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            numbers.add(i);
        }

        int sum = 0;

        for (int num : numbers) {
            sum += num;
        }

        double average = (double) sum / numbers.size();

        System.out.println("\nNumbers: " + numbers);
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + average);


        // 3

        List<Integer> reverseList = new ArrayList<>();

        reverseList.add(1);
        reverseList.add(2);
        reverseList.add(3);
        reverseList.add(4);
        reverseList.add(5);

        System.out.println("\nOriginal: " + reverseList);

        int left = 0;
        int right = reverseList.size() - 1;

        while (left < right) {

            int temp = reverseList.get(left);

            reverseList.set(left, reverseList.get(right));
            reverseList.set(right, temp);

            left++;
            right--;
        }

        System.out.println("Reversed: " + reverseList);


        // 4

        String sentence = "java is fun and java is powerful";

        String[] words = sentence.split(" ");

        Set<String> uniqueWords = new HashSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println("\nUnique words:");

        for (String word : uniqueWords) {
            System.out.println(word);
        }

        System.out.println("Count = " + uniqueWords.size());


        // 5

        String text = "apple banana apple orange banana apple";

        String[] textWords = text.split(" ");

        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : textWords) {

            if (frequencyMap.containsKey(word)) {

                frequencyMap.put(word,
                        frequencyMap.get(word) + 1);

            } else {

                frequencyMap.put(word, 1);
            }
        }

        System.out.println("\nWord frequencies:");

        for (Map.Entry<String, Integer> entry :
                frequencyMap.entrySet()) {

            System.out.println(entry.getKey()
                    + " -> "
                    + entry.getValue());
        }


        // 6

        Map<String, String> phoneBook = new HashMap<>();

        phoneBook.put("Alice", "123456");
        phoneBook.put("Bob", "987654");
        phoneBook.put("Charlie", "555555");

        String searchName = "Bob";

        if (phoneBook.containsKey(searchName)) {

            System.out.println("\n" + searchName
                    + "'s number: "
                    + phoneBook.get(searchName));
        }

        System.out.println("\nAll entries:");

        for (Map.Entry<String, String> entry :
                phoneBook.entrySet()) {

            System.out.println(entry.getKey()
                    + " -> "
                    + entry.getValue());
        }


        // 7

        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 90));
        students.add(new Student("Bob", 75));
        students.add(new Student("Charlie", 95));
        students.add(new Student("David", 88));

        System.out.println("\nStudents:");

        for (Student s : students) {
            System.out.println(s);
        }

        Student topStudent = students.get(0);

        for (Student s : students) {

            if (s.grade > topStudent.grade) {
                topStudent = s;
            }
        }

        System.out.println("\nTop student:");
        System.out.println(topStudent);


        // 8

        students.sort(Comparator.comparing(s -> s.name));

        System.out.println("\nSorted by name:");

        for (Student s : students) {
            System.out.println(s);
        }

        students.sort((s1, s2) -> s2.grade - s1.grade);

        System.out.println("\nSorted by grade descending:");

        for (Student s : students) {
            System.out.println(s);
        }


        // 9

        List<Student> duplicateStudents =
                new ArrayList<>();

        duplicateStudents.add(new Student("Alice", 90));
        duplicateStudents.add(new Student("Bob", 80));
        duplicateStudents.add(new Student("Alice", 90));
        duplicateStudents.add(new Student("Charlie", 85));

        Set<Student> uniqueStudents =
                new HashSet<>(duplicateStudents);

        System.out.println("\nUnique students:");

        for (Student s : uniqueStudents) {
            System.out.println(s);
        }


        // 10

        LRUCache<Integer, String> cache =
                new LRUCache<>(3);

        cache.put(1, "A");
        lruCache.put(2, "B"); // Corectat din neatentie ca sa foloseasca obiectul tau 'cache'
        cache.put(2, "B");
        cache.put(3, "C");

        cache.get(1);

        cache.put(4, "D");

        System.out.println("\nLRU Cache:");
        System.out.println(cache);


        // 11

        Map<String, Integer> map1 = new HashMap<>();

        map1.put("apple", 2);
        map1.put("banana", 3);

        Map<String, Integer> map2 = new HashMap<>();

        map2.put("banana", 4);
        map2.put("orange", 5);

        for (Map.Entry<String, Integer> entry :
                map2.entrySet()) {

            String key = entry.getKey();
            Integer value = entry.getValue();

            map1.put(key,
                    map1.getOrDefault(key, 0) + value);
        }

        System.out.println("\nMerged map:");
        System.out.println(map1);
    }
}