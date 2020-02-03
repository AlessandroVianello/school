package school.example;

public class Es1 {
    public static class Animal{
        protected int weight;

        public Animal(int weight){
            this.weight=weight;
        }

        public void eat(Animal a){
            weight += a.weight;
        }
    }

    public static class Dog extends Animal{
        private String color;

        public Dog(int weight, String c) {
            super(weight);
            color=c;
        }
        @Override
        public void eat(Animal a){
            weight += a.weight/2;
        }

        public void bark(){
            System.out.println("woof");
        }

    }

    public static class Cat extends Animal{
        private String color;

        public Cat(int weight, String color) {
            super(weight);
            this.color=color;
        }

        @Override
        public void eat(Animal a){
            weight += a.weight/3;
            color = color + " fat";
        }

        public void meow(){
            System.out.println("meow");
        }

    }

    public static void main(String[] args) {
        Dog fido = new Dog(15, "Bruno");
        Dog baldo = new Dog(15, "Bianco");
        Animal jackie = new Dog(5, "Nero");
        Cat selena = new Cat(4, "Grigio");

        selena.eat(fido);

    }

}
