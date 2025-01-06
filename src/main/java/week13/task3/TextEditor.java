package week13.task3;

public class TextEditor {
    TextFormatter textformatter;

    void setFormatter(TextFormatter textformatter){
        this.textformatter=textformatter;
    }
    public void formatText(String text){
        if(textformatter == null)
        {
            throw new IllegalStateException();
        }
        textformatter.formatText(text);
    }
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.setFormatter(new UpperCaseFormatter());
        editor.formatText("Hello, Strategy Pattern!");

        editor.setFormatter(new LowerCaseFormatter());
        editor.formatText("Hello, Strategy Pattern!");

        editor.setFormatter(new CamelCaseFormatter());
        editor.formatText("Hello, Strategy Pattern!");
    }
}
