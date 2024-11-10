package week6;

import java.util.Random;

public class NightSky {
    double density;
    int width;
    int height;
    Random random;
    int stars;
    public NightSky(int width, int height) {
        this.width = width;
        this.height = height;
        this.density = 0.1;
        this.random = new Random();
    }

    public NightSky(double density) {
        this.density = density;
        this.random = new Random();
        this.width = 20;
        this.height = 10;
    }

    public NightSky(double density, int width, int height)
    {
        this.density = density;
        this.width = width;
        this.height = height;
        this.random = new Random();
    }

    public void printLine(){

        for(int i = 0; i < width; i++){
            if(random.nextDouble() < density){ System.out.print("*"); stars++;}
            else System.out.print(" ");
        }

    }
    public void print(){

        for(int i = 0; i < height; i++){
            printLine();
        }
    }

    public int starsInLastPrint()
    {
        return stars;
    }

    public static void main(String[] args) {
        //NightSky nightSky = new NightSky(0.1, 40, 10);
       // nightSky.printLine();
        /*NightSky nightSky = new NightSky(8, 4);
        nightSky.print();*/
        NightSky nightSky = new NightSky(8, 4);
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
        System.out.println("");
        nightSky.print();
        System.out.println("Number of stars: " + nightSky.starsInLastPrint());
    }
}
