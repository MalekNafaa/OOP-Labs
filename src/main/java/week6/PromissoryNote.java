package week6;

import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> promissoryNote;

    PromissoryNote() {
    this.promissoryNote = new HashMap<>();
    }

    public void setLoan(String name,double value){
        this.promissoryNote.put(name,value);
    }

    public double howMuchIsTheDebt(String name){
        return this.promissoryNote.getOrDefault(name,0.0);
    }

    public static void main(String[] args) {
        PromissoryNote mattisNote = new PromissoryNote();
        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);
        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
    }
}
