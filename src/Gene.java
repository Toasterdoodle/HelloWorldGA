public class Gene {

    /**
     a = 97
     b = 98
     c = 99
     d = 100
     e = 101
     f = 102
     g = 103
     h = 104
     i = 105
     j = 106
     k = 107
     l = 108
     m = 109
     n = 110
     o = 111
     p = 112
     q = 113
     r = 114
     s = 115
     t = 116
     u = 117
     v = 118
     w = 119
     x = 120
     y = 121
     z = 122
     **/

    private char[] letters = new char[10];

    private int error;

    //constructor

    public Gene(boolean initial){

        if(initial) {

            int temp;

            for (int i = 0; i < letters.length; i++) {

                temp = (int) (Math.random() * 26 + 1);

                letters[i] = (char) (temp + 96);

            }

        }//if this is the first time
        else{



        }

    }

    //methods

    public void sout(){

        System.out.print("[");

        for (int i = 0; i < 5; i++) {

            System.out.print(letters[i]);

        }

        System.out.print(", ");

        for (int i = 5; i < letters.length - 1; i++) {

            System.out.print(letters[i]);

        }

        System.out.print(letters[letters.length - 1]);

        System.out.println("] Error: " + error);

    }

    public void calcError(char[] key){

        error = 0;

        if(key.length == letters.length){

            int temp;

            for (int i = 0; i < key.length; i++) {

                temp = (Math.abs((int)key[i] - (int)letters[i]));

                error = error + temp;

            }

        }
        else{

            System.out.println("Error: key length and letters length do not match!");

        }

    }

    public int getError(){

        return error;

    }

    public char getLettersVal(int index){

        return letters[index];

    }

    public void setLettersVal(int index, char character){

        letters[index] = character;

    }

    public int getCharLength(){

        return letters.length;

    }

}
