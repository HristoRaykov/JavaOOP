package Animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
      this.setName(name);
      this.setAge(age);
      this.setGender(gender);
    }

    public void setName(String name) {
        if(name.length() < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.name = name;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.age = age;
    }

    public void setGender(String gender) {
        if(gender.length() < 1){
            throw new IllegalArgumentException("Invalid input!");
        }
        this.gender = gender;
    }

    public String produceSound(){
        return "Not implemented!";
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(" ").append(this.age).append(" ").append(this.gender)
                .append(System.lineSeparator()).append(produceSound());

        return sb.toString();
    }
}
