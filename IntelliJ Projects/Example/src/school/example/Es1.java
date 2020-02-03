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

        public Dog(int w, String c) {
            super(w);
            color=c;
        }
        @Override
        public void eat(Animal a){
            weight += a.weight;
        }
    }

    public static void main(String[] args) {
        Dog fido = new Dog(15, "Bruno");
        Dog baldo = new Dog(15, "Bianco");
        Animal Jackie = new Dog(5, "Nero");
    }

}
