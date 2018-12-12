public class Population {

    private char[] helloWorld = new char[10];

    private String hey = "helloworld";

    //{h, e, l, l, o, w, o, r, l, d};

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

    private Gene[] pop = new Gene[10];

    private int genNum = 1;

    private int errorNumber = 0;

    private int previousError;

    private boolean perfectSpecies = false;

    private int totImprove = 0;

    private int mutateChance = 20;

    private int avgMutate = 3;

    //constructor

    public Population(){

        for (int i = 0; i < hey.length(); i++) {

            helloWorld[i] = hey.charAt(i);

        }

//        for (int i = 0; i < helloWorld.length; i++) {
//
//            System.out.print(helloWorld[i]);
//
//        }

        System.out.println("Welcome to the Mutation Chamber!");
        System.out.println("Mutation Chance: " + mutateChance + "%");
        System.out.println("Max Mutation: " + (avgMutate - 1)/2 + " letter(s) above or below");
        System.out.println();
        System.out.println("------Generation " + genNum + "------");

        for (int i = 0; i < pop.length; i++){

            pop[i] = new Gene(true);

            pop[i].calcError(helloWorld);

            pop[i].sout();

            errorNumber += pop[i].getError();

        }

        previousError = errorNumber;

        System.out.println("-----Total Error: " + errorNumber + "-----");

        System.out.println("----Average Error: " + ((double)errorNumber/10) + "----");

        System.out.println("----Previous Error: N/A----");

        System.out.println("---Total Error Improvement: N/A---");

        System.out.println("---Average Error Improvement: N/A---");

        mutate();

    }

    //methods

    public void mutate(){

        for (int i = 0; i < pop.length; i++) {

            if(pop[i].getError() == 0){

                perfectSpecies = true;

            }

        }

        if(perfectSpecies){

            System.out.println();
            System.out.println("Congradulations! You have created the ideal species!");
            System.out.println("Generations Taken: " + genNum);
            System.out.println("Average Error Improvement Per Generation: " + (double)totImprove / (double)genNum);

        }
        else{

            errorNumber = 0;

            genNum++;

            System.out.println();

            //beginning of new generation
            System.out.println("------Generation " + genNum + "------");

            Gene temp;

            //sort previous generation (this actually works)
            for (int i = 0; i < pop.length; i++) {

                for (int j = i; j < pop.length; j++) {

                    if(pop[i].getError() < pop[j].getError()){

                        temp = pop[i];

                        pop[i] = pop[j];

                        pop[j] = temp;

                    }
                    
                }

            }

            //print previous generation but sorted
//            for (int i = 0; i < pop.length; i++){
//
//                pop[i].sout();
//
//            }

            char tempChar;

            for (int i = 0; i < pop.length / 2; i++) {

                //create new gene
                pop[i] = new Gene(false);

                for (int j = 0; j < pop[i].getCharLength(); j++) {

                    //basically, this copies the char of the surviving genes, and mutates them a bit
                    tempChar = pop[i+5].getLettersVal(j);

                    //mutate method:

                    //20% chance of mutation
                    if((int)(Math.random() * 100) < mutateChance) {

                        tempChar = (char) ((int) tempChar + (Math.random() * avgMutate - 1));

                    }

                    //boundaries
                    if((int)tempChar > 123){

                        tempChar = (char)122;

                    }
                    else if((int)tempChar < 92){

                        tempChar = (char)92;

                    }

                    //setting the new chars
                    pop[i].setLettersVal(j, tempChar);

                }

            }

            for (int i = 0; i < pop.length; i++) {

                pop[i].calcError(helloWorld);

                pop[i].sout();

                errorNumber += pop[i].getError();

            }

            soutStuff();

            previousError = errorNumber;

            mutate();

        }

    }

    public void soutStuff(){

        System.out.println("-----Total Error: " + errorNumber + "-----");

        System.out.println("----Average Error: " + ((double)errorNumber/10) + "----");

        System.out.println("----Previous Error: " + previousError + "----");

        System.out.println("---Total Error Improvement: " + (previousError - errorNumber) + "---");

        totImprove += (previousError - errorNumber);

    }

}
