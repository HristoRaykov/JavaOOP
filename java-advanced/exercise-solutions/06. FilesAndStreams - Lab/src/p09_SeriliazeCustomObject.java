import java.io.*;

public class p09_SeriliazeCustomObject {
    public static void main(String[] args) {

        final String objpath = "D:\\object.ser";

        Cube cube = new Cube();

        cube.color = "green";
        cube.width = 15.3;
        cube.height = 12.4;
        cube.depth = 3.0;

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(objpath))) {

            oos.writeObject(cube);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(objpath))) {

           Cube cube1 = (Cube) ois.readObject();
            System.out.println(cube1.color);
            System.out.println(cube1.width);
            System.out.println(cube1.height);
            System.out.println(cube1.depth);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
