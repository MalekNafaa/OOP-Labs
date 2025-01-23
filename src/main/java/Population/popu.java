package Population;

import java.io.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class popu {
    public static void main(String[] args) {
        ThirdFinal fi  = new ThirdFinal( "192.168.56.1",12345);
        CustomFileWriter cfw = new CustomFileWriter();
        cfw.writeReport("newfile.cvs",fi.getPop());
    }
}


enum CaseFormatter{
    ORDINARY,UPPER_CASE,LOWER_CASE
}
enum NumberFormatter{
    COMMA,PERCENTAGE
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface WriteConcerns{
    CaseFormatter case_format() default CaseFormatter.ORDINARY;
    NumberFormatter number_format() default NumberFormatter.COMMA;
}

class Population{
    private int rank;
    @WriteConcerns(case_format = CaseFormatter.UPPER_CASE)
    private String code;
    private String country;
    @WriteConcerns(case_format = CaseFormatter.LOWER_CASE)
    private String continent;
    @WriteConcerns(number_format = NumberFormatter.COMMA)
    private int population2023;
    @WriteConcerns(number_format = NumberFormatter.COMMA)
    private int population2022;
    private int population2020;
    private double area;
    private int density;
    @WriteConcerns(number_format = NumberFormatter.PERCENTAGE)
    private double growthRate;
    private double worldPercentage;

    Population(PopulationBuilder b)
    {
        this.rank=b.rank;
        this.code=b.code;
        this.country=b.country;
        this.continent=b.continent;
        this.population2023=b.population2023;
        this.population2022=b.population2022;
        this.population2020=b.population2020;
        this.area=b.area;
        this.density=b.density;
        this.growthRate=b.growthRate;
        this.worldPercentage=b.worldPercentage;
    }

    static class PopulationBuilder{
        private int rank;
        private String code;
        private String country;
        private String continent;
        private int population2023;
        private int population2022;
        private int population2020;
        private double area;
        private int density;
        private double growthRate;
        private double worldPercentage;

        PopulationBuilder(){

        }
        public PopulationBuilder setRank(int rank){
            this.rank=rank;
            return this;
        }
        public PopulationBuilder setCode(String code){
            this.code=code;
            return this;
        }
        public PopulationBuilder setCountry(String country){
            this.country=country;
            return this;
        }
        public PopulationBuilder setContinent(String continent){
            this.continent=continent;
            return this;
        }
        public PopulationBuilder setPopulation2023(int population2023){
            this.population2023=population2023;
            return this;
        }
        public PopulationBuilder setPopulation2022(int population2022){
            this.population2022=population2022;
            return this;
        }
        public PopulationBuilder setPopulation2020(int population2020){
            this.population2020=population2020;
            return this;
        }
        public PopulationBuilder setArea(double area){
            this.area=area;
            return this;
        }
        public PopulationBuilder setDensity(int density){
            this.density=density;
            return this;
        }
        public PopulationBuilder setGrowthRate(double growthRate){
            this.growthRate = growthRate;
            return this;
        }
        public PopulationBuilder setWorldPercentage(double worldPercentage){
            this.worldPercentage=worldPercentage;
            return this;
        }
        public Population build(){
            return new Population(this);
        }

    }
}

class WrongFormatException extends RuntimeException{
    WrongFormatException(String message,Throwable cause){
        super(message,cause);
    }
    WrongFormatException(String message){
        super(message);
    }

}


class ThirdFinal{
    private List<Population> pop =new ArrayList<>();

    public ThirdFinal(String ipAddress,int port){
        this.pop = loadPopulation(ipAddress,port);
    }

    public List<Population> getPop(){
        return pop;
    }
    static List<Population> loadPopulation(String ipAddress,int port){
        List<Population> pop= new ArrayList<>();

        try {
            Socket socket = new Socket(ipAddress,port);
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            List<String> lines = input.lines().collect(Collectors.toList());

            for(int i=1;i<lines.size();i++){
                String[] info = lines.get(i).split(",");
                if(info[0] == ""| info[1] ==""|info[2] ==""){
                    throw new WrongFormatException("Values are empty",new ClassCastException());
                }
                pop.add(    new Population.PopulationBuilder()
                        .setRank(Integer.parseInt(info[0]))
                        .setCode(info[1])
                        .setCountry(info[2])
                        .setContinent(info[3])
                        .setPopulation2023(Integer.parseInt(info[4]))
                        .setPopulation2022(Integer.parseInt(info[5]))
                        .setPopulation2020(Integer.parseInt(info[6]))
                        .setArea(Double.parseDouble(info[7]))
                        .setDensity(Integer.parseInt(info[8]))
                        .setGrowthRate(Double.parseDouble(info[9]))
                        .setWorldPercentage(Double.parseDouble(info[10]))
                        .build());

            }
            input.close();
            socket.close();
        }catch(IOException e){
            throw new RuntimeException(e);
        }
        return pop;
    }
}

class CustomFileWriter{
    static void writeReport(String outputFileName,List<Population> pop){

        try {


            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
            Field[] fields = Population.class.getDeclaredFields();

            for(int i=0;i<fields.length;i++){
                writer.write(
                        fields.length-1 == i ? fields[i].getName().toUpperCase().concat("\n"): fields[i].getName().toUpperCase().concat(";")
                );
            }

            for(Population pops :pop){
                for(int i =0 ;i<fields.length;i++){
                    fields[i].setAccessible(true);
                    if(fields[i].isAnnotationPresent(WriteConcerns.class)){
                        if(fields[i].get(pops) instanceof String){
                            CaseFormatter cs = fields[i].getAnnotation(WriteConcerns.class).case_format();

                            switch (cs) {

                                case LOWER_CASE -> writer.write(
                                        fields.length-1 == i ? fields[i].get(pops).toString().toLowerCase().concat("\n"):
                                                fields[i].get(pops).toString().toLowerCase().concat(";")
                                );
                                case UPPER_CASE -> writer.write(
                                        fields.length-1 == i ? fields[i].get(pops).toString().toUpperCase().concat("\n"):
                                                fields[i].get(pops).toString().toLowerCase().concat(";")
                                );
                                case ORDINARY -> writer.write(
                                        fields.length-1 == i ? fields[i].get(pops).toString().concat("\n"):
                                                fields[i].get(pops).toString().concat(";")
                                );


                            }
                        }
                        else {
                            NumberFormatter nf = fields[i].getAnnotation(WriteConcerns.class).number_format();

                            if(nf == NumberFormatter.COMMA){
                                DecimalFormat df = new DecimalFormat("#,###.##");
                                writer.write( fields.length-1 ==i ? df.format(fields[i].get(pops)).concat("\n"):
                                        df.format(fields[i].get(pops)).concat(";")
                                );

                            }
                            else{ writer.write(
                                    fields.length-1 == i ?
                                            "%".concat(fields[i].get(pops).toString()).concat("\n"):
                                            "%".concat(fields[i].get(pops).toString()).concat(";")
                            );


                            }


                        }
                    }
                    writer.write(
                            fields.length-1 == i ? fields[i].get(pops).toString().concat("\n"):
                                    fields[i].get(pops).toString().concat(";")
                    );

                }
            }
            writer.close();
        }catch(IOException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }


}
