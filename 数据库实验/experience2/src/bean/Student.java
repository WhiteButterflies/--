package bean;

public class Student {
    public String Sno;
    public String Sname;
    public String sex;
    public int Age;
    public String Sdept;

    public Student(String sno, String sname, String sex, int age, String sdept) {
        Sno = sno;
        Sname = sname;
        this.sex = sex;
        Age = age;
        Sdept = sdept;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"Sno\":\"")
                .append(Sno).append('\"');
        sb.append(",\"Sname\":\"")
                .append(Sname).append('\"');
        sb.append(",\"sex\":\"")
                .append(sex).append('\"');
        sb.append(",\"Age\":")
                .append(Age);
        sb.append(",\"Sdept\":\"")
                .append(Sdept).append('\"');
        sb.append('}');
        return sb.toString();
    }

    public String getSno() {
        return Sno;
    }

    public void setSno(String sno) {
        Sno = sno;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getSdept() {
        return Sdept;
    }

    public void setSdept(String sdept) {
        Sdept = sdept;
    }
}
