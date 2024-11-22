public class Main {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        textEditor.init();

        textEditor.addCharacter(0, 0, 'g', "Cambria", 17, true, true);
        textEditor.addCharacter(1, 0, 'y', "Century Gothic", 14, true, true);
        textEditor.addCharacter(1, 1, 'h', "Courier New", 22, false, false);
        textEditor.addCharacter(1, 2, 'y', "Georgia", 14, false, false);

        System.out.println(textEditor.getStyle(0, 0));
        System.out.println(textEditor.readLine(0));

        textEditor.addCharacter(0, 0, 'q', "Arial", 21, false, true);

        System.out.println(textEditor.readLine(0));
        System.out.println(textEditor.readLine(1));

        System.out.println(textEditor.deleteCharacter(1, 1));
        System.out.println(textEditor.readLine(1));
        System.out.println(textEditor.deleteCharacter(1, 4));


    }
}