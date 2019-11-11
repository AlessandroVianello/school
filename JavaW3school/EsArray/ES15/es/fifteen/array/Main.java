package es.fifteen.array;

public class Main {

    public static class findElement {
        private int str;

        public findElement(int str) {
            this.str = str;
        }

        public int[] find(int[] array1, int[] array2) {
            int[] elements = new int[array1.length];
            for (int i = 0; i < array1.length; i++) {
                for (int k = 0; k < array2.length; k++) {
                    if (array1[i] == array2[k])
                        elements[i] = array2[k];
                }
            }
            return elements;
        }
    }

        public static void main(String[] args) {
            int[] s1, s2, res;
            int min,max,range;
            max=3;min=0;
            range=max-min+1;   //range del Math.random()
            s1 = new int[3];
            s2 = new int[3];

            for (int i = 0; i < s1.length; i++) {
                s1[i] = (int) (Math.random() * 10);
                s2[i] = (int) (Math.random() * 10);
            }

            findElement find = new findElement(s1[(int) ((Math.random() * range) - 1)]);
            res = find.find(s1, s2);

            for (int i = 0; i < res.length; i++) {
                System.out.print(s1[i]);
            }
            System.out.println();
            for (int i = 0; i < res.length; i++) {
                System.out.print(s2[i]);
            }
            System.out.println();
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i]);
            }
    }
}
