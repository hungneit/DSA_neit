
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */
class Student {
    private String name;
    private int id;
    private double cgpa;
    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }
}

class Priorities {
    PriorityQueue<Student> pq = new PriorityQueue<>(new StudentComparator());
    public List<Student> getStudents(List<String> event) {
        for (String e:event) {
            String[] w = e.split("\\s");
            if (w[0].equals("SERVED")) {
                pq.poll();
            }
            else {
                int i = Integer.parseInt(w[3]);
                Student st = new Student(i, w[1], Double.parseDouble(w[2]));
                pq.add(st);
            }
        }
        List<Student> l = new ArrayList<>();
        while (!pq.isEmpty()) {
            l.add(pq.poll());
        }
        return l;
    }
}
class StudentComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getCgpa() > s2.getCgpa()) {
            return -1;
        } 
        else if (s1.getCgpa() < s2.getCgpa()) {
            return 1;
        }
        if (!s1.getName().equals(s2.getName())) {
            return s1.getName().compareTo(s2.getName());
        }
        return s1.getId() - s2.getId();
    }
}
