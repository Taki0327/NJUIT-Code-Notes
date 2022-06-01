public class Fruit
{

}

class Apple extends Fruit
{

}

class Orange extends Fruit
{

}

class GoldenDelicious extends Apple
{

}

class Macintosh extends Apple
{

}

 class TestFruit {
    public static void main(String[] args) {
        Fruit fruit = new GoldenDelicious();
        Orange orange = new Orange();
        System.out.println(fruit instanceof Fruit);
        System.out.println(fruit instanceof Orange);
        System.out.println(fruit instanceof Apple);
        System.out.println(fruit instanceof GoldenDelicious);
        System.out.println(fruit instanceof Macintosh);
        System.out.println(orange instanceof Orange);
        System.out.println(orange instanceof Fruit);
        //System.out.println(orange instanceof Apple);
    }
}
